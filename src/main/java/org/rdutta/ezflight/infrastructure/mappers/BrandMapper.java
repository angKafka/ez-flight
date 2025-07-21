package org.rdutta.ezflight.infrastructure.mappers;

import org.rdutta.ezflight.domain.dto.BrandsDto;
import org.rdutta.ezflight.domain.model.Brand;
import org.rdutta.ezflight.domain.model.Flights;

import java.util.List;
import java.util.stream.Collectors;

public class BrandMapper {
    public static Brand toEntity(BrandsDto dto){
        List<Flights> flights = dto.flights().stream()
                .map(FlightsMapper::mapToEntity)
                .toList();
        return new Brand(
                dto.brandId(),
                dto.brandName(),
                flights
        );
    }
}
