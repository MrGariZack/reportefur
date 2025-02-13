package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;

@Data
public class Colores {
    @Id
    @Column("COLOR")
    private Integer id;

    @Column("Nombre_color")
    private String nombreColor;

}
