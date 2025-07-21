package org.rdutta.ezflight.api.controllers;

import org.rdutta.ezflight.api.request.SearchRequestBody;
import org.rdutta.ezflight.api.response.FlightResponse;
import org.rdutta.ezflight.domain.model.Flights;
import org.rdutta.ezflight.domain.service.FlightPromptService;
import org.rdutta.ezflight.domain.service.FlightsService;
import org.rdutta.ezflight.infrastructure.mappers.FlightsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/flights")
public class FlightDetailsControllers {
    @Autowired
    private FlightsService service;
    @Autowired
    private FlightPromptService promptService;

    @GetMapping("/")
    public ResponseEntity<List<FlightResponse>> getAllFlightDetails() {
        List<FlightResponse> responses = service.getAllFlights()
                .stream()
                .map(FlightsMapper::toResponse)
                .toList();

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/searchFlight")
    public ResponseEntity<List<FlightResponse>> searchAllFlightDetails(String sentence) {
        List<FlightResponse> responses = promptService.processNaturalFlightRequest(sentence);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
