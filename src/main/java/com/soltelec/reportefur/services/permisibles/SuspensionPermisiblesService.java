package com.soltelec.reportefur.services.permisibles;

import java.util.HashMap;
import java.util.Map;
import com.soltelec.reportefur.models.dtos.entities.VehiculoDto;

public class SuspensionPermisiblesService {

    public Map<String, String> getPermisiblesMotocicleta(VehiculoDto vehiculo) {
        Map<String, String> params = new HashMap<>();
        
        // Para motocicletas, no aplican los permisibles de suspensión
        params.put("PerSusp", "---");
        
        return params;
    }

    public Map<String, String> getPermisiblesVehiculoGeneral(VehiculoDto vehiculo) {
        Map<String, String> params = new HashMap<>();
        
        // Para vehículos en general, el valor permisible es 40%
        params.put("PerSusp", "40");
        
        return params;
    }
} 