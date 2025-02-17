package com.soltelec.reportefur.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Vehiculos {
    @Id
    @Column("CAR")
    private Integer id;
    
    @Column("carroceria")
    private Integer carroceria;
    
    @Column("CARPLATE")
    private String placa;
    
    @Column("CARLINE")
    private Integer linea;
    
    @Column("CARMARK")
    private Integer marca;
    
    @Column("Modelo")
    private Integer modelo;
    
    @Column("diseño")
    private String diseno;
    
    @Column("Cinlindraje")
    private Integer cilindraje;
    
    @Column("SERVICE")
    private Integer servicio;
    
    @Column("CLASS")
    private Integer clase;
    
    @Column("Numero_licencia")
    private String numeroLicencia;
    
    @Column("Numero_ejes")
    private Integer numeroEjes;
    
    @Column("CARTYPE")
    private Integer tipo;
    
    @Column("INDATE")
    private Date fechaActualizacion;
    
    @Column("GEUSER")
    private Integer idUsuario;
    
    @Column("CAROWNER")
    private Integer idPropietario;
    
    @Column("Numero_exostos")
    private Integer numeroExostos;
    
    @Column("Diametro")
    private Integer diametro;
    
    @Column("FUELTYPE")
    private Integer tipoCombustible;
    
    @Column("Tiempos_motor")
    private Integer tiemposMotor;
    
    @Column("Velocidad")
    private Integer velocidad;
    
    @Column("Color")
    private Integer color;
    
    @Column("Numero_SOAT")
    private String numeroSoat;
    
    @Column("INSURING")
    private Integer aseguradora;
    
    @Column("Fecha_registro")
    private Date fechaRegistro;
    
    @Column("Fecha_soat")
    private Date fechaSoat;
    
    @Column("Fecha_exp_soat")
    private Date fechaExpSoat;
    
    @Column("WHEEL")
    private Integer tipoLlanta;
    
    @Column("Nacionalidad")
    private String nacionalidad;
    
    @Column("peso_bruto")
    private Integer pesoBruto;
    
    @Column("SPSERVICE")
    private Integer servicioEspecial;
    
    @Column("Numero_motor")
    private String numeroMotor;
    
    @Column("VIN")
    private String vin;
    
    @Column("pais")
    private Integer pais;
    
    @Column("kilometraje")
    private Integer kilometraje;
    
    @Column("numero_sillas")
    private Integer numeroSillas;
    
    @Column("vidrios_polarizados")
    private String vidriosPolarizados;
    
    @Column("blindaje")
    private String blindaje;
    
    @Column("numero_chasis")
    private String numeroChasis;
    
    @Column("codigo_interno")
    private String codigoInterno;
    
    @Column("esEnsenaza")
    private String esEnsenanza;
    
    @Column("fecha_vencimiento_gnv")
    private LocalDateTime fechaVencimientoGnv;
    
    @Column("conversion_gnv")
    private String conversionGnv;
    
    @Column("potencia")
    private Integer potencia;
    
    @Column("catalizador")
    private String catalizador;
    
    @Column("capacidad_carga")
    private Integer capacidadCarga;
    
    @Column("carroceriaTablet")
    private String carroceriaTablet;
    
    @Column("categoria")
    private Integer categoria;
    
    @Column("nro_serie")
    private String numeroSerie;
    
    @Column("conductor")
    private Long idConductor;

    public boolean isBlindado() {
        return blindaje.equalsIgnoreCase("Y");
    }

    public void setBlindado(boolean blindado) {
        this.blindaje = blindado ? "Y" : "N";
    }

    public boolean isVidriosPolarizados() {
        return vidriosPolarizados.equalsIgnoreCase("Y");
    }

    public void setVidriosPolarizados(boolean polarizados) {
        this.vidriosPolarizados = polarizados ? "Y" : "N";
    }

    public boolean tieneConversionGnv() {
        return conversionGnv != null && conversionGnv.equalsIgnoreCase("Y");
    }

    public void setConversionGnv(boolean conversion) {
        this.conversionGnv = conversion ? "Y" : "N";
    }
}
