package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;

@Data
public class Medidas {
    @Id
    @Column("MEASURE")
    private Integer measure;

    @Column("MEASURETYPE")
    private Integer measureType;

    @Column("Valor_medida")
    private Float valorMedida;

    @Column("TEST")
    private Integer test;

    @Column("Condicion")
    private String condicion;

    @Column("Simult")
    private String simult;
}
