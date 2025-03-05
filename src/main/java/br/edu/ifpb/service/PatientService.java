package br.edu.ifpb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.model.Patient;
import br.edu.ifpb.repository.PatientRepository;
import br.edu.ifpb.util.PatientValidations;

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
        PatientValidations.validateEmail(patient.getEmail());
        PatientValidations.validateCPF(patient.getCpf());
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> findPatientByName(String name) {
        return patientRepository.findByNome(name);
    }
    
    public List<Patient> findPatientByCpf(String cpf) {
        return patientRepository.findByCpf(cpf);
    }
}