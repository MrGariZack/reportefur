package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("tipos_gasolina")
public class TipoCombustible {
    @Id
    @Column("FUELTYPE")
    private Integer id;

    @Column("Nombre_gasolina")
    private String nombreCombustible;

}