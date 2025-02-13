package com.soltelec.reportefur.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.soltelec.reportefur.models.entities.Defectos;

public interface DefectosRep extends CrudRepository<Defectos, Integer> {
    
    @Query(value = "SELECT * FROM defectos WHERE CARDEFAULT = :idDefecto")
    Defectos findByIdDefecto(@Param("idDefecto") Integer idDefecto);
}
