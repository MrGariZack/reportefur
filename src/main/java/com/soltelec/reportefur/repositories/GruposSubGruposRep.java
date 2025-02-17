package com.soltelec.reportefur.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jdbc.repository.query.Query;
import java.util.Optional;

import com.soltelec.reportefur.models.entities.GruposSubGrupos;

public interface GruposSubGruposRep extends CrudRepository<GruposSubGrupos, Integer> {

    @Query("SELECT * FROM grupos_sub_grupos gsg WHERE gsg.CARTYPE = :cartypeId AND gsg.SCDEFGROUPSUB = :subGroupId LIMIT 1")
    Optional<GruposSubGrupos> findByCartypeIdAndSubGroupId(@Param("cartypeId") Integer cartypeId, @Param("subGroupId") Integer subGroupId);
} 

