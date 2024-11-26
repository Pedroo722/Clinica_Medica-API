package br.edu.ifpb.controller;

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
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.service.PatientService;
import br.edu.ifpb.model.Patient;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Long id) {
        return patientService.getPatientById(id)
                          .map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.savePatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable("id") Long id, @RequestBody Patient patient) {
        if (!patientService.getPatientById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        patient.setId(id);
        Patient updatedPatient = patientService.savePatient(patient);
        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable("id") Long id) {
        if (patientService.getPatientById(id).isPresent()) {
            patientService.deletePatient(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}