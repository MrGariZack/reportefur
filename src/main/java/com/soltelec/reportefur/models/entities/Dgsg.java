package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("defectos_grupos_sub_grupos")
public class Dgsg {
    @Id
    @Column("id_defecto")
    private Integer idDefecto;

    @Column("id_grupo")
    private Integer idGrupo;

    @Column("id_sub_grupo")
    private Integer idSubGrupo;

    @Column("id_tipo_vehiculo")
    private Integer idTipoVehiculo;

    @Column("id_tipo_prueba")
    private Integer idTipoPrueba;

    @Column("estado")
    private Boolean estado;

    @Column("tercer_estado")
    private Boolean tercerEstado;
}
