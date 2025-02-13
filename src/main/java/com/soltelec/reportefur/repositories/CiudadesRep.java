package com.soltelec.reportefur.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soltelec.reportefur.models.entities.Ciudades;

@Repository
public interface CiudadesRep extends CrudRepository<Ciudades, Integer> {
    // Aquí puedes agregar métodos personalizados de consulta si los necesitas
}
