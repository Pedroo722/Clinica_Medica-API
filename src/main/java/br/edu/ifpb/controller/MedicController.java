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

import br.edu.ifpb.model.Medic;
import br.edu.ifpb.service.MedicService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/medics")
public class MedicController {

    @Autowired
    private MedicService medicService;

    @GetMapping
    public List<Medic> getAllMedics() {
        return medicService.getAllMedics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medic> getMedicById(@PathVariable("id") Long id) {
        return medicService.getMedicById(id)
                          .map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createMedic(@RequestBody Medic medic) {
        Medic savedMedic = medicService.saveMedic(medic);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMedic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMedic(@PathVariable("id") Long id, @RequestBody Medic medic) {
        if (!medicService.getMedicById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        medic.setId(id);
        Medic updatedMedic = medicService.saveMedic(medic);
        return ResponseEntity.ok(updatedMedic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedic(@PathVariable("id") Long id) {
        if (medicService.getMedicById(id).isPresent()) {
            medicService.deleteMedic(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}