package com.ecomarket.ecomarket.repository;

import com.ecomarket.ecomarket.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {

    List<Empleado> findByRunEmpleado(String runEmpleado);

    List<Empleado> findByDepartamentoIdDepartamento(Byte idDepartamento);

    List<Empleado> findByFechaContratoEmpBetween(Date fechaInicio, Date fechaFin);

    List<Empleado> findBySueldoEmp(String sueldoEmp);
}