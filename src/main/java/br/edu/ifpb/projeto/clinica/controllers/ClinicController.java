package br.edu.ifpb.projeto.clinica.controllers;

import br.edu.ifpb.projeto.clinica.domain.*;
import br.edu.ifpb.projeto.clinica.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/clinic")

public class ClinicController {
    // @Autowired
    // private ClinicService service;

    // @GetMapping("/info/{year}")
    // public ResponseEntity<List<ClinicResponseDTO>> getClinicsInfo(@PathVariable String year) {
    //     return ResponseEntity.ok(service.getClinicsInformation(year));
    // }

    // @GetMapping("/info/{year}/{code}")
    // public ResponseEntity<ClinicResponseDTO> getClinicsInfoById(@PathVariable String year, @PathVariable String code) {
    //     return ResponseEntity.ok(service.getClinicsInformationById(code, year));
    // }

    // @GetMapping("/data/{year}/{code}")
    // public ResponseEntity<Page<Data>> getClinicDataById(@PathVariable String year,
    //                                                  @PathVariable String code,
    //                                                  @RequestParam(defaultValue = "0") int page,
    //                                                  @RequestParam(defaultValue = "24") int size) {
    //     return ResponseEntity.ok(service.getPaginatedDataForClinicAndYear(code, year, page, size));
    // }

    // @GetMapping("/data/{code}")
    // public ResponseEntity<WeatherSummaryResponseDTO> getStatioDataByDate(@PathVariable String code, @RequestParam LocalDate date) {
    //     return ResponseEntity.ok(service.getWeatherDataByDate(code, date));
    // }

    // @GetMapping("/data/{year}/{month}/{code}")
    // public ResponseEntity<Page<WeatherSummaryResponseDTO>> getDataByMonth(    @PathVariable String year,
    //                                                      @PathVariable String code,
    //                                                      @PathVariable int month,
    //                                                      @RequestParam(defaultValue = "0") int page,
    //                                                      @RequestParam(defaultValue = "24") int size) {
    //     return ResponseEntity.ok(service.getPaginatedDataByMonth(code, year, month, page, size));
    // }
}