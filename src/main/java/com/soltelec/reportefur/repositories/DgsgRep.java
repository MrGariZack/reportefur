package com.soltelec.reportefur.repositories;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.soltelec.reportefur.models.entities.Dgsg;


public interface DgsgRep extends CrudRepository<Dgsg, Integer> {

    @Query("SELECT * FROM defectos_grupos_sub_grupos dgsg WHERE dgsg.id_defecto = :idDefecto AND dgsg.id_tipo_vehiculo = :idTPVehiculo limit 1")
    Optional<Dgsg> findByIdDefectoAndTipoVehiculo(@Param("idDefecto") Integer idDefecto, @Param("idTPVehiculo") Integer idTPVehiculo);

} 