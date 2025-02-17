package com.soltelec.reportefur.models.entities;

import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;

@Data
public class GruposSubGrupos {

    @Column("DEFGROUP")
    private Integer groupId;

    @Column("SCDEFGROUPSUB")
    private String subGroupId;

    @Column("CARTYPE")
    private Integer cartypeId;
}
