package com.ecomarket.ecomarket.repository;

import com.ecomarket.ecomarket.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

    List<Region> findByIdRegion(Integer idRegion);

    List<Region> findByNombreRegionContainingIgnoreCase(String nombreRegion);
}