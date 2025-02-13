package com.soltelec.reportefur.models.dtos.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class MedidasDto {
    private Integer measure;
    private Integer measureType;
    private Float valorMedida;
    private Integer test;
    private String condicion;
    private String simult;
}