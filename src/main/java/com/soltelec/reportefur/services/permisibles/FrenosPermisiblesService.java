package com.soltelec.reportefur.services.permisibles;

import java.util.HashMap;
import java.util.Map;
import com.soltelec.reportefur.models.dtos.entities.VehiculoDto;

public class FrenosPermisiblesService {

    public Map<String, String> getPermisiblesMotocicleta(VehiculoDto vehiculo) {
        Map<String, String> params = new HashMap<>();
        
        // Para motocicletas:
        // - No aplica desequilibrio
        // - Eficiencia total mínima de 30%
        // - No aplica freno auxiliar
        params.put("PerDeseqB", "---");
        params.put("PerDeseq", "---");
        params.put("PerEficTotal", "30");
        params.put("PerEficAux", "---");
        
        return params;
    }

    public Map<String, String> getPermisiblesVehiculoGeneral(VehiculoDto vehiculo) {
        Map<String, String> params = new HashMap<>();
        
        // Para vehículos en general:
        // - Desequilibrio máximo permitido 30%
        // - Eficiencia total mínima de 50%
        // - Eficiencia de freno auxiliar mínima de 18%
        params.put("PerDeseqB", "20-30");
        params.put("PerDeseq", ">30");
        params.put("PerEficTotal", "50");
        params.put("PerEficAux", "18");
        
        return params;
    }
} 