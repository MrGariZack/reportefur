package com.soltelec.reportefur.services.permisibles;

import java.util.HashMap;
import java.util.Map;
import com.soltelec.reportefur.models.dtos.entities.VehiculoDto;

public class DesviacionesPermisiblesService {

    public Map<String, String> getPermisiblesMotocicleta(VehiculoDto vehiculo) {
        Map<String, String> params = new HashMap<>();
        
        // Para motocicletas, no aplican los permisibles de desviación
        params.put("PerDesv", "---");
        
        return params;
    }

    public Map<String, String> getPermisiblesVehiculoGeneral(VehiculoDto vehiculo) {
        Map<String, String> params = new HashMap<>();
        
        // Para vehículos en general, el valor permisible es 10 m/km
        params.put("PerDesv", "10");
        
        return params;
    }
} 