package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;

@Data
public class ClasesVehiculo {
    @Id
    @Column("CLASS")
    private Integer id;

    @Column("Nombre_clase")
    private String nombreClase;

}
