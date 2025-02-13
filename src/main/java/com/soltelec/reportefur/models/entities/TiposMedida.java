package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;

@Data
public class TiposMedida {
    @Id
    @Column("MEASURETYPE")
    private Integer measureType;

    @Column("TESTTYPE")
    private Integer testType;

    @Column("Nombre_medida")
    private String nombreMedida;

    @Column("Descripcion_medida")
    private String descripcionMedida;

    @Column("Unidad")
    private String unidad;
}