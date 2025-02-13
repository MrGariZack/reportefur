package com.soltelec.reportefur.models.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("ciudades")
public class Ciudades {

    @Id
    @Column("CITY")
    private Integer id;

    @Column("STATE")
    private Integer departamento;

    @Column("codigo")
    private String codigo;

    @Column("Nombre_ciudad")
    private String nombreCiudad;

    @Column("Ciudad_principal")
    private String ciudadPrincipal;
}