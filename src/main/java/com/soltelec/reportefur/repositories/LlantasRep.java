package com.soltelec.reportefur.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soltelec.reportefur.models.entities.Llantas;

@Repository
public interface LlantasRep extends CrudRepository<Llantas, Integer> {
    // Aquí puedes agregar métodos personalizados de consulta si los necesitas
}
