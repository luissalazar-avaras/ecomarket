package com.ecomarket.ecomarket.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
@Table(name = "REGION")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Region {
    
    @Id
    @Column(name = "ID_REGION")
    private Integer idRegion;

    @Column(name = "NOMBRE_REGION", nullable = false, length = 200)
    private String nombreRegion;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("region")
    private List<Comuna> comunas;

}
