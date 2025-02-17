package com.soltelec.reportefur.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import com.soltelec.reportefur.models.entities.Equipo;

public interface EquipoRep extends CrudRepository<Equipo, Integer> {


    @Query("Select * from equipos")
    List<Equipo> listAll();

    @Query("SELECT * FROM equipos e WHERE e.serial LIKE CONCAT('%', :serial, '%') limit 1")
    Optional<Equipo> findBySerial(@Param("serial") String serial);

    
    @Query("SELECT * FROM equipos e WHERE e.serialresolucion LIKE CONCAT('%', :serialResolucion, '%') limit 1")
    Optional<Equipo> findBySerialResolucion(@Param("serialResolucion") String serialResolucion);
    
} 