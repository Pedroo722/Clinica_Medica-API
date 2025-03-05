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

import br.edu.ifpb.model.Record;
import br.edu.ifpb.service.RecordService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/records")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllRecords(
        @RequestParam(value = "id_paciente", required = false) Long patientId) {
        try {
            List<Record> records;

            if (patientId != null) {
                records = recordService.findRecordsByPatientId(patientId);
            } else {
                records = recordService.getAllRecords();
            }

            return ResponseEntity.ok(records);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar registros.");
        }
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> getRecordById(@PathVariable("id") Long id) {
        try {
            return recordService.getRecordById(id)
                    .map(ResponseEntity::ok)
                    .orElseThrow(() -> new NoSuchElementException("Registro não encontrado"));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar registro.");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createRecord(@RequestBody Record record) {
        try {
            Record savedRecord = recordService.saveRecord(record);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRecord);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar registro.");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRecord(@PathVariable("id") Long id, @RequestBody Record record) {
        try {
            if (!recordService.getRecordById(id).isPresent()) {
                throw new NoSuchElementException("Registro não encontrado");
            }

            record.setId(id);
            Record updatedRecord = recordService.saveRecord(record);
            return ResponseEntity.ok(updatedRecord);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar registro.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRecord(@PathVariable("id") Long id) {
        try {
            if (!recordService.getRecordById(id).isPresent()) {
                throw new NoSuchElementException("Registro não encontrado");
            }
            recordService.deleteRecord(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir registro.");
        }
    }
}