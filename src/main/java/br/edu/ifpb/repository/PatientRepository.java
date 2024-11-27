package br.edu.ifpb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}