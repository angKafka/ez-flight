package org.rdutta.ezflight.infrastructure.implementation;

import org.rdutta.ezflight.domain.dto.BrandsDto;
import org.rdutta.ezflight.domain.model.Brand;
import org.rdutta.ezflight.domain.service.BrandsService;
import org.rdutta.ezflight.infrastructure.exceptions.BrandNotFound;
import org.rdutta.ezflight.infrastructure.exceptions.error.BrandError;
import org.rdutta.ezflight.infrastructure.repository.BrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandsServiceImpl implements BrandsService {

    @Autowired
    private BrandsRepository brandsRepository;
    @Override
    public Brand getBrandById(int id) {
        return brandsRepository.findById(id)
                .orElseThrow(() -> new BrandNotFound(BrandError.brandNotFound));
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandsRepository.findAll();
    }

    @Override
    public Brand createBrand(BrandsDto brandDto) {
        return null;
    }

    @Override
    public void deleteBrand(int id) {
    }
}
