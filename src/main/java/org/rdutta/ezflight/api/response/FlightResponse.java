package org.rdutta.ezflight.api.response;
import java.time.LocalTime;

public record FlightResponse(
        int flightNumber,
        String flightName,
        String from,
        String to,
        LocalTime startTime,
        LocalTime endTime,
        String brandName
) {}