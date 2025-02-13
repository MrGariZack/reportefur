package com.soltelec.reportefur.models.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("departamentos")
public class Departamentos {

    @Id
    @Column("id_departamento")
    private Integer idDepartamento;

    @Column("nombre_departamento")
    private String nombreDepartamento;
}