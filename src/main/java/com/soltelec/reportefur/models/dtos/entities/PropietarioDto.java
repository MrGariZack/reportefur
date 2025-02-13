package com.soltelec.reportefur.models.dtos.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PropietarioDto {
  private String apellidos;
  private String nombres;
  private String tipoDoc;
  private String cedula;
  private String direccion;
  private String numeroTelefono;
  private String ciudad;
  private String departamento;
  private String email;
  private String fechaRevision;
}
