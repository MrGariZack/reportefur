package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HojaPruebas {
    @Id
    @Column("TESTSHEET")
    private Integer id;
    
    @Column("Vehiculo_for")
    private Integer idVehiculo;
    
    @Column("Propietario_for")
    private Long idPropietario;
    
    @Column("Usuario_for")
    private Integer idUsuario;
    
    @Column("Hoja_activa_activeflag")
    private String activateFlag;
    
    @Column("Finalizada")
    private String finalizada;
    
    @Column("Impreso")
    private String impreso;
    
    @Column("Fecha_ingreso_vehiculo")
    private LocalDateTime fechaIngreso;
    
    @Column("Anulado")
    private String anulado;
    
    @Column("Aprobado")
    private String aprobado;
    
    @Column("Fecha_expiracion_revision")
    private LocalDateTime fechaExpiracionRevision;
    
    @Column("fecha_exp_soat")
    private LocalDateTime fechaExpedicionSoat;
    
    @Column("fecha_venc_soat")
    private LocalDateTime fechaVencimientoSoat;
    
    @Column("nro_soat")
    private String numeroSoat;
    
    @Column("fk_aseguradora")
    private Integer idAseguradora;
    
    @Column("Conductor")
    private Long idConductor;
    
    @Column("Consecutivo_resolucion")
    private String consecutivoResolucion;
    
    @Column("Cerrada")
    private String cerrada;
    
    @Column("Fecha_expedicion_certificados")
    private LocalDateTime fechaExpedicionCertificados;
    
    @Column("Comentarios_cda")
    private String comentariosCda;
    
    @Column("Nombre_foto")
    private String nombreFoto;
    
    @Column("Numero_intentos")
    private Integer numeroIntentos;
    
    @Column("id_fotos_for")
    private Integer idFotos;
    
    @Column("consecutivo_runt")
    private String consecutivoRunt;
    
    @Column("numero_solicitud")
    private String numeroSolicitud;
    
    @Column("usuario_resp")
    private Integer idResponsable;
    
    @Column("preventiva")
    private String preventiva;
    
    @Column("con_hoja_prueba")
    private Integer numeroHojaPrueba;
    
    @Column("con_preventiva")
    private Integer numeroPreventiva;
    
    @Column("estado")
    private String estado;
    
    @Column("pin")
    private String pin;
    
    @Column("estado_sicov")
    private String estadoSicov;
    
    @Column("forma_med_temp")
    private String temperatura;
    
    @Column("Ubicacion_municipio")
    private String municipio;
    
    @Column("kilometraje_rtm")
    private String kilometrajeRtm;
    
    @Column("fecha_venc_gnv")
    private LocalDateTime fechaVencimientoGnv;
    
    @Column("MetodoMedicionRpm")
    private String metodoMedicionRpm;
    
    @Column("fk_revision")
    private Integer idRevision;
    
    @Column("nro_turno")
    private Integer numeroTurno;

    @Column("furData")
    private byte[] pdf;

    @Column("logWrite")
    private String log;

    public boolean isFinalizada() {
        return finalizada.equalsIgnoreCase("Y") ? true : false;
    }

    public boolean isAprobado() {
        return aprobado.equalsIgnoreCase("Y") ? true : false;
    }

    public boolean isAnulado() {
        return anulado.equalsIgnoreCase("N") ? false : true;
    }

    public void setAnulado(boolean anulado) {
        this.anulado = anulado ? "A" : "N";
    }

    public void setAprobado(boolean aprobado) {
        this.anulado = aprobado ? "Y" : "N";
    }

    public void setFinalizada(boolean finalizada) {
        this.anulado = finalizada ? "Y" : "N";
    }
    
}
