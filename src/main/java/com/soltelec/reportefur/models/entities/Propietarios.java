package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Propietarios {
    @Id
    @Column("CAROWNER")
    private Long nIdentificacion;

    @Column("Tipo_identificacion")
    private String tipoIdentificacion;

    @Column("Apellidos")
    private String apellidos;

    @Column("Nombres")
    private String nombres;

    @Column("GEUSER")
    private Integer geuser;

    @Column("fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column("Numero_telefono")
    private String numeroTelefono;

    @Column("email")
    private String email;

    @Column("celular")
    private String celular;

    @Column("Direccion")
    private String direccion;

    @Column("CITY")
    private Integer ciudad;


    @Column("Numero_licencia")
    private String numeroLicencia;

    @Column("Tipo_licencia")
    private String tipoLicencia;
}
