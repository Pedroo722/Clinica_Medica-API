package br.edu.ifpb.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.model.Consultation;
import br.edu.ifpb.repository.ConsultationRepository;

@Service
public class ConsultationService {
    @Autowired
    private ConsultationRepository consultationRepository;

    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    public Optional<Consultation> getConsultationById(Long id) {
        return consultationRepository.findById(id);
    }

    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public void deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
    }

    public List<Consultation> findConsultationByData(LocalDate data) {
        return consultationRepository.findByData(data);
    }

    public List<Consultation> findConsultationByStatus(String status) {
        return consultationRepository.findByStatus(status);
    }
}