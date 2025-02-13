package com.soltelec.reportefur.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.soltelec.reportefur.models.entities.Medidas;

public interface MedidasRep extends CrudRepository<Medidas, Integer> {
    
    @Query("SELECT * FROM medidas WHERE TEST = :idPrueba")
    List<Medidas> findByIdPrueba(@Param("idPrueba") Integer idPrueba);


} 