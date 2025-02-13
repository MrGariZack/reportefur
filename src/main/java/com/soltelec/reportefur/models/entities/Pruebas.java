package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Pruebas {
    @Id
    @Column("Id_Pruebas")
    private Integer idPruebas;

    @Column("Fecha_prueba")
    private LocalDateTime fechaPrueba;

    @Column("Tipo_prueba_for")
    private Integer tipoPruebaFor;

    @Column("Fecha_final")
    private LocalDateTime fechaFinal;

    @Column("hoja_pruebas_for")
    private Integer hojaPruebasFor;

    @Column("usuario_for")
    private Integer usuarioFor;

    @Column("id_tipo_aborto")
    private Integer idTipoAborto;

    @Column("Autorizada")
    private String autorizada;

    @Column("Aprobada")
    private String aprobada;

    @Column("Finalizada")
    private String finalizada;

    @Column("Abortada")
    private String abortada;

    @Column("Fecha_aborto")
    private String fechaAborto;

    @Column("Comentario_aborto")
    private String comentarioAborto;

    @Column("serialEquipo")
    private String serialEquipo;

    @Column("Pista")
    private Short pista;

    @Column("observaciones")
    private String observaciones;

    @Column("equipo")
    private Integer equipo;
}
