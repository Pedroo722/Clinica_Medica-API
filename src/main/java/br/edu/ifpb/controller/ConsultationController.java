package br.edu.ifpb.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

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
    public ResponseEntity<?> getAllConsultations(
        @RequestParam(value = "data", required = false) LocalDate data,
        @RequestParam(value = "status", required = false) String status) {
        try {
            List<Consultation> consultations;

            if (status != null) {
                consultations = consultationService.findConsultationByStatus(status);
            } else if (data != null) {
                consultations = consultationService.findConsultationByData(data);
            } else {
                consultations = consultationService.getAllConsultations();
            }

            return ResponseEntity.ok(consultations);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving consultations.");
        }
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> getConsultationById(@PathVariable("id") Long id) {
        try {
            return consultationService.getConsultationById(id)
                    .map(ResponseEntity::ok)
                    .orElseThrow(() -> new NoSuchElementException("Consultation not found"));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving consultation.");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createConsultation(@RequestBody Consultation consultation) {
        try {
            Consultation savedConsultation = consultationService.saveConsultation(consultation);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedConsultation);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating consultation.");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateConsultation(@PathVariable("id") Long id, @RequestBody Consultation consultation) {
        try {
            if (!consultationService.getConsultationById(id).isPresent()) {
                throw new NoSuchElementException("Consultation not found");
            }

            consultation.setId(id);
            Consultation updatedConsultation = consultationService.saveConsultation(consultation);
            return ResponseEntity.ok(updatedConsultation);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating consultation.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteConsultation(@PathVariable("id") Long id) {
        try {
            if (!consultationService.getConsultationById(id).isPresent()) {
                throw new NoSuchElementException("Consultation not found");
            }
            consultationService.deleteConsultation(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting consultation.");
        }
    }
}