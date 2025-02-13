package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;
import java.time.LocalDateTime;
import java.sql.Blob;

@Data
public class Usuarios {
    @Id
    @Column("GEUSER")
    private Integer id;

    @Column("Nick_usuario")
    private String nickUsuario;

    @Column("Nombre_usuario")
    private String nombreUsuario;

    @Column("cedula")
    private String cedula;

    @Column("es_administrador")
    private String esAdministrador;

    @Column("Contrasenia")
    private String contrasenia;

    @Column("Fecha_validacion")
    private LocalDateTime fechaValidacion;

    @Column("firma_usuario")
    private Blob firmaUsuario;

    @Column("rol")
    private String rol;

    @Column("ubicacion")
    private Integer ubicacion;
}