package com.soltelec.reportefur.models.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.util.Date;

@Data
@Table("cda")
public class Cda {

    @Id
    @Column("id_cda")
    private Integer id;

    @Column("nombre")
    private String nombre;

    @Column("NIT")
    private String nit;

    @Column("direccion")
    private String direccion;

    @Column("telefono")
    private String telefono;

    @Column("celular")
    private String celular;

    @Column("RESOLUCION")
    private String resolucion;

    @Column("fecha_resolucion")
    private Date fechaResolucion;

    @Column("codigo")
    private String codigo;

    @Column("nom_resp_certificados")
    private String nomRespCertificados;

    @Column("Certificado_conformidad")
    private String certificadoConformidad;

    @Column("ciudad")
    private String ciudad;

    @Column("consecutivo_apr")
    private String consecutivoApr;

    @Column("divipola")
    private Integer divipola;

    @Column("consecutivo_rep")
    private String consecutivoRep;

    @Column("consecutivo_cert")
    private String consecutivoCert;

    @Column("usuario_resp")
    private Integer usuarioResp;

    @Column("cont_cda")
    private Byte contCda;

    @Column("proveedor_sicov")
    private ProveedorSicov proveedorSicov;

    @Column("usuario_sicov")
    private String usuarioSicov;

    @Column("password_sicov")
    private String passwordSicov;

    @Column("url_servicio_sicov")
    private String urlServicioSicov;

    @Column("url_servicio_sicov2")
    private String urlServicioSicov2;

    @Column("url_servicio_encript")
    private String urlServicioEncript;

    @Column("id_runt")
    private Integer idRunt;

    @Column("cont_test")
    private Integer contTest;

    @Column("clase_cda")
    private String claseCda;

    @Column("correo")
    private String correo;

    @Column("codigo_runt_cda")
    private String codigoRuntCda;

    @Column("codigo_runt_proveedor")
    private String codigoRuntProveedor;

    @Column("orden_bienvenido")
    private String ordenBienvenido;

    @Column("orden_trabajo_titulo")
    private String ordenTrabajoTitulo;

    @Column("orden_contrato")
    private String ordenContrato;

    @Column("orden_version")
    private String ordenVersion;

    @Column("orden_fecha")
    private String ordenFecha;

    @Column("orden_codigo")
    private String ordenCodigo;

    @Column("nombre_software")
    private String nombreSoftware;

    @Column("ip")
    private String ip;

    @Column("dias_expiracion_cuenta_usuario")
    private Integer diasExpiracionCuentaUsuario;

    @Column("CM")
    private String cm;

    @Column("Resolucion_Ambiental")
    private String resolucionAmbiental;

    @Column("Fecha_Resolucion_Ambiental")
    private String fechaResolucionAmbiental;

    @Column("Nro_Expediente_Autoridad_Ambiental")
    private String nroExpedienteAutoridadAmbiental;

    @Column("Total_Eq_Diesel")
    private String totalEqDiesel;

    @Column("Total_Eq_Otto")
    private String totalEqOtto;

    @Column("Total_Eq_4T")
    private String totalEq4t;

    @Column("Total_Eq_2T")
    private String totalEq2t;

    @Column("departamento")
    private String departamento;

    @Column("norma_aplicada")
    private String normaAplicada;
}

enum ProveedorSicov {
    INDRA, CI2, NO_APLICA
}