package org.rdutta.ezflight.domain.dto;

import java.util.List;

public record BrandsDto(
        int brandId,
        String brandName,
        List<FlightsDto> flights
) {}
