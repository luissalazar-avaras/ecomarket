package com.ecomarket.ecomarket.repository;

import com.ecomarket.ecomarket.model.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Integer> {

    List<Comuna> findByIdComuna(Integer idComuna);

    List<Comuna> findByNombreComunaContainingIgnoreCase(String nombreComuna);

    List<Comuna> findByRegionIdRegion(Integer idRegion);
}