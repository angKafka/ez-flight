package org.rdutta.ezflight.infrastructure.mappers;

import org.rdutta.ezflight.api.response.FlightResponse;
import org.rdutta.ezflight.domain.dto.FlightsDto;
import org.rdutta.ezflight.domain.model.Brand;
import org.rdutta.ezflight.domain.model.Flights;
import org.springframework.stereotype.Component;

@Component
public class FlightsMapper {
    public static FlightsDto mapToDto(Flights flight) {
        return new FlightsDto(
                flight.getFlightNumber(),
                flight.getFlightName(),
                flight.getFrom(),
                flight.getTo(),
                flight.getStartTime(),
                flight.getEndTime(),
                flight.getBrand().getBrandName()
        );
    }

    public static Flights mapToEntity(FlightsDto dto) {
        Flights flight = new Flights();
        flight.setFlightNumber(dto.flightNumber());
        flight.setFlightName(dto.flightName());
        flight.setFrom(dto.from());
        flight.setTo(dto.to());
        flight.setStartTime(dto.startTime());
        flight.setEndTime(dto.endTime());

        // Brand creation (you may replace this with a brandService or lookup later)
        Brand brand = new Brand();
        brand.setBrandName(dto.brandName());
        flight.setBrand(brand);

        return flight;
    }

    public static FlightResponse toResponse(Flights flight) {
        return new FlightResponse(
                flight.getFlightNumber(),
                flight.getFlightName(),
                flight.getFrom(),
                flight.getTo(),
                flight.getStartTime(),
                flight.getEndTime(),
                flight.getBrand().getBrandName()  // only brand name
        );
    }
}
