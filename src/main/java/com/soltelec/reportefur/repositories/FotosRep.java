package com.soltelec.reportefur.repositories;



import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.soltelec.reportefur.models.entities.Fotos;

public interface FotosRep extends CrudRepository<Fotos, Integer> {

    @Query("Select * from fotos f where f.id_hoja_pruebas_for = :idHojaPruebas")
    Fotos findFotosByHojaPruebas(@Param("idHojaPruebas") Integer idHojaPruebas);
    
} 