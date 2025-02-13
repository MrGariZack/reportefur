package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table("defectos")
public class Defectos {

    @Id
    @Column("CARDEFAULT")
    private Integer carDefault;

    @Column("Codigo_Super")
    private String codigoSuper;

    @Column("codigo_Resolucion")
    private String codigoResolucion;

    @Column("Nombre_problema")
    private String nombreProblema;

    @Column("Tipo_defecto")
    private String tipoDefecto;

    @Column("tipo_vehiculo")
    private Integer tipoVehiculo;

    @Column("particion_vehiculo")
    private Integer particionVehiculo;

    @Column("tipo_miga")
    private Integer tipoMiga;

    @Column("consecutivo_defecto")
    private Integer consecutivoDefecto;

    @Column("DEFGROUPSSUB")
    private Integer defGroupsSub;

    @Column("TESTTYPE")
    private Integer testType;

    @Column("grupo")
    private String grupo;
}
