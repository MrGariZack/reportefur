package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("servicios")
public class Servicios {
    @Id
    @Column("SERVICE")
    private Integer id;

    @Column("Nombre_servicio")
    private String nombreServicio;

    @Column("servicio_super")
    private String servicioSuper;
}
