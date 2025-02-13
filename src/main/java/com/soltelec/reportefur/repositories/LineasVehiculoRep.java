package com.soltelec.reportefur.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soltelec.reportefur.models.entities.LineasVehiculo;

@Repository
public interface LineasVehiculoRep extends CrudRepository<LineasVehiculo, Integer> {
    // Aquí puedes agregar métodos personalizados de consulta si los necesitas
}
