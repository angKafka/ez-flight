package org.rdutta.ezflight.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalTime;

@Data
public class SearchRequestBody {

    private String from;
    private String to;
    @JsonFormat(pattern = "HH:mm:ss") // or whatever format your JSON returns
    private LocalTime start; // or LocalDate, LocalTime, etc.

    public SearchRequestBody() {
    }

    @JsonCreator
    public SearchRequestBody(@JsonProperty("from") String from,
                             @JsonProperty("to") String to,
                             @JsonProperty("start") LocalTime start) {
        this.from = from;
        this.to = to;
        this.start = start;
    }

    // getters and setters
}
