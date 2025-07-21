package org.rdutta.ezflight.domain.dto;

import java.time.LocalTime;

public record FlightsDto(
        int flightNumber,
        String flightName,
        String from,
        String to,
        LocalTime startTime,
        LocalTime endTime,
        String brandName
) {}