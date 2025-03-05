package br.edu.ifpb.controller;

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

import br.edu.ifpb.exceptions.InvalidCRMException;
import br.edu.ifpb.exceptions.InvalidEmailException;
import br.edu.ifpb.model.Medic;
import br.edu.ifpb.service.MedicService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/medics")
public class MedicController {

    @Autowired
    private MedicService medicService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllMedics(
        @RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "crm", required = false) String crm) {
        try {
            List<Medic> medics;

            if (name != null) {
                medics = medicService.findMedicByName(name);
            } else if (crm != null) {
                medics = medicService.findMedicByCRM(crm);
            } else {
                medics = medicService.getAllMedics();
            }

            return ResponseEntity.ok(medics);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving medics.");
        }
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> getMedicById(@PathVariable("id") Long id) {
        try {
            return medicService.getMedicById(id)
                    .map(ResponseEntity::ok)
                    .orElseThrow(() -> new NoSuchElementException("Medic not found"));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving medic.");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMedic(@RequestBody Medic medic) {
        try {
            Medic savedMedic = medicService.saveMedic(medic);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMedic);
        } catch (InvalidEmailException | InvalidCRMException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating medic.");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMedic(@PathVariable("id") Long id, @RequestBody Medic medic) {
        try {
            if (!medicService.getMedicById(id).isPresent()) {
                throw new NoSuchElementException("Medic not found");
            }

            medic.setId(id);
            Medic updatedMedic = medicService.saveMedic(medic);
            return ResponseEntity.ok(updatedMedic);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (InvalidEmailException | InvalidCRMException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating medic.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMedic(@PathVariable("id") Long id) {
        try {
            if (!medicService.getMedicById(id).isPresent()) {
                throw new NoSuchElementException("Medic not found");
            }
            medicService.deleteMedic(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting medic.");
        }
    }
}