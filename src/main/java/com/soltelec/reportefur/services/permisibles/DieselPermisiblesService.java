package com.soltelec.reportefur.services.permisibles;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import com.soltelec.reportefur.models.dtos.entities.VehiculoDto;

public class DieselPermisiblesService {

    public Map<String, String> getPermisiblesDiesel(VehiculoDto vehiculo, Date fechaIngreso) {
        Map<String, String> params = new HashMap<>();
        
        // Para vehículos diesel:
        // - No aplican HC, CO en ralentí ni crucero
        params.put("PerHCRal", "---");
        params.put("PerCORal", "---");
        params.put("PerHCCruc", "---");
        params.put("PerCOCruc", "---");

        // Fecha de referencia: 1 de enero de 2025
        Date permisiblesDiesel2025 = new Date(125, 0, 1); // Año 2025 - 1900, mes 0 basado en cero (enero)
        System.out.println("fechaIngreso: " + fechaIngreso);
        System.out.println("permisiblesDiesel2025: " + permisiblesDiesel2025);
        boolean esPosterior2025 = fechaIngreso.after(permisiblesDiesel2025);

        // Calcular permisible de opacidad según cilindraje y modelo
        String perOpacValue = calcularPermisibleOpacidad(
            vehiculo.getCilindraje(),
            vehiculo.getModelo(),
            esPosterior2025
        );
        
        params.put("PerOpac", perOpacValue);
        params.put("diametro", "430"); // Valor fijo según el código original

        return params;
    }

    private String calcularPermisibleOpacidad(Integer cilindraje, Integer modelo, boolean esPosterior2025) {
        // Para vehículos con cilindraje menor a 5000
        if (cilindraje < 5000) {
            if (modelo > 2000 && modelo <= 2015) {
                return esPosterior2025 ? "3.5" : "5.0";
            } else if (modelo >= 2016) {
                return esPosterior2025 ? "2.5" : "4.0";
            } else if (modelo <= 2000) {
                return esPosterior2025 ? "4.5" : "6.0";
            }
        }
        // Para vehículos con cilindraje mayor o igual a 5000
        else {
            if (modelo > 2000 && modelo <= 2015) {
                return esPosterior2025 ? "3.0" : "4.5";
            } else if (modelo >= 2016) {
                return esPosterior2025 ? "2.0" : "3.5";
            } else if (modelo <= 2000) {
                return esPosterior2025 ? "4.0" : "5.5";
            }
        }
        
        throw new RuntimeException("Error al calcular permisibles diesel: modelo o cilindraje fuera de rango");
    }
} 