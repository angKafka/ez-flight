package org.rdutta.ezflight.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.rdutta.ezflight.api.response.FlightResponse;
import org.rdutta.ezflight.infrastructure.configuration.prompt.PromptTemplate;
import org.rdutta.ezflight.infrastructure.mappers.FlightsMapper;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.rdutta.ezflight.infrastructure.configuration.prompt.PromptTemplate.buildPrompt;

@Service
public class FlightPromptService {

    private final ChatModel chatModel;
    private final FlightsService service;
    private final ObjectMapper objectMapper;

    @Autowired
    public FlightPromptService(ChatModel chatModel,
                               FlightsService flightsService,
                               ObjectMapper objectMapper) {
        this.chatModel = chatModel;
        this.service = flightsService;
        this.objectMapper = objectMapper;
    }

    public List<FlightResponse> processNaturalFlightRequest(String sentence) {
        List<FlightResponse> responses = Collections.emptyList();
        String promptText = buildPrompt(sentence);

        Prompt prompt = new Prompt(
                promptText,
                OllamaOptions.builder()
                        .model("phi3:mini")
                        .temperature(0.0)
                        .stop(List.of("User:", "Response:"))
                        .build()
        );

        StringBuilder sb = new StringBuilder();
        // Stream response from the model
        chatModel.stream(prompt)
                .doOnNext(response -> sb.append(response.getResult().getOutput().getText()))
                .blockLast();

        String finalOutput = sb.toString();

        System.out.println("Streamed Response:\n" + finalOutput);

        // Extract JSON from response using regex for robustness
        String jsonString = extractJson(finalOutput);

        if (jsonString != null) {
            try {
                // Convert JSON string to Map
                Map<String, String> responseDetails = objectMapper.readValue(
                        jsonString,
                        objectMapper.getTypeFactory().constructMapType(Map.class, String.class, String.class)
                );

                // Parse start time if present
                String startStr = responseDetails.get("start");
                LocalTime startTime = null;
                if (startStr != null && !startStr.isEmpty()) {
                    startTime = LocalTime.parse(startStr, DateTimeFormatter.ofPattern("HH:mm:ss"));
                }

                String from = responseDetails.getOrDefault("from", "");
                String to = responseDetails.getOrDefault("to", "");

                // Search flights based on extracted details
                responses = service.searchFlights(startTime, from, to)
                        .stream()
                        .map(FlightsMapper::toResponse)
                        .toList();

            } catch (JsonProcessingException e) {
                e.printStackTrace();
                // Handle parsing error gracefully
                responses = Collections.emptyList();
            }
        } else {
            // If JSON extraction failed, log and return empty list
            System.err.println("Failed to extract JSON from model response.");
        }

        return responses;
    }

    private String extractJson(String responseText) {
        // Regex pattern to find JSON object
        Pattern pattern = Pattern.compile("\\{[^{}]*\\}", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(responseText);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}