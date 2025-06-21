package com.ecomarket.ecomarket.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
@Table(name = "COMUNA")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Comuna {
    

    @Id
    @Column(name = "ID_COMUNA")
    private Integer idComuna;

    @Column(name = "NOMBRE_COMUNA", nullable = false, length = 200)
    private String nombreComuna;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_REGION", nullable = false)
    @JsonIgnoreProperties("comunas")
    private Region region;

    @OneToMany(mappedBy = "comuna", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("comuna")
    private List<Sucursal> sucursales;

}
