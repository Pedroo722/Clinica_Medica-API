package br.edu.ifpb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.model.Record;
import br.edu.ifpb.repository.RecordRepository;

@Service
public class RecordService {
    @Autowired
    private RecordRepository recordRepository;

    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    public Optional<Record> getRecordById(Long id) {
        return recordRepository.findById(id);
    }

    public Record saveRecord(Record medic) {
        return recordRepository.save(medic);
    }

    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }

    public Optional<Record> findRecordByPatientId(Long patientId) {
        return recordRepository.findByPatientId(patientId);
    }
}