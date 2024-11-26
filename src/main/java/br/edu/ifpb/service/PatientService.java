package br.edu.ifpb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.repository.PatientRepository;
import br.edu.ifpb.model.Patient;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public Optional<Patient> findPatientByNome(String nome) {
        return patientRepository.findAll().stream()
                             .filter(patient -> patient.getNome().equals(nome))
                             .findFirst();
    }
}