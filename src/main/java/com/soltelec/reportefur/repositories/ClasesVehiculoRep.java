package com.soltelec.reportefur.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soltelec.reportefur.models.entities.ClasesVehiculo;

@Repository
public interface ClasesVehiculoRep extends CrudRepository<ClasesVehiculo, Integer> {
    // Aquí puedes agregar métodos personalizados de consulta si los necesitas
}
