package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;

@Data
public class TipoPrueba {
    @Id
    @Column("TESTTYPE")
    private Integer id;

    @Column("Nombre_tipo_prueba")
    private String nombreTipoPrueba;

}