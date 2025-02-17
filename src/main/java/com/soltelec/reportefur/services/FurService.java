package com.soltelec.reportefur.services;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.soltelec.reportefur.Utils;
import com.soltelec.reportefur.models.dtos.PruebaInfo;

import com.soltelec.reportefur.models.dtos.defectos.DefectosData;
import com.soltelec.reportefur.models.dtos.entities.PropietarioDto;
import com.soltelec.reportefur.models.dtos.entities.VehiculoDto;
import com.soltelec.reportefur.models.dtos.pruebas.TipoPrueba;
import com.soltelec.reportefur.models.dtos.responsables.ResponsablesPruebas;
import com.soltelec.reportefur.models.entities.Cda;
import com.soltelec.reportefur.models.entities.Ciudades;
import com.soltelec.reportefur.models.entities.ClasesVehiculo;
import com.soltelec.reportefur.models.entities.Colores;
import com.soltelec.reportefur.models.entities.Defectos;
import com.soltelec.reportefur.models.entities.Defxprueba;
import com.soltelec.reportefur.models.entities.Departamentos;
import com.soltelec.reportefur.models.entities.Dgsg;
import com.soltelec.reportefur.models.entities.Equipo;
import com.soltelec.reportefur.models.entities.Fotos;
import com.soltelec.reportefur.models.entities.Grupos;
import com.soltelec.reportefur.models.entities.GruposSubGrupos;
import com.soltelec.reportefur.models.entities.HojaPruebas;
import com.soltelec.reportefur.models.entities.LineasVehiculo;
import com.soltelec.reportefur.models.entities.Llantas;
import com.soltelec.reportefur.models.entities.MarcasVehiculo;
import com.soltelec.reportefur.models.entities.Medidas;
import com.soltelec.reportefur.models.entities.Pais;
import com.soltelec.reportefur.models.entities.Propietarios;
import com.soltelec.reportefur.models.entities.Pruebas;
import com.soltelec.reportefur.models.entities.Servicios;
import com.soltelec.reportefur.models.entities.TipoCarroceria;
import com.soltelec.reportefur.models.entities.TipoCombustible;
import com.soltelec.reportefur.models.entities.Vehiculos;
import com.soltelec.reportefur.repositories.CdaRep;
import com.soltelec.reportefur.repositories.CiudadesRep;
import com.soltelec.reportefur.repositories.ClasesVehiculoRep;
import com.soltelec.reportefur.repositories.ColorRep;
import com.soltelec.reportefur.repositories.DefectosRep;
import com.soltelec.reportefur.repositories.DefxpruebaRep;
import com.soltelec.reportefur.repositories.DepartamentosRep;
import com.soltelec.reportefur.repositories.DgsgRep;
import com.soltelec.reportefur.repositories.EquipoRep;
import com.soltelec.reportefur.repositories.FotosRep;
import com.soltelec.reportefur.repositories.GruposRep;
import com.soltelec.reportefur.repositories.GruposSubGruposRep;
import com.soltelec.reportefur.repositories.HojaPruebasRep;
import com.soltelec.reportefur.repositories.LineasVehiculoRep;
import com.soltelec.reportefur.repositories.LlantasRep;
import com.soltelec.reportefur.repositories.MarcasVehiculoRep;
import com.soltelec.reportefur.repositories.MedidasRep;
import com.soltelec.reportefur.repositories.PaisRep;
import com.soltelec.reportefur.repositories.PropietariosRep;
import com.soltelec.reportefur.repositories.PruebasRep;
import com.soltelec.reportefur.repositories.ServiciosRep;
import com.soltelec.reportefur.repositories.TipoCarroceriaRep;
import com.soltelec.reportefur.repositories.TipoCombustibleRep;
import com.soltelec.reportefur.repositories.TipoPruebaRep;
import com.soltelec.reportefur.repositories.UsuariosRep;
import com.soltelec.reportefur.repositories.VehiculosRep;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class FurService {
  private static final String FOLDER = "reports";
  private static final String EXTENSION = ".jasper";
  private static final String FUR_NAME = "pruebaA";
  //private static final String PREVENTIVA = "orderReport";

  private final CdaRep cdaRep;

  private final HojaPruebasRep hojaPruebasRep;

  private final VehiculosRep vehiculoRep;

  private final PropietariosRep propietariosRep;

  private final CiudadesRep ciudadesRep;

  private final DepartamentosRep departamentosRep;

  private final ClasesVehiculoRep clasesVehiculoRep;

  private final PaisRep paisRep;

  private final ServiciosRep serviciosRep;

  private final MarcasVehiculoRep marcasVehiculoRep;

  private final LineasVehiculoRep lineasVehiculoRep;

  private final ColorRep coloresRep;

  private final TipoCombustibleRep tipoCombustibleRep;

  private final TipoCarroceriaRep tipoCarroceriaRep;

  private final MedidasRep medidasRep;

  private final PruebasRep pruebasRep;
  private final DefxpruebaRep defxpruebaRep;
  private final DefectosRep defectosRep;

  private final LlantasRep llantasRep;

  private final EquipoRep equiposRep;

  private final FotosRep fotosRep;

  private final TipoPruebaRep tipoPruebaRep;
  private final UsuariosRep usuariosRep;
  private final GruposRep gruposRep;
  private final GruposSubGruposRep gruposSubGruposRep;

  private final DgsgRep dgsgRep;

  public byte[] savePdfToDataBaseTest(Integer hojaPruebaId) throws JRException {
    System.out.println("ID de la hoja de pruebas en el servicio: " + hojaPruebaId);
    byte[] pdf = getReport(hojaPruebaId);
  
    HojaPruebas hojaPruebas = hojaPruebasRep.findById(hojaPruebaId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hoja de pruebas no encontrada"));

    hojaPruebas.setPdf(pdf);
    hojaPruebasRep.save(hojaPruebas);
    return pdf;
  }

  public byte[] getReport(Integer idHojaPruebas) throws JRException {

    Map<String, Object> allParams = new HashMap<>();


    allParams.put("certificadoOnac", "certificadoOnac");

    HojaPruebas hojaPruebas = hojaPruebasRep.findById(idHojaPruebas)
      .orElseThrow(() -> new RuntimeException("Hoja de pruebas not found"));


    Vehiculos vehiculo = vehiculoRep.findById(hojaPruebas.getIdVehiculo())
      .orElseThrow(() -> new RuntimeException("Vehiculo not found"));

    ClasesVehiculo claseVehiculo = clasesVehiculoRep.findById(vehiculo.getClase())
    .orElseThrow(() -> new RuntimeException("ClaseVehiculo not found"));

    Pais paisVehiculo = paisRep.findById(vehiculo.getPais())
      .orElseThrow(() -> new RuntimeException("PaisVehiculo not found"));

    Servicios serviciosVehiculo = serviciosRep.findById(vehiculo.getServicio())
      .orElseThrow(() -> new RuntimeException("ServiciosVehiculo not found"));

    MarcasVehiculo marcasVehiculo = marcasVehiculoRep.findById(vehiculo.getMarca())
    .orElseThrow(() -> new RuntimeException("ServiciosVehiculo not found")); 

    LineasVehiculo lineasVehiculo = lineasVehiculoRep.findById(vehiculo.getLinea())
      .orElseThrow(() -> new RuntimeException("LineasVehiculo not found"));

    Colores colorVehiculo = coloresRep.findById(vehiculo.getColor())
      .orElseThrow(() -> new RuntimeException("LineasVehiculo not found"));

    TipoCombustible tipoCombustible = tipoCombustibleRep.findById(vehiculo.getTipoCombustible())
      .orElseThrow(() -> new RuntimeException("TipoCombustible not found"));

    Integer carroceria = vehiculo.getCarroceria() == null ? 1 : vehiculo.getCarroceria();

    TipoCarroceria tipoCarroceria = tipoCarroceriaRep.findById(carroceria) 
     .orElseThrow(() -> new RuntimeException("TipoCarroceria not found"));

    Propietarios propietarios = propietariosRep.findById(vehiculo.getIdPropietario())
      .orElseThrow(() -> new RuntimeException("Propietario not found"));

    Ciudades ciudades = ciudadesRep.findById(propietarios.getCiudad())
      .orElseThrow(() -> new RuntimeException("Ciudad not found"));

    Departamentos departamentos = departamentosRep.findById(ciudades.getDepartamento())
      .orElseThrow(() -> new RuntimeException("Departamento not found"));

    Llantas llantas = llantasRep.findById(vehiculo.getTipoLlanta())
    .orElseThrow(() -> new RuntimeException("Llanta not found"));
    
    
    

    List<Pruebas> listaAllPruebas = pruebasRep.findPruebasByHojaPruebas(hojaPruebas.getId());

    Fotos fotos = fotosRep.findFotosByHojaPruebas(hojaPruebas.getId());

    if (listaAllPruebas.isEmpty()) {
      throw new RuntimeException("No se encontraron pruebas para la hoja de pruebas: " + idHojaPruebas);
    }


    Integer idPruebaLuces = pruebasRep.findIdPrueba(idHojaPruebas, 2)
      .orElse(null);

    Integer idPruebaSuspension = pruebasRep.findIdPrueba(idHojaPruebas, 6)
        .orElse(null);

    Integer idPruebasFreno = pruebasRep.findIdPrueba(idHojaPruebas, 5)
        .orElse(null);

    Integer idPruebasDesviacion = pruebasRep.findIdPrueba(idHojaPruebas, 4)
        .orElse(null);

    Integer idPruebasTaximetro = pruebasRep.findIdPrueba(idHojaPruebas, 9)
        .orElse(null);

    Integer idPruebasGases = pruebasRep.findIdPrueba(idHojaPruebas, 8)
        .orElse(null);

    Integer idPruebasSensorial = pruebasRep.findIdPrueba(idHojaPruebas, 1)
        .orElse(null);
    

    List<Medidas> listaMedidas = medidasRep.findByIdPrueba(idPruebaLuces);
    List<Medidas> listaMedidasSuspension = medidasRep.findByIdPrueba(idPruebaSuspension);
    List<Medidas> listaMedidasFreno = medidasRep.findByIdPrueba(idPruebasFreno);
    List<Medidas> listaMedidasDesviacion = medidasRep.findByIdPrueba(idPruebasDesviacion);
    List<Medidas> listaMedidasTaximetro = (idPruebasTaximetro != null) 
        ? medidasRep.findByIdPrueba(idPruebasTaximetro) 
        : Collections.emptyList();
    List<Medidas> listaMedidasGases = medidasRep.findByIdPrueba(idPruebasGases);
    List<Medidas> listaMedidasSensorial = medidasRep.findByIdPrueba(idPruebasSensorial);
    List<Defxprueba> listaDefxpruebas = defxpruebaRep.findByIdPrueba(idPruebasSensorial);
    List<Defxprueba> listaDefxpruebasMecanizados = defxpruebaRep.findByHojaPruebaId(idHojaPruebas);



    PropietarioDto propietarioDto = new PropietarioDto(
      propietarios.getApellidos(), propietarios.getNombres(), propietarios.getTipoIdentificacion(), propietarios.getNIdentificacion().toString(), 
      propietarios.getDireccion(), propietarios.getNumeroTelefono(), ciudades.getNombreCiudad(), departamentos.getNombreDepartamento(), 
      propietarios.getEmail(), hojaPruebas.getFechaIngreso().toString()
    );
    
    VehiculoDto vehiculoDto = new VehiculoDto(
      vehiculo, claseVehiculo, paisVehiculo, serviciosVehiculo, 
      marcasVehiculo, lineasVehiculo, colorVehiculo, tipoCombustible, tipoCarroceria, llantas
    );

    

    Map<String, Object> cdaParams = getCdaData();

    Map<String, Object> propietarioParams = getPropietarioData(propietarioDto);

    Map<String, Object> vehiculoParams = getVehiculoData(vehiculoDto);

    Map<String, Object> lucesParams = getLucesData(listaMedidas, vehiculoDto);

    Map<String, Object> suspensionParams = getSuspensionData(listaMedidasSuspension);

    Map<String, Object> frenosParams = getFrenosData(listaMedidasFreno, vehiculoDto);

    Map<String, Object> desviacionesParams = getDesviacionesData(listaMedidasDesviacion);

    Map<String, Object> dispositivosCobroParams = getDispositivosCobroData(vehiculoDto, listaMedidasTaximetro);

    Map<String, Object> ottoParams = getOttoData(listaMedidasGases);

    Map<String, Object> dieselParams = getDieselData(listaMedidasGases);

    Map<String, Object> defectosSensorialesParams = getDefectosSensorialesData(listaDefxpruebas, vehiculoDto);

    Map<String, Object> defectosMecanizadosParams = getDefectosMecanizadosData(listaDefxpruebasMecanizados, vehiculoDto);

    Map<String, Object> sensorialParams = getLabradoPresionData(listaMedidasSensorial);

    Map<String, Object> equiposParams = getSerialesData(listaAllPruebas);

    Map<String, Object> fotosParams = getFotosData(fotos);

    Map<String, Object> comentariosParams = getComentarioData(listaAllPruebas);

    Map<String, Object> responsablesParams = getResponsablesPruebasData(listaAllPruebas, hojaPruebas);

    

    allParams.putAll(cdaParams);
    allParams.putAll(vehiculoParams);
    allParams.putAll(propietarioParams);
    allParams.putAll(lucesParams);
    allParams.putAll(suspensionParams);
    allParams.putAll(frenosParams);
    allParams.putAll(desviacionesParams);
    allParams.putAll(dispositivosCobroParams);
    allParams.putAll(defectosSensorialesParams);
    allParams.putAll(sensorialParams); 
    allParams.putAll(equiposParams);
    allParams.putAll(fotosParams);
    allParams.putAll(comentariosParams);
    allParams.putAll(ottoParams);
    allParams.putAll(dieselParams);
    allParams.putAll(responsablesParams);
    allParams.putAll(defectosMecanizadosParams);

    // load .jasper file
    InputStream reportStream = getClass().getResourceAsStream("/"+FOLDER+"/"+FUR_NAME+EXTENSION);

    if (reportStream == null) throw new IllegalArgumentException("El archivo .jasper no se encuentra");
  
    // Fill report with data
    JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, allParams, new JREmptyDataSource());

    return JasperExportManager.exportReportToPdf(jasperPrint);
  }
  
  public Map<String, Object> getCdaData() {
    Map<String, Object> params = new HashMap<>();

    Cda cda = cdaRep.findById(1)
      .orElseThrow(() -> new RuntimeException("Cda not found"));

    String cdaNombre = cda.getNombre();
    String cdaNit = cda.getNit();
    String cdaContacto = cda.getCelular()+" -- "+cda.getTelefono();
    String cdaDireccion = cda.getDireccion();
    String cdaCiudad = cda.getCiudad();
    String cdaCorreo = cda.getCorreo();
    String cdaCertificadoOnac = cda.getCertificadoConformidad();

    params.put("cdaNombre", cdaNombre);
    params.put("cdaNit", cdaNit);
    params.put("cdaContacto", cdaContacto);
    params.put("cdaDireccion", cdaDireccion);
    params.put("cdaCiudad", cdaCiudad);
    params.put("cdaCorreo", cdaCorreo);
    params.put("certificadoOnac", cdaCertificadoOnac);
    return params;
  }

  public Map<String, Object> getPropietarioData(PropietarioDto propietarioDto) {
    Map<String, Object> params = new HashMap<>();

    params.put("fechaRevision", propietarioDto.getFechaRevision());
    params.put("apellidosPropietario", propietarioDto.getApellidos());
    params.put("nombresPropietarios", propietarioDto.getNombres());
    params.put("exprTipoDoc", propietarioDto.getTipoDoc());
    params.put("cedulaPropietario", propietarioDto.getCedula());
    params.put("direccionPropietario", propietarioDto.getDireccion());
    params.put("numeroTelefonoPropietario", propietarioDto.getNumeroTelefono());
    params.put("nombreCiudad", propietarioDto.getCiudad());
    params.put("nombreDepartamento", propietarioDto.getDepartamento());
    params.put("emailPropietario", propietarioDto.getEmail());
    return params;
  }

  public Map<String, Object> getVehiculoData(VehiculoDto vehiculoDto) {
    Map<String, Object> params = new HashMap<>();


    params.put("placa", vehiculoDto.getPlaca());
    params.put("paisVehiculo", vehiculoDto.getNombrePais());
    params.put("servicioVehiculo", vehiculoDto.getNombreServicio());
    params.put("claseVehiculo", vehiculoDto.getNombreClase());
    params.put("marcaVehiculo", vehiculoDto.getNombreMarca());
    params.put("lineaVehiculo", vehiculoDto.getNombreLinea());
    params.put("modeloVehiculo", vehiculoDto.getModelo().toString());
    params.put("licenciaVehiculo", vehiculoDto.getNumeroLicencia());
    params.put("fechaMatricula", vehiculoDto.getFechaRegistro().toString());
    params.put("colorVehiculo", vehiculoDto.getNombreColor());
    params.put("combustibleVehiculo", vehiculoDto.getNombreCombustible());
    params.put("vinVehiculo", vehiculoDto.getNumeroChasis());
    params.put("numeroMotorVehiculo", vehiculoDto.getNumeroMotor());
    params.put("tiemposMotor", vehiculoDto.getTiemposMotor().toString());
    params.put("cilindraje", vehiculoDto.getCilindraje().toString());
    params.put("kilometrajeMedida", vehiculoDto.getKilometraje().toString());
    params.put("nPasajerosVehiculo", vehiculoDto.getNumeroSillas().toString());
    params.put("blindajeVehiculo", vehiculoDto.getBlindaje());
    params.put("potenciaVehiculo", vehiculoDto.getPotencia().toString());
    params.put("carroceriaVehiculo", vehiculoDto.getNombreCarroceria());
    params.put("vFechaSoat", vehiculoDto.getFechaExpSoat().toString());
    params.put("vConversionGnv", vehiculoDto.getConversionGnv());
    params.put("vFechaVigSoat", vehiculoDto.getFechaSoat().toString());
    
    String fechaVencimientoGnv = vehiculoDto.getFechaVencimientoGnv() == null ? "" : vehiculoDto.getFechaVencimientoGnv().toString();
    params.put("fechaVGnv", fechaVencimientoGnv);
    return params;
  }

    public Map<String, Object> getLucesData(List<Medidas> listaMedidas, VehiculoDto vehiculoDto) {
      Map<String, Object> params = new HashMap<>();

      // Mapa para parámetros de valorMedida
      Map<Integer, String> keyMap = Map.ofEntries(
          Map.entry(2024, "IntBD1"), Map.entry(2025, "IntBD2"), Map.entry(2026, "IntBD3"),
          Map.entry(2040, "AngIncD1"), Map.entry(2041, "AngIncD2"), Map.entry(2042, "AngIncD3"),
          Map.entry(2031, "IntBI1"), Map.entry(2030, "IntBI2"), Map.entry(2029, "IntBI3"),
          Map.entry(2044, "AngIncI1"), Map.entry(2045, "AngIncI2"), Map.entry(2046, "AngIncI3"),
          Map.entry(2036, "IntAD1"), Map.entry(2037, "IntAD2"), Map.entry(2038, "IntAD3"),
          Map.entry(2032, "IntAI1"), Map.entry(2033, "IntAI2"), Map.entry(2034, "IntAI3"),
          Map.entry(2050, "IntED1"), Map.entry(2051, "IntED2"), Map.entry(2052, "IntED3"),
          Map.entry(2053, "IntEI1"), Map.entry(2054, "IntEI2"), Map.entry(2055, "IntEI3"),
          Map.entry(2013, "AngIncD1"), Map.entry(2014, "IntBD1")
      );

      // Mapa simplificado para parámetros Sim
      Map<String, List<Integer>> simKeyMap = Map.of(
          "SimBajasDer", List.of(2024, 2025, 2026),
          "SimBajasIzq", List.of(2031, 2030, 2029),
          "SimAltasDer", List.of(2036, 2037, 2038),
          "SimAltasIzq", List.of(2032, 2033, 2034),
          "SimExpDer", List.of(2050, 2051, 2052),
          "SimExpIzq", List.of(2053, 2054, 2055)
      );

      // Inicializar parámetros Sim en "NO" y sumaLuces en 0
      simKeyMap.keySet().forEach(key -> params.put(key, "NO"));
      float sumaLuces = 0.0f; // Usar float para acumular decimales

      // Procesar cada medida
      for (Medidas medida : listaMedidas) {
          Integer measureType = medida.getMeasureType();

          // 1. Agregar valores formateados al mapa
          if (keyMap.containsKey(measureType)) {
              Float valor = medida.getValorMedida();
              if (valor != null) { // Evitar NullPointerException
                  params.put(keyMap.get(measureType), Utils.redondeoNorma(valor));
              }
          }

          // 2. Calcular sumaLuces y parámetros Sim si Simult = "Y"
          if ("Y".equalsIgnoreCase(medida.getSimult())) {
              Float valor = medida.getValorMedida();
              if (valor != null) { // Asegurar que el valor no sea nulo
                  sumaLuces += valor; // Sumar como float
              }
              for (var entry : simKeyMap.entrySet()) {
                  if (entry.getValue().contains(measureType)) {
                      params.put(entry.getKey(), "SI");
                      break;
                  }
              }
          }
      }



      String sumaLucesFormateada = Utils.redondeoNorma(sumaLuces);

      // Agregar resultados finales al mapa (formatear sumaLuces)
      params.put("sumaLuces", sumaLucesFormateada); // Ej: "125.40"

      // Valores permisibles según tipo de vehículo
      Map<Integer, Map<String, String>> permisiblesPorTipo = Map.of(
      // Motocicletas
      4, Map.of(
          "perSumaLuces", "---"
      )
      );

      // Obtener el tipo de vehículo del contexto
      Integer tipoVehiculo = vehiculoDto.getTipo();
      Map<String, String> permisibles = permisiblesPorTipo.getOrDefault(tipoVehiculo, permisiblesPorTipo.get(0));
      
      // Agregar los permisibles al mapa de parámetros
      params.putAll(permisibles);
      return params;
  }

  public Map<String, Object> getSuspensionData(List<Medidas> listaMedidasSuspension) {
    Map<String, Object> params = new HashMap<>();

    // Mapa para parámetros de valorMedida
    Map<Integer, String> keyMap = Map.ofEntries(
        Map.entry(6016, "DelanteraDer"), 
        Map.entry(6017, "TraseraDerecha"),
        Map.entry(6020, "DelanteraIzq"), 
        Map.entry(6021, "TraseraIzq")
    );

    // Procesar cada medida
    for (Medidas medida : listaMedidasSuspension) {
        Integer measureType = medida.getMeasureType();

        // 1. Agregar valores formateados al mapa
        if (keyMap.containsKey(measureType)) {
            Float valor = medida.getValorMedida();

            if (valor != null && valor > 40) { // Evitar NullPointerException
                params.put(keyMap.get(measureType), Utils.redondeoNorma(valor));
            }
        }

    }


    params.put("PerSusp", "40");

    return params;
 
  }

  public Map<String, Object> getFrenosData(List <Medidas> listaMedidasFreno, VehiculoDto vehiculoDto) {
    Map<String, Object> params = new HashMap<>();

    Map<Integer, String> keyMap = Map.ofEntries(
      Map.entry(5012, "FrzEje1Izq"), 
      Map.entry(5013, "FrzEje2Izq"),
      Map.entry(5014, "FrzEje3Izq"), 
      Map.entry(5015, "FrzEje4Izq"),
      Map.entry(5028, "FrzEje5Izq"), 
      Map.entry(5004, "PsEje1Izq"),
      Map.entry(5005, "PsEje2Izq"), 
      Map.entry(5006, "PsEje3Izq"),
      Map.entry(5007, "PsEje4Izq"),
      Map.entry(5026, "PsEje5Izq"),
      Map.entry(5008, "FrzEje1Der"),
      Map.entry(5009, "FrzEje2Der"),
      Map.entry(5010, "FrzEje3Der"),
      Map.entry(5011, "FrzEje4Der"),
      Map.entry(5027, "FrzEje5Der"),
      Map.entry(5000, "PsEje1Der"),
      Map.entry(5001, "PsEje2Der"),
      Map.entry(5002, "PsEje3Der"),
      Map.entry(5003, "PsEje4Der"),
      Map.entry(5025, "PsEje5Der"),
      Map.entry(5032, "DesEje1"),
      Map.entry(5033, "DesEje2"),
      Map.entry(5034, "DesEje3"),
      Map.entry(5035, "DesEje4"),
      Map.entry(5031, "DesEje5"),
      Map.entry(5024, "EficTotal"),
      // MEDIDAS DE FRENOS AUXILIARES
      Map.entry(5036, "EficAux")
  
  );

      // Listamos las medidas para obtener FrzSumIzq
    List<Integer> frzSumIzqCodes = List.of(5020, 5021, 5022, 5023);
    // Lista de medidas a ser sumanas para obtenr  PsSumIzq
    List<Integer> listPsSumIzq = List.of(5004, 5005, 5006, 5007);

    List<Integer> listFrzSumDer = List.of(5016, 5017, 5018, 5019);

    List<Integer> listPsSumDer = List.of(5000, 5001, 5002, 5003);


    float frzSumIzq = 0;
    float psSumIzq = 0;
    float frzSumDer = 0;
    float psSumDer = 0;


      // Procesar cada medida
      for (Medidas medida : listaMedidasFreno) {
        Integer measureType = medida.getMeasureType();
        Float valor = medida.getValorMedida();

        // 1. Agregar valores formateados al mapa
        if (keyMap.containsKey(measureType) && valor != null) {
          params.put(keyMap.get(measureType), Utils.redondeoNorma(valor));
        }

        // 2. Sumar los valores de los códigos específicos
        if (frzSumIzqCodes.contains(measureType) && valor != null) {
          frzSumIzq += valor;
        }

        if (listPsSumIzq.contains(measureType) && valor != null) {
          psSumIzq += valor;
        }

        if (listFrzSumDer.contains(measureType) && valor != null) {
          frzSumDer += valor;
        }

        if (listPsSumDer.contains(measureType) && valor != null) {
          psSumDer += valor;
        }



      }

    //FRENOS AUXILIARES DATOS
    params.put("FrzSumIzq", Utils.redondeoNorma(frzSumIzq));
    params.put("PsSumIzq", Utils.redondeoNorma(psSumIzq));
    params.put("FrzSumDer", Utils.redondeoNorma(frzSumDer));
    params.put("PsSumDer", Utils.redondeoNorma(psSumDer));


    Map<Integer, Map<String, String>> permisiblesPorTipo = Map.of(
      // Motocicletas
      4, Map.of(
          "PerDeseqB", "---",
          "PerDeseq", "---",
          "PerEficTotal", "30",
          "PerEficAux", "---"
      )
  );
      // Obtener el tipo de vehículo del contexto
      Integer tipoVehiculo = vehiculoDto.getTipo();
      Map<String, String> permisibles = permisiblesPorTipo.getOrDefault(tipoVehiculo, permisiblesPorTipo.get(0));
      
      // Agregar los permisibles al mapa de parámetros
      params.putAll(permisibles);

    return params;
  }

  public Map<String, Object> getDesviacionesData(List <Medidas> listaMedidasDesviacion) {
    Map<String, Object> params = new HashMap<>();


      // Mapa para parámetros de valorMedida
      Map<Integer, String> keyMap = Map.ofEntries(
        Map.entry(4000, "DvcnEje1"), 
        Map.entry(4001, "DvcnEje2"),
        Map.entry(4002, "DvcnEje3"), 
        Map.entry(4003, "DvcnEje4"),
        Map.entry(4004, "DvcnEje5")
    );
  
    // Procesar cada medida
        for (Medidas medida : listaMedidasDesviacion) {
          Integer measureType = medida.getMeasureType();

          // 1. Agregar valores formateados al mapa
          if (keyMap.containsKey(measureType)) {
              Float valor = medida.getValorMedida();

              if (valor != null ) { // Evitar NullPointerException
                  params.put(keyMap.get(measureType), Utils.redondeoNorma(valor));
              }
          }

      }


    params.put("PerDesv", "10");

    return params;
  }

  public Map<String, Object> getDispositivosCobroData(VehiculoDto vehiculoDto, List <Medidas> listaMedidasTaximetro) {
    Map<String, Object> params = new HashMap<>();

          // Mapa para parámetros de valorMedida
          Map<Integer, String> keyMap = Map.ofEntries(
            Map.entry(9002, "ErrorDistancia"), 
            Map.entry(9003, "ErrorTiempo")
        );
      

        // Procesar cada medida
        for (Medidas medida : listaMedidasTaximetro) {
          Integer measureType = medida.getMeasureType();

          // 1. Agregar valores formateados al mapa
          if (keyMap.containsKey(measureType)) {
              Float valor = medida.getValorMedida();

              if (valor != null ) { // Evitar NullPointerException
                  params.put(keyMap.get(measureType), Utils.redondeoNorma(valor));
              }
          }

      }
    
    params.put("RefLlanta", vehiculoDto.getNombreLlantas());

    return params;
  }

  public Map<String, Object> getOttoData(List <Medidas> listaMedidasGases) {
    Map<String, Object> params = new HashMap<>();

          // Mapa para parámetros de valorMedida
          Map<Integer, String> keyMap = Map.ofEntries(
            Map.entry(8005, "RevGasoRal"), 
            Map.entry(8002, "CORalenti"),
            Map.entry(8003, "CO2Ralenti"),
            Map.entry(8004, "O2Ralenti"),
            Map.entry(8001, "HCRalenti"),
            Map.entry(8011, "RevGasoCruc"),
            Map.entry(8008, "COCrucero"),
            Map.entry(8009, "CO2Crucero"),
            Map.entry(8010, "O2Crucero"),
            Map.entry(8007, "HCCrucero"),
            Map.entry(8006, "TempGasoRal"),
            Map.entry(8032, "HRGas"),
            Map.entry(8031, "TempAmbGas")
          );

            
        // Procesar cada medida
        for (Medidas medida : listaMedidasGases) {
          Integer measureType = medida.getMeasureType();

          // 1. Agregar valores formateados al mapa
          if (keyMap.containsKey(measureType)) {
              Float valor = medida.getValorMedida();

          if (valor != null ) { // Evitar NullPointerException
                  params.put(keyMap.get(measureType), Utils.redondeoNorma(valor));
                }
          }
      
        }

      
  // PERMISIBLES
      params.put("PerCORal", "PerCORal");
      params.put("PerCO2", "PerCO2");
      params.put("PerO2", "PerO2");
      params.put("PerHCRal", "PerHCRal");
      params.put("PerCOCruc", "PerCOCruc");
      params.put("PerCO2", "PerCO2");
      params.put("PerO2", "PerO2");
      params.put("PerHCCruc", "PerHCCruc");
      params.put("Catalizador", "Catalizador"); // valore serian si y no
      return params;


  }


  public Map<String, Object> getDieselData(List <Medidas> listaMedidasGases) {
    Map<String, Object> params = new HashMap<>();

    Map<Integer, String> keyMap = Map.ofEntries(
      Map.entry(8033, "OpCiclo1"),
      Map.entry(8013, "OpCiclo2"),
      Map.entry(8014, "OpCiclo3"),
      Map.entry(8015, "OpCiclo4"),
      Map.entry(8038, "GobCic1"),
      Map.entry(8039, "GobCic2"),
      Map.entry(8040, "GobCic3"),
      Map.entry(8041, "GobCic4"),
      Map.entry(8017, "ResultadoOp"),
      Map.entry(8035, "RevDiesel"),
      Map.entry(8034, "TempIniD"),
      Map.entry(8037, "TempFinD"),
      Map.entry(8031, "TempAmbDis"),
      Map.entry(8032, "HRDis")
    );


        // Procesar cada medida
        for (Medidas medida : listaMedidasGases) {
          Integer measureType = medida.getMeasureType();

          // 1. Agregar valores formateados al mapa
          if (keyMap.containsKey(measureType)) {
              Float valor = medida.getValorMedida();

               if (valor != null ) { // Evitar NullPointerException
                  params.put(keyMap.get(measureType), Utils.redondeoNorma(valor));
              } 
          }
      
        }

        //PERMISIBLES
    params.put("PerOpac", "PerOpac");
    params.put("diametro", "diametro");
    return params;
  }

public Map<String, Object> getDefectosSensorialesData(List<Defxprueba> listaDefxprueba, VehiculoDto vehiculoDto) {
    Map<String, Object> params = new HashMap<>();
    List<DefectosData> defectosSensoriales = new ArrayList<>();
    Map<String, Integer> grupoCount = new HashMap<>();
    int totalA = 0;
    int totalB = 0;
    
    for (Defxprueba defxprueba : listaDefxprueba) {
    
        
        Defectos defecto = defectosRep.findByIdDefecto(defxprueba.getIdDefecto());
        Dgsg dgsg = dgsgRep.findByIdDefectoAndTipoVehiculo(defxprueba.getIdDefecto(), vehiculoDto.getTipo()).orElse(null);
        Grupos grupos = gruposRep.findById(dgsg.getIdGrupo()).orElse(null);
        String tipo = defecto.getTipoDefecto();
        String grupo = grupos.getNombreGrupo();
        
        boolean esA = "A".equals(tipo);

        // Contar tipos A y B
        if ("A".equals(tipo)) totalA++;
        if ("B".equals(tipo)) totalB++;
        
        // Contar por grupo
        grupoCount.put(grupo, grupoCount.getOrDefault(grupo, 0) + 1);
        
        // Agregar defecto
            defectosSensoriales.add(new DefectosData(
                defecto.getCodigoResolucion(),
                defecto.getNombreProblema(),
                grupos.getNombreGrupo(),
                esA ? "X" : "",
                esA ? "" : "X"
            ));
        
   
    }

    JRBeanCollectionDataSource defectosDataSource = new JRBeanCollectionDataSource(defectosSensoriales);

    // Agregar totales
    params.put("aTotal", String.valueOf(totalA));
    params.put("bTotal", String.valueOf(totalB));
    
    // Agregar conteo por grupo
    for (Map.Entry<String, Integer> entry : grupoCount.entrySet()) {
        params.put("grupo_" + entry.getKey(), String.valueOf(entry.getValue()));
    }

    params.put("defectosSensorial", defectosDataSource);

    return params;
  }


  public Map<String, Object> getDefectosMecanizadosData(List<Defxprueba> listaDefxprueba, VehiculoDto vehiculoDto) {
    Map<String, Object> params = new HashMap<>();
    List<DefectosData> defectosSensoriales = new ArrayList<>();
    Map<String, Integer> grupoCount = new HashMap<>();
    int totalA = 0;
    int totalB = 0;
    
    for (Defxprueba defxprueba : listaDefxprueba) {
    
        
        Defectos defecto = defectosRep.findByIdDefecto(defxprueba.getIdDefecto());
        System.out.println("Defectos lista" + defecto);
        System.out.println("Id defecto" + defxprueba.getIdDefecto() );
        System.out.println("Tipo vehiculo" + vehiculoDto.getTipo());
       // Dgsg dgsg = dgsgRep.findByIdDefectoAndTipoVehiculo(defxprueba.getIdDefecto(), vehiculoDto.getTipo()).orElse(null);

        GruposSubGrupos gsg = gruposSubGruposRep.findByCartypeIdAndSubGroupId(vehiculoDto.getTipo(), defecto.getDefGroupsSub()).orElse(null);

        Grupos grupos = gruposRep.findById(gsg.getGroupId()).orElse(null);
        String tipo = defecto.getTipoDefecto();
        String grupo = grupos.getNombreGrupo();
        
        boolean esA = "A".equals(tipo);

        // Contar tipos A y B
        if ("A".equals(tipo)) totalA++;
        if ("B".equals(tipo)) totalB++;
        
        // Contar por grupo
        grupoCount.put(grupo, grupoCount.getOrDefault(grupo, 0) + 1);
        
        // Agregar defecto
            defectosSensoriales.add(new DefectosData(
                defecto.getCodigoResolucion(),
                defecto.getNombreProblema(),
                grupos.getNombreGrupo(),
                esA ? "X" : "",
                esA ? "" : "X"
            ));
        
   
    }

    JRBeanCollectionDataSource defectosDataSource = new JRBeanCollectionDataSource(defectosSensoriales);

    // Agregar totales
    params.put("aTotal", String.valueOf(totalA));
    params.put("bTotal", String.valueOf(totalB));
    
    // Agregar conteo por grupo
    for (Map.Entry<String, Integer> entry : grupoCount.entrySet()) {
        params.put("grupo_" + entry.getKey(), String.valueOf(entry.getValue()));
    }

    params.put("defectosMecanizados", defectosDataSource);

    return params;
  }

  public Map<String, Object> getLabradoPresionData(List<Medidas> listaMedidasSensorial) {
    Map<String, Object> params = new HashMap<>();
    
    // Mapa para parámetros de valorMedida
    Map<Integer, String> keyMap = Map.ofEntries(
        // Labrado eje 1
        Map.entry(9004, "LabraIzq1"),
        Map.entry(9046, "LabraDer1"),
        Map.entry(9013, "LabraDer1"),
        
        // Presión eje 1
        Map.entry(9022, "PresIzq1"),
        Map.entry(9048, "PresDer1"),
        Map.entry(9031, "PresDer1"),
        
        // Labrado eje 2
        Map.entry(9005, "LabraIzq1Eje2"),
        Map.entry(9009, "LabraIzq2Eje2"),
        Map.entry(9014, "LabrDer1Eje2"),
        Map.entry(9047, "LabrDer1Eje2"),
        Map.entry(9018, "LabrDer2Eje2"),
        
        // Presión eje 2
        Map.entry(9023, "PresIzq1Eje2"),
        Map.entry(9027, "PresIzq2Eje2"),
        Map.entry(9032, "PresDer1Eje2"),
        Map.entry(9049, "PresDer1Eje2"),
        Map.entry(9036, "PresDer2Eje2"),
        
        // Labrado eje 3
        Map.entry(9006, "LabraIzq1Eje3"),
        Map.entry(9010, "LabraIzq2Eje3"),
        Map.entry(9015, "LabrDer1Eje3"),
        Map.entry(9019, "LabrDer2Eje3"),
        
        // Presión eje 3
        Map.entry(9024, "PresIzq1Eje3"),
        Map.entry(9028, "PresIzq2Eje3"),
        Map.entry(9033, "PresDer1Eje3"),
        Map.entry(9037, "PresDer2Eje3"),
        
        // Labrado eje 4
        Map.entry(9007, "LabrIzq1Eje4"),
        Map.entry(9011, "LabrIzq2Eje4"),
        Map.entry(9016, "LabrDer1Eje4"),
        Map.entry(9020, "LabrDer2Eje4"),
        
        // Presión eje 4
        Map.entry(9025, "PresIzq1Eje4"),
        Map.entry(9029, "PresIzq2Eje4"),
        Map.entry(9034, "PresDer1Eje4"),
        Map.entry(9038, "PresDer2Eje4"),
        
        // Labrado eje 5
        Map.entry(9008, "LabrIzq1Eje5"),
        Map.entry(9012, "LabrIzq2Eje5"),
        Map.entry(9017, "LabrDer1Eje5"),
        Map.entry(9021, "LabrDer2Eje5"),
        
        // Presión eje 5
        Map.entry(9026, "PresIzq1Eje5"),
        Map.entry(9030, "PresIzq2Eje5"),
        Map.entry(9035, "PresDer1Eje5"),
        Map.entry(9039, "PresDer2Eje5"),
        
        // Labrado repuesto
        Map.entry(9040, "LabrRepuesto1"),
        Map.entry(9041, "LabrRepuesto2"),
        
        // Presión repuesto
        Map.entry(9043, "PresRespuesto1"),
        Map.entry(9044, "PresRespuesto2"),
        
        // Labrado motocarro
        Map.entry(9053, "LabraDer1"),
        Map.entry(9050, "PresDer1"),
        Map.entry(9054, "LabraIzq1Eje2"),
        Map.entry(9051, "PresIzq1Eje2"),
        Map.entry(9055, "LabrDer1Eje2"),
        Map.entry(9052, "PresDer1Eje2")
    );

    // Procesar cada medida
    for (Medidas medida : listaMedidasSensorial) {
        Integer measureType = medida.getMeasureType();
        
        if (keyMap.containsKey(measureType)) {
            String key = keyMap.get(measureType);
            Float valor = medida.getValorMedida();

            // Solo agregar el valor si no existe previamente en el mapa
            if (valor != null && !params.containsKey(key)) {
                params.put(key, Utils.redondeoNorma(valor));
            }
        }
    }

    return params;
}



  public Map<String, Object> getNormasNTCData() {
    Map<String, Object> params = new HashMap<>();
    params.put("Aprobado", "Aprobado");
    params.put("Reprobado", "Reprobado");
    params.put("consecutivoRUNT", "consecutivoRUNT");
    params.put("AprobadoEnse", "AprobadoEnse");
    params.put("ReprobadoEnse", "ReprobadoEnse");
    params.put("ConsecutivoFecha", "ConsecutivoFecha");
    return params;
  }

  public Map<String, Object> getComentarioData(List<Pruebas> listaPruebas) {
    Map<String, Object> params = new HashMap<>();
    StringBuilder comentariosBuilder = new StringBuilder();

    Map<Integer, TipoPrueba> unifiedKeyMap = Map.ofEntries(
      Map.entry(1,new TipoPrueba(1, "Inspeccion visual")),
      Map.entry(2,new TipoPrueba(2,"Luces")),
      Map.entry(3,new TipoPrueba(3,  "Foto")),
      Map.entry(4,new TipoPrueba(4, "Desviacion")),
      Map.entry(5,new TipoPrueba(5, "Freno")),
      Map.entry(6,new TipoPrueba(6,  "Suspension")),
      Map.entry(7,new TipoPrueba(7, "Ruido")),
      Map.entry(8,new TipoPrueba(8, "Gases")),
      Map.entry(9, new TipoPrueba(9, "Taximetro"))
    );
    
    // Procesar cada prueba
    for (Pruebas prueba : listaPruebas) {
        Integer idPrueba = prueba.getTipoPruebaFor();
        
        if (unifiedKeyMap.containsKey(idPrueba)) {
            String comentarioData = prueba.getObservaciones();
            
            // Validar que haya observaciones antes de agregar
            if (comentarioData != null && !comentarioData.trim().isEmpty()) {
                String nombreTipoPrueba = unifiedKeyMap.get(idPrueba).getNombre();
                
                // Formato mejorado con separadores y validación de contenido
                comentariosBuilder.append("- ")
                                   .append(nombreTipoPrueba)
                                   .append(": ")
                                   .append(comentarioData.trim().replaceAll("\\\\n", "\n  "))
                                   .append("\n\n");
            }
        }
    }
    
    // Eliminar últimos dos saltos de línea si existen
    if (comentariosBuilder.length() > 0) {
        comentariosBuilder.setLength(comentariosBuilder.length() - 2);
    }
    params.put("Comentarios", comentariosBuilder.toString());
    return params;
  }

  public Map<String, Object> getFotosData(Fotos fotos) {
    Map<String, Object> params = new HashMap<>();

    // Validar que el objeto fotos no sea nulo
    if (fotos == null) {
        System.out.println("El objeto Fotos es nulo. No se procesarán las fotos.");
        return params; // Devolver un mapa vacío si fotos es nulo
    }

    try {
        // Procesar Foto1 si no es nula
        if (fotos.getFoto1() != null) {
            params.put("Foto1", Utils.convertirAImagen(fotos.getFoto1()));
        } else {
            System.out.println("Foto1 es nula. No se procesará.");
        }

        // Procesar Foto2 si no es nula
        if (fotos.getFoto2() != null) {
            params.put("Foto2", Utils.convertirAImagen(fotos.getFoto2()));
        } else {
            System.out.println("Foto2 es nula. No se procesará.");
        }
    } catch (Exception e) {
        // Capturar cualquier excepción inesperada y registrarla
        System.err.println("Ocurrió un error al procesar las fotos: " + e.getMessage());
        e.printStackTrace(); // Opcional: Imprimir el stack trace para depuración
    }

    return params;
}

  public Map<String, Object> getSerialesData(List<Pruebas> listaAllPruebas) {
    Map<String, Object> params = new HashMap<>();

    // Mapa para parámetros de valorMedida
    Map<Integer, PruebaInfo> unifiedKeyMap = Map.ofEntries(
      Map.entry(1, new PruebaInfo("InstProfundidad", "MarcaProfundidad")),
      Map.entry(2, new PruebaInfo("InstLuces", "MarcaLuces")),
      Map.entry(4, new PruebaInfo("InstDesvia", "MarcaDesvia")),
      Map.entry(5, new PruebaInfo("InstFreno", "MarcaFreno")),
      Map.entry(6, new PruebaInfo("InstSusp", "MarcaSusp")),
      Map.entry(7, new PruebaInfo("InstRuido", "MarcaRuido")),
      Map.entry(9, new PruebaInfo("InstTax", "MarcaTax"))
    );


  // Procesar cada medida
  for (Pruebas prueba : listaAllPruebas) {
    Integer tipoPrueba = prueba.getTipoPruebaFor();
    String serialCompleto = prueba.getSerialEquipo();

    
    if (serialCompleto == null) {
      System.out.println("El serial completo es nulo para el tipo de prueba: " + tipoPrueba);
      continue; // Ignorar este caso y continuar con el siguiente
  }
    // Obtener el serial relevante solo si tipoPrueba == 1
    String serial = (tipoPrueba == 1) ? getSerialRelevante(serialCompleto) : serialCompleto;

    Optional<Equipo> equipoOptional = equiposRep.findBySerialResolucion(serial);
    if (equipoOptional.isPresent()) {
        Equipo equipo = equipoOptional.get();
        PruebaInfo pruebaInfo = unifiedKeyMap.get(tipoPrueba);
        if (pruebaInfo != null) {
            params.put(pruebaInfo.getInstrumento(), serial); // Agregar instrumento
            params.put(pruebaInfo.getMarca(), equipo.getMarca()); // Agregar marca
        }
    } else {
        System.out.println("No se encontró ningún equipo con el serial: " + serial);
    }

    if (tipoPrueba == 1){
        String serialHolguras = serialCompleto.split(";")[1].trim();
        Optional<Equipo> equipoHolguras = equiposRep.findBySerialResolucion(serialHolguras);
        System.out.println("Holguras data" + equipoHolguras);
        if (equipoHolguras.isPresent()) {
          Equipo equipo = equipoHolguras.get();
            params.put("holgurasElevador", equipo.getNomEquipo()); // Agregar instrumento
            params.put("holgurasElevadorMarca", equipo.getMarca()); // Agregar marca
            params.put("holgurasElevadorSerial", equipo.getSerial()); // Agregar marca
 
      } else {
          System.out.println("No se encontró ningún equipo con el serial: " + serial);
      }
    }
  

    // Caso especial para tipoPrueba == 8
    if (tipoPrueba == 8) {
        params.putAll(getSerialesGases(serialCompleto)); // Usar el serial completo aquí si es necesario
    }
}


    return params;
  }

  public Map<String, Object> getSoftwareData() {
    Map<String, Object> params = new HashMap<>();
    params.put("softwareNombre", "softwareNombre");
    params.put("softwareVersion", "softwareVersion");
    return params;
  }

  public Map<String, Object> getResponsablesPruebasData(List<Pruebas> listaAllPruebas, HojaPruebas hojaPruebas) {
    Map<String, Object> params = new HashMap<>();
    List<ResponsablesPruebas> responsablesPruebas = new ArrayList<>();
    Integer idResponsable = hojaPruebas.getIdResponsable();
    String responsableCda = usuariosRep.findById(idResponsable).get().getNombreUsuario();
    for (Pruebas prueba : listaAllPruebas) {

      Integer iDtipoPrueba = prueba.getTipoPruebaFor();
      String nombreTipoPrueba = tipoPruebaRep.findById(iDtipoPrueba).get().getNombreTipoPrueba();
      String nombreUsuario = usuariosRep.findById(prueba.getUsuarioFor()).get().getNombreUsuario();


      responsablesPruebas.add(new ResponsablesPruebas(nombreTipoPrueba, nombreUsuario));
    }
    JRBeanCollectionDataSource responsablesDataSource = new JRBeanCollectionDataSource(responsablesPruebas);
    params.put("pruebasResponsablesList", responsablesDataSource);
    params.put("nombreResp", responsableCda);
    String codigoPrueba = hojaPruebas.getNumeroHojaPrueba().toString() + " - " + hojaPruebas.getNumeroIntentos().toString();
    params.put("codigoPrueba",codigoPrueba);
    return params;



  }

  public Map<String, Object> getSerialesGases(String serialEquipo) {

    Map<String, Object> params = new HashMap<>();
    
    if (serialEquipo != null && serialEquipo.startsWith("otto")) {

      String marcas = serialEquipo.split("~")[1];
      String seriales = serialEquipo.split("~")[2];

      String serialesAnalizador = seriales.split(";")[0];
      String valorPef = serialesAnalizador.split("-")[0];
      String serialAnalizadorBanco = serialesAnalizador.replace(valorPef+"-", "");

      String serialesKitRpm = seriales.split(";")[1];
      String serialTermohigrometro = seriales.split(";")[2];

      
      params.put("nombreGases", "Analizador de gases\nBanco de gases");
      params.put("PefGases", valorPef);
      params.put("InstGases", serialAnalizadorBanco);
      params.put("MarcaGases", marcas.split(";")[0]);

      String nombreRpm = 
          serialesKitRpm.split("/").length > 2 ? 
              "Captador RPM y temperatura" : "Captador RPM";

      params.put("RpmSondaTemp", nombreRpm);
      params.put("MarcaRpm", marcas.split(";")[1]);
      params.put("InstRpm", serialesKitRpm);

      params.put("InstTermo", serialTermohigrometro);
      params.put("MarcaTermo", marcas.split(";")[2]);

    } else if(serialEquipo != null && serialEquipo.startsWith("diesel")){

        String marcas = serialEquipo.split("~")[1];
        String seriales = serialEquipo.split("~")[2];

        String serialesAnalizador = seriales.split(";")[0];
        String valorLtoe = serialesAnalizador.split("-")[0];
        String serialAnalizadorBanco = serialesAnalizador.replace(valorLtoe+"-", "");

        String serialesKitRpm = seriales.split(";")[1];
        String serialTermohigrometro = seriales.split(";")[2];

        params.put("nombreGases", "Opacimetro");
        params.put("PefGases", valorLtoe);
        params.put("InstGases", serialAnalizadorBanco);
        params.put("MarcaGases", marcas.split(";")[0]);

        String nombreRpm =  "Captador RPM y temperatura";

        params.put("RpmSondaTemp", nombreRpm);
        params.put("MarcaRpm", marcas.split(";")[1]);
        params.put("InstRpm", serialesKitRpm);

        params.put("InstTermo", serialTermohigrometro);
        params.put("MarcaTermo", marcas.split(";")[2]);
    }

    return params;
  }


  private String getSerialRelevante(String serialCompleto) {
      if (serialCompleto == null || serialCompleto.isEmpty()) {
          return null; // Manejar valores nulos o vacíos
      }

      // Verificar si el serial contiene un punto y coma
      if (serialCompleto.contains(";")) {
          // Dividir el serial por el punto y coma y tomar la primera parte
          return serialCompleto.split(";")[0].trim();
      }

      // Si no hay punto y coma, devolver el serial completo
      return serialCompleto.trim();
  }

  public FurService(CdaRep cdaRep, HojaPruebasRep hojaPruebasRep, 
    VehiculosRep vehiculoRep, PropietariosRep propietariosRep, CiudadesRep ciudadesRep, 
    DepartamentosRep departamentosRep, ClasesVehiculoRep clasesVehiculoRep, PaisRep paisRep, ServiciosRep serviciosRep,
    MarcasVehiculoRep marcasVehiculoRep, LineasVehiculoRep lineasVehiculoRep, ColorRep coloresRep,
    TipoCombustibleRep tipoCombustibleRep, TipoCarroceriaRep tipoCarroceriaRep, MedidasRep medidasRep, PruebasRep pruebasRep, LlantasRep llantasRep,
    EquipoRep equiposRep, FotosRep fotosRep, DefxpruebaRep defxpruebaRep, DefectosRep defectosRep, GruposRep gruposRep,
    DgsgRep dgsgRep, TipoPruebaRep tipoPruebaRep, UsuariosRep usuariosRep, GruposSubGruposRep gruposSubGruposRep) {
      this.cdaRep = cdaRep;
      this.hojaPruebasRep = hojaPruebasRep;
      this.vehiculoRep = vehiculoRep;
      this.propietariosRep = propietariosRep;
      this.ciudadesRep = ciudadesRep;
      this.departamentosRep = departamentosRep; 
      this.clasesVehiculoRep = clasesVehiculoRep;
      this.paisRep = paisRep;
      this.serviciosRep = serviciosRep;
      this.marcasVehiculoRep = marcasVehiculoRep;
      this.lineasVehiculoRep = lineasVehiculoRep;
      this.coloresRep = coloresRep;
      this.tipoCombustibleRep = tipoCombustibleRep;
      this.tipoCarroceriaRep = tipoCarroceriaRep;
      this.medidasRep = medidasRep;
      this.pruebasRep = pruebasRep;
      this.llantasRep = llantasRep;
      this.equiposRep = equiposRep;
      this.fotosRep = fotosRep;
      this.gruposRep = gruposRep;
      this.defxpruebaRep = defxpruebaRep;
      this.defectosRep = defectosRep;
      this.tipoPruebaRep = tipoPruebaRep;
      this.usuariosRep = usuariosRep;
      this.dgsgRep = dgsgRep;
      this.gruposSubGruposRep = gruposSubGruposRep;
  }



}
