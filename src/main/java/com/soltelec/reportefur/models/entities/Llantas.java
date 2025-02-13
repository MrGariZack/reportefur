package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;


@Data
@Table("llantas")
public class Llantas {
    @Id
    @Column("WHEEL")
    private Integer id;

    @Column("Nombre_llanta")
    private String nombreLlanta;

    @Column("Radio_llanta")
    private Double radioLlanta;

}

