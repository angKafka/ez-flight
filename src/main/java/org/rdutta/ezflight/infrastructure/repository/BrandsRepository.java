package org.rdutta.ezflight.infrastructure.repository;

import org.rdutta.ezflight.domain.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandsRepository extends JpaRepository<Brand, Integer> {
}
