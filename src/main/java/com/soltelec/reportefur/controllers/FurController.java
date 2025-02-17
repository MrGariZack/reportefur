package com.soltelec.reportefur.controllers;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.ContentDisposition;

import com.soltelec.reportefur.services.FurService;

@Controller
@RequestMapping


public class FurController {
  private final FurService furService;

  public FurController(FurService furService) {
    this.furService = furService;
  }

  @PostMapping("/generate")
  public ResponseEntity<byte[]> generatePDF(@RequestBody Map<String, Integer> payload) {
      try {
          Integer hojaPruebaId = payload.get("hojaPruebaId");
          System.out.println("ID de la hoja de pruebas: " + hojaPruebaId);
          if (hojaPruebaId == null) {
              throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID de la hoja de pruebas es requerido");
          }
          
          byte[] pdfBytes = furService.savePdfToDataBaseTest(hojaPruebaId);
          
          HttpHeaders headers = new HttpHeaders();
          headers.setContentType(MediaType.APPLICATION_PDF);
          headers.setContentDisposition(ContentDisposition.builder("attachment")
                  .filename("FUR_" + hojaPruebaId + ".pdf")
                  .build());
          
          return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
      } catch (Exception e) {
          e.printStackTrace();
          throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
      }
  }
}
