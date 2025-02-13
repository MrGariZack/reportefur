package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("marcas")
public class MarcasVehiculo {
    @Id
    @Column("CARMARK")
    private Integer id;

    @Column("Nombre_marca")
    private String nombreMarca;

}
