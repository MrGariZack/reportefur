package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;

@Data
public class Fotos {
    @Id
    @Column("Id_fotos")
    private Integer idFotos;

    @Column("Foto1")
    private byte[] foto1;

    @Column("Foto2")
    private byte[] foto2;

    @Column("id_hoja_pruebas_for")
    private Integer idHojaPruebasFor;

    @Column("numeroRevision")
    private Integer numeroRevision;
}
