package com.soltelec.reportefur.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.soltelec.reportefur.models.entities.Defxprueba;

public interface DefxpruebaRep extends CrudRepository<Defxprueba, Integer> {
    
    @Query(value = "SELECT * FROM defxprueba WHERE id_prueba = :idPrueba")
    List<Defxprueba> findByIdPrueba(@Param("idPrueba") Integer idPrueba);
}
