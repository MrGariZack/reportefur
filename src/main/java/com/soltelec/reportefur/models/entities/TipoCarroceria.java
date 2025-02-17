package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;

@Data
public class TipoCarroceria {
    @Id
    @Column("id")
    private Integer id;

    @Column("nombre_carroceria")
    private String nombreCarroceria;



}