package br.edu.ifpb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    public List<Patient> findByNome(String nome);

    public List<Patient> findByCpf(String cpf);
}