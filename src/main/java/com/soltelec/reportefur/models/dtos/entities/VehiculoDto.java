package com.soltelec.reportefur.models.dtos.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Date;

import com.soltelec.reportefur.models.entities.ClasesVehiculo;
import com.soltelec.reportefur.models.entities.Colores;
import com.soltelec.reportefur.models.entities.MarcasVehiculo;
import com.soltelec.reportefur.models.entities.Pais;
import com.soltelec.reportefur.models.entities.Vehiculos;
import com.soltelec.reportefur.models.entities.Servicios;
import com.soltelec.reportefur.models.entities.TipoCarroceria;
import com.soltelec.reportefur.models.entities.TipoCombustible;
import com.soltelec.reportefur.models.entities.LineasVehiculo;
import com.soltelec.reportefur.models.entities.Llantas;


@Data
@AllArgsConstructor
public class VehiculoDto {
    private Integer id;
    private Integer carroceria;
    private String placa;
    private Integer linea;
    private Integer marca;
    private Integer modelo;
    private String diseno;
    private Integer cilindraje;
    private Integer servicio;
    private Integer clase; // Esta propiedad se tomará de la ClasesVehiculo
    private String numeroLicencia;
    private Integer numeroEjes;
    private Integer tipo;
    private Date fechaActualizacion;
    private Integer idUsuario;
    private Integer idPropietario;
    private Integer numeroExostos;
    private Integer diametro;
    private Integer tipoCombustible;
    private Integer tiemposMotor;
    private Integer velocidad;
    private Integer color;
    private String numeroSoat;
    private Integer aseguradora;
    private Date fechaRegistro;
    private Date fechaSoat;
    private Date fechaExpSoat;
    private Integer tipoLlanta;
    private String nacionalidad;
    private Integer pesoBruto;
    private Integer servicioEspecial;
    private String numeroMotor;
    private String vin;
    private Integer pais;
    private Integer kilometraje;
    private Integer numeroSillas;
    private String vidriosPolarizados;
    private String blindaje;
    private String numeroChasis;
    private String codigoInterno;
    private String esEnsenanza;
    private LocalDateTime fechaVencimientoGnv;
    private String conversionGnv;
    private Integer potencia;
    private String catalizador;
    private Integer capacidadCarga;
    private String carroceriaTablet;
    private Integer categoria;
    private String numeroSerie;
    private Long idConductor;
    private String nombreClase; // Esta propiedad se tomará de la ClasesVehiculo
    private String nombrePais;
    private String nombreServicio;
    private String nombreMarca;
    private String nombreLinea; // Esta propiedad se tomará de la LineasVehiculo
    private String nombreColor;
    private String nombreCombustible;
    private String nombreCarroceria;
    private String nombreLlantas;


    public VehiculoDto() {
        super();
    }

    public VehiculoDto(Vehiculos vehiculos, ClasesVehiculo clasesVehiculo, 
    Pais pais, Servicios serviciosVehiculo, MarcasVehiculo marcasVehiculo,
    LineasVehiculo lineasVehiculo, Colores colores, TipoCombustible tipoCombustible, TipoCarroceria tipoCarroceria, Llantas llantas) {


        this.id = vehiculos.getId();
        this.carroceria = vehiculos.getCarroceria();
        this.placa = vehiculos.getPlaca();
        this.linea = vehiculos.getLinea();
        this.marca = vehiculos.getMarca();
        this.modelo = vehiculos.getModelo();
        this.diseno = vehiculos.getDiseno();
        this.cilindraje = vehiculos.getCilindraje();
        this.servicio = vehiculos.getServicio();
        this.clase = vehiculos.getClase(); // Se obtiene de la entidad Vehiculos
        this.numeroLicencia = vehiculos.getNumeroLicencia();
        this.numeroEjes = vehiculos.getNumeroEjes();
        this.tipo = vehiculos.getTipo();
        this.fechaActualizacion = vehiculos.getFechaActualizacion();
        this.idUsuario = vehiculos.getIdUsuario();
        this.idPropietario = vehiculos.getIdPropietario();
        this.numeroExostos = vehiculos.getNumeroExostos();
        this.diametro = vehiculos.getDiametro();
        this.tipoCombustible = vehiculos.getTipoCombustible();
        this.tiemposMotor = vehiculos.getTiemposMotor();
        this.velocidad = vehiculos.getVelocidad();
        this.color = vehiculos.getColor();
        this.numeroSoat = vehiculos.getNumeroSoat();
        this.aseguradora = vehiculos.getAseguradora();
        this.fechaRegistro = vehiculos.getFechaRegistro();
        this.fechaSoat = vehiculos.getFechaSoat();
        this.fechaExpSoat = vehiculos.getFechaExpSoat();
        this.tipoLlanta = vehiculos.getTipoLlanta();
        this.nacionalidad = vehiculos.getNacionalidad();
        this.pesoBruto = vehiculos.getPesoBruto();
        this.servicioEspecial = vehiculos.getServicioEspecial();
        this.numeroMotor = vehiculos.getNumeroMotor();
        this.vin = vehiculos.getVin();
        this.nombrePais = pais.getNombrePais();
        this.kilometraje = vehiculos.getKilometraje();
        this.numeroSillas = vehiculos.getNumeroSillas();
        this.vidriosPolarizados = vehiculos.isVidriosPolarizados() ? "Y" : "N";
        this.blindaje = vehiculos.isBlindado() ? "Y" : "N";
        this.numeroChasis = vehiculos.getNumeroChasis();
        this.codigoInterno = vehiculos.getCodigoInterno();
        this.esEnsenanza = vehiculos.getEsEnsenanza();
        this.fechaVencimientoGnv = vehiculos.getFechaVencimientoGnv();
        this.conversionGnv = vehiculos.tieneConversionGnv() ? "Y" : "N";
        this.potencia = vehiculos.getPotencia() != null ? vehiculos.getPotencia() : 0;
        this.catalizador = vehiculos.getCatalizador();
        this.capacidadCarga = vehiculos.getCapacidadCarga();
        this.carroceriaTablet = vehiculos.getCarroceriaTablet();
        this.categoria = vehiculos.getCategoria();
        this.numeroSerie = vehiculos.getNumeroSerie();
        this.idConductor = vehiculos.getIdConductor();
        this.nombreClase = clasesVehiculo.getNombreClase(); // Se obtiene de la entidad ClasesVehiculo
        this.nombreServicio = serviciosVehiculo.getNombreServicio(); // Se obtiene de la entidad ServiciosVehiculo
        this.nombreMarca = marcasVehiculo.getNombreMarca();
        this.nombreLinea = lineasVehiculo.getNombreLinea();
        this.nombreColor = colores.getNombreColor(); // Añadido para obtener el color del vehículo
        this.nombreCombustible = tipoCombustible.getNombreCombustible(); // Añadido para obtener el tipo de combustible
        this.nombreCarroceria = tipoCarroceria.getNombreCarroceria(); // Añadido para obtener el tipo de carrocería
        this.nombreLlantas = llantas.getNombreLlanta();

    }
}