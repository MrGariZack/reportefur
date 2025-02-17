package com.soltelec.reportefur.services.permisibles;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.soltelec.reportefur.models.dtos.entities.VehiculoDto;

public class GasesPermisiblesService {
    private static final String FECHA_RESOLUCION_2022 = "2022-08-18 00:00:00";
    private static final String FECHA_RESOLUCION_2023 = "2023-02-07 23:59:59";

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final Date fechaInicioResolucion;
    private final Date fechaInicioResolucion0762Tabla27;

    public GasesPermisiblesService() {
        try {
            this.fechaInicioResolucion = sdf.parse(FECHA_RESOLUCION_2022);
            this.fechaInicioResolucion0762Tabla27 = sdf.parse(FECHA_RESOLUCION_2023);
        } catch (ParseException e) {
            throw new RuntimeException("Error inicializando fechas de resolución", e);
        }
    }

    public Map<String, String> getPermisiblesMotocicleta(VehiculoDto vehiculo, Date fechaIngreso) {
        Map<String, String> params = new HashMap<>();
        
        // Configurar O2
        if (vehiculo.getTiemposMotor() == 4 || 
            (vehiculo.getTiemposMotor() == 2 && vehiculo.getModelo() >= 2010)) {
            params.put("PerO2", "[0-6]");
        } else {
            params.put("PerO2", "[0-11]");
        }

        // CO2 no aplica para motos
        params.put("PerCO2", "---");

        // Configurar HC y CO en Ralentí
        if (vehiculo.getTiemposMotor() == 2) {
            configurarPermisiblesMotoDosTempos(params, vehiculo, fechaIngreso);
        } else {
            configurarPermisiblesMotoCuatroTempos(params, fechaIngreso);
        }

        // Valores en crucero no aplican para motos
        params.put("PerHCCruc", "---");
        params.put("PerCOCruc", "---");

        return params;
    }

    private void configurarPermisiblesMotoDosTempos(
        Map<String, String> params, 
        VehiculoDto vehiculo,
        Date fechaIngreso
    ) {
        if (vehiculo.getModelo() <= 2009) {
            if (fechaIngreso.after(fechaInicioResolucion0762Tabla27)) {
                params.put("PerHCRal", "[0-8000]");
                params.put("PerCORal", "[0-3.5]");
            } else {
                params.put("PerHCRal", "[0-10000]");
                params.put("PerCORal", "[0-4.5]");
            }
        } else {
            if (fechaIngreso.after(fechaInicioResolucion) && 
                fechaIngreso.before(fechaInicioResolucion0762Tabla27)) {
                params.put("PerHCRal", "[0-1600]");
                params.put("PerCORal", "[0-3.6]");
            } else if (fechaIngreso.after(fechaInicioResolucion0762Tabla27)) {
                params.put("PerHCRal", "[0-1600]");
                params.put("PerCORal", "[0-3.5]");
            } else {
                params.put("PerHCRal", "[0-2000]");
                params.put("PerCORal", "[0-4.5]");
            }
        }
    }

    private void configurarPermisiblesMotoCuatroTempos(
        Map<String, String> params,
        Date fechaIngreso
    ) {
        if (fechaIngreso.after(fechaInicioResolucion) && 
            fechaIngreso.before(fechaInicioResolucion0762Tabla27)) {
            params.put("PerHCRal", "[0-1600]");
            params.put("PerCORal", "[0-3.6]");
        } else if (fechaIngreso.after(fechaInicioResolucion0762Tabla27)) {
            params.put("PerHCRal", "[0-1300]");
            params.put("PerCORal", "[0-3.5]");
        } else {
            params.put("PerHCRal", "[0-2000]");
            params.put("PerCORal", "[0-4.5]");
        }
    }

    public Map<String, String> getPermisiblesVehiculoGasolina(VehiculoDto vehiculo, Date fechaIngreso) {
        Map<String, String> params = new HashMap<>();
        
        params.put("PerO2", "[0-5]");
        params.put("PerCO2", "[ <7 ]");

        if (fechaIngreso.before(fechaInicioResolucion0762Tabla27)) {
            configurarPermisiblesGasolinaAnteriores2023(params, vehiculo);
        } else {
            configurarPermisiblesGasolinaPosteriores2023(params, vehiculo);
        }

        return params;
    }

    private void configurarPermisiblesGasolinaAnteriores2023(
        Map<String, String> params, 
        VehiculoDto vehiculo
    ) {
        int modelo = vehiculo.getModelo();
        if (modelo <= 1970) {
            params.put("PerHCRal", "[0-800]");
            params.put("PerCORal", "[0-5.0]");
            params.put("PerHCCruc", "[0-800]");
            params.put("PerCOCruc", "[0-5.0]");
        } else if (modelo <= 1984) {
            params.put("PerHCRal", "[0-650]");
            params.put("PerCORal", "[0-4.0]");
            params.put("PerHCCruc", "[0-650]");
            params.put("PerCOCruc", "[0-4.0]");
        } else if (modelo <= 1997) {
            params.put("PerHCRal", "[0-400]");
            params.put("PerCORal", "[0-3.0]");
            params.put("PerHCCruc", "[0-400]");
            params.put("PerCOCruc", "[0-3.0]");
        } else {
            params.put("PerHCRal", "[0-200]");
            params.put("PerCORal", "[0-1.0]");
            params.put("PerHCCruc", "[0-200]");
            params.put("PerCOCruc", "[0-1.0]");
        }
    }

    private void configurarPermisiblesGasolinaPosteriores2023(
        Map<String, String> params, 
        VehiculoDto vehiculo
    ) {
        int modelo = vehiculo.getModelo();
        if (modelo <= 1984) {
            params.put("PerHCRal", "[0-650]");
            params.put("PerCORal", "[0-4.0]");
            params.put("PerHCCruc", "[0-650]");
            params.put("PerCOCruc", "[0-4.0]");
        } else if (modelo <= 1997) {
            params.put("PerHCRal", "[0-400]");
            params.put("PerCORal", "[0-3.0]");
            params.put("PerHCCruc", "[0-400]");
            params.put("PerCOCruc", "[0-3.0]");
        } else if (modelo <= 2009) {
            params.put("PerHCRal", "[0-200]");
            params.put("PerCORal", "[0-1.0]");
            params.put("PerHCCruc", "[0-200]");
            params.put("PerCOCruc", "[0-1.0]");
        } else {
            params.put("PerHCRal", "[0-160]");
            params.put("PerCORal", "[0-0.8]");
            params.put("PerHCCruc", "[0-160]");
            params.put("PerCOCruc", "[0-0.8]");
        }
    }
} 