package org.rdutta.ezflight.domain.service;

import org.rdutta.ezflight.domain.dto.BrandsDto;
import org.rdutta.ezflight.domain.model.Brand;

import java.util.List;

public interface BrandsService {
    Brand getBrandById(int id);
    List<Brand> getAllBrands();
    Brand createBrand(BrandsDto brandDto);
    void deleteBrand(int id);
}