package org.rdutta.ezflight.api.request;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

public class FlightRequestBody {
    @NotNull(message = "flightName - Should not be null")
    private String flightName;
    @NotNull(message = "from - Should not be null")
    private String from;
    @NotNull(message = "to - Should not be null")
    String to;
    @NotNull(message = "startTime - Should not be null")
    LocalTime startTime;
    @NotNull(message = "endTime - Should not be null")
    LocalTime endTime;
    @NotNull(message = "brandName - Should not be null")
    String brandName;
}
