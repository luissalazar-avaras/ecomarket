package com.ecomarket.ecomarket.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "SUCURSAL")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Sucursal {
    
    @Id
    @Column(name = "ID_SUCURSAL")
    private Integer idSucursal;

    @Column(name = "DIR_SUCURSAL", length = 1000)
    private String dirSucursal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_COMUNA")
    @JsonIgnoreProperties("sucursales")
    private Comuna comuna;

}
