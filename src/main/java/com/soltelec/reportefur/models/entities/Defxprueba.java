package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table("defxprueba")
public class Defxprueba {
    @Id
    @Column("id_defecto")
    private Integer idDefecto;

    @Column("id_prueba")
    private Integer idPrueba;

    @Column("Tipo_Defecto")
    private String tipoDefecto;

    @Column("tercer_estado")
    private String tercerEstado;
}
