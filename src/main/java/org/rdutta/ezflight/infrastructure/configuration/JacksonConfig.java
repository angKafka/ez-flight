package org.rdutta.ezflight.infrastructure.configuration;

import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Support Java 8 Date/Time types like LocalDateTime, LocalTime, etc.
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // Enable source location tracking (optional)
        objectMapper.getFactory().enable(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION.mappedFeature());

        return objectMapper;
    }
}