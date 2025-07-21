package org.rdutta.ezflight.domain.factory;

import org.rdutta.ezflight.domain.dto.FlightsDto;
import org.rdutta.ezflight.domain.model.Flights;
import org.rdutta.ezflight.infrastructure.mappers.FlightsMapper;
import org.springframework.stereotype.Component;

@Component
public class FlightsFactory {
    public static FlightsDto createToDto(Flights flight) {
        return FlightsMapper.mapToDto(flight);
    }

    public static Flights createFlights(FlightsDto flightDto) {
        return FlightsMapper.mapToEntity(flightDto);
    }
}
