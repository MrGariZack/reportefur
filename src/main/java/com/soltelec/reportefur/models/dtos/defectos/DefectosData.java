package com.soltelec.reportefur.models.dtos.defectos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefectosData {
  private String codigoDefecto;
  private String descripcionDefecto;
  private String grupoDefecto;
  private String a;
  private String b;
}

