package com.soltelec.reportefur.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.soltelec.reportefur.models.entities.Pruebas;

public interface PruebasRep extends CrudRepository<Pruebas, Integer> {
    
    @Query("Select * from pruebas p where p.hoja_pruebas_for = :idHojaPruebas")
    List<Pruebas> findPruebasByHojaPruebas(@Param("idHojaPruebas") Integer idHojaPruebas);

    @Query("Select p.Id_Pruebas from pruebas p where p.hoja_pruebas_for = :idHojaPruebas and p.Tipo_prueba_for = :tipoPrueba order by p.Id_Pruebas desc limit 1")
    Optional<Integer> findIdPrueba(@Param("idHojaPruebas") Integer idHojaPruebas, @Param("tipoPrueba") Integer tipoPrueba);
}

