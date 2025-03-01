package br.edu.ifpb.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.model.Consultation;
import br.edu.ifpb.service.ConsultationService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/consultations")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @GetMapping("/list")
    public ResponseEntity<List<Consultation>> getAllConsultations(
        @RequestParam(value = "data", required = false) LocalDate data,
        @RequestParam(value = "status", required = false) String status) {
        List<Consultation> consultations;

        if (status != null) {
            consultations = consultationService.findConsultationByStatus(status);
        } else if (data != null) {
            consultations = consultationService.findConsultationByData(data);
        } else {
            consultations = consultationService.getAllConsultations();
        }

        return ResponseEntity.ok(consultations);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Consultation> getConsultationById(@PathVariable("id") Long id) {
        return consultationService.getConsultationById(id)
                          .map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createConsultation(@RequestBody Consultation consultation) {
        Consultation savedConsultation = consultationService.saveConsultation(consultation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedConsultation);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateConsultation(@PathVariable("id") Long id, @RequestBody Consultation consultation) {
        if (!consultationService.getConsultationById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        consultation.setId(id);
        Consultation updatedConsultation = consultationService.saveConsultation(consultation);
        return ResponseEntity.ok(updatedConsultation);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteConsultation(@PathVariable("id") Long id) {
        if (consultationService.getConsultationById(id).isPresent()) {
            consultationService.deleteConsultation(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}