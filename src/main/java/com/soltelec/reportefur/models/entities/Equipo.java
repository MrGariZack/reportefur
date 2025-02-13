package com.soltelec.reportefur.models.entities;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table("equipos")
public class Equipo {

    @Column("id")
    private Integer idEquipo;

    @Column("NomEquipo")
    private String nomEquipo;

    @Column("marca")
    private String marca;

    @Column("Modelo")
    private String modelo;

    @Column("pef")
    private Integer pef;

    @Column("serial")
    private String serial;

    @Column("num_analizador")
    private String numAnalizador;

    @Column("serialresolucion")
    private String serialResolucion;

    @Column("resolucionambiental")
    private String resolucionAmbiental;

    @Column("Pista")
    private Integer pista;

    @Column("serial2")
    private String serial2;

    @Column("sonometro")
    private String sonometro;

    @Column("serie")
    private String serie;

    @Column("tipo")
    private String tipo;

    @Column("estado")
    private Boolean estado;

    @Column("Cod_Interno")
    private String codInterno;

    @Column("ltoe")
    private String ltoe;

    @Column("num_serial_bench")
    private String numSerialBench;

    @Column("periferico")
    private String periferico; // Enum: 'Y' o 'N'

    @Column("puerto_serial")
    private String puertoSerial;

    @Column("ip")
    private String ip;
}