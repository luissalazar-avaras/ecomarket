package com.ecomarket.ecomarket.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
@Table(name = "DEPARTAMENTO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Departamento {
    @Id
    @Column(name = "ID_DEPARTAMENTO")
    private Byte idDepartamento;

    @Column(name = "NOMBRE_DEPARTAMENTO", nullable = false, length = 200)
    private String nombreDepartamento;

    @Column(name = "CARGO", nullable = false, length = 200)
    private String cargo;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("departamento")
    private List<Empleado> empleados;
}
