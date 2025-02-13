package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("lineas_vehiculos")
public class LineasVehiculo {
    @Id
    @Column("CARLINE")
    private Integer id;

    @Column("CARMARK")
    private Integer marcaId;

    @Column("CRLCOD")
    private Integer crlCodId;

    @Column("CRLNAME")
    private String nombreLinea;
}

