package com.ecomarket.ecomarket.repository;

import com.ecomarket.ecomarket.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Byte> {

    List<Departamento> findByIdDepartamento(Byte idDepartamento);

    List<Departamento> findByNombreDepartamentoContainingIgnoreCase(String nombreDepartamento);

    List<Departamento> findByCargoContainingIgnoreCase(String cargo);
}