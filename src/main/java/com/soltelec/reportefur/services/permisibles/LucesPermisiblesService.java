package com.soltelec.reportefur.services.permisibles;

import java.util.HashMap;
import java.util.Map;
import com.soltelec.reportefur.models.dtos.entities.VehiculoDto;

public class LucesPermisiblesService {

    public Map<String, String> getPermisiblesMotocicleta(VehiculoDto vehiculo) {
        Map<String, String> params = new HashMap<>();
        
        // Para motocicletas, no aplican los permisibles de luces
        params.put("perSumaLuces", "---");
        
        return params;
    }

    public Map<String, String> getPermisiblesVehiculoGeneral(VehiculoDto vehiculo) {
        Map<String, String> params = new HashMap<>();
        
        // Para vehículos en general
        params.put("perSumaLuces", "225");
        
        return params;
    }
} 