package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;

@Data
public class Grupos {
    @Id
    @Column("DEFGROUP")
    private Integer id;

    @Column("Nombre_grupo")
    private String nombreGrupo;

    @Column("orden")
    private Integer ordenGrupo;
}
