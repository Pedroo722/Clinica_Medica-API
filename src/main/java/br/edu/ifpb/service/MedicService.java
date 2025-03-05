package br.edu.ifpb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.model.Medic;
import br.edu.ifpb.repository.MedicRepository;
import br.edu.ifpb.util.MedicValidations;

@Service
public class MedicService {
    @Autowired
    private MedicRepository medicRepository;

    public List<Medic> getAllMedics() {
        return medicRepository.findAll();
    }

    public Optional<Medic> getMedicById(Long id) {
        return medicRepository.findById(id);
    }

    public Medic saveMedic(Medic medic) {
        MedicValidations.validateEmail(medic.getEmail());
        MedicValidations.validateCRM(medic.getCrm());
        return medicRepository.save(medic);
    }

    public void deleteMedic(Long id) {
        medicRepository.deleteById(id);
    }

    public List<Medic> findMedicByName(String name) {
        return medicRepository.findByName(name);
    }

    public List<Medic> findMedicByCRM(String crm) {
        return medicRepository.findByCrm(crm);
    }
}