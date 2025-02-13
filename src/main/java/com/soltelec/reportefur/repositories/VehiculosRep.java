package com.soltelec.reportefur.repositories;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.soltelec.reportefur.models.entities.Vehiculos;

public interface VehiculosRep extends CrudRepository<Vehiculos, Integer>{
  @Query("SELECT * FROM vehiculos WHERE placa = :placa")
  Optional<Vehiculos> findByPlaca(@Param("placa") String placa);
   
  
 
   



}
