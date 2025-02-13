package com.soltelec.reportefur.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soltelec.reportefur.models.entities.Cda;

@Repository
public interface CdaRep extends CrudRepository<Cda, Integer> {
    // Aquí puedes agregar métodos personalizados de consulta si los necesitas
}
