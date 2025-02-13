package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;

@Data
public class Pais {
    @Id
    @Column("codigo")
    private Integer id;

    @Column("Nombre_Pais")
    private String nombrePais;

}
