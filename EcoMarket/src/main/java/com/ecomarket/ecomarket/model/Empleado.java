package com.ecomarket.ecomarket.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Entity
@Table(name = "EMPLEADO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Empleado {
    
    @Id
    @Column(name = "RUN_EMPLEADO", nullable = false, length = 12)
    private String runEmpleado;

    @Column(name = "SUELDO_EMP", nullable = false, length = 12)
    private String sueldoEmp;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FEC_CONTRATO_EMP", nullable = false)
    private Date fechaContratoEmp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DEPARTAMENTO", nullable = false)
    @JsonIgnoreProperties("empleados")
    private Departamento departamento;

}
