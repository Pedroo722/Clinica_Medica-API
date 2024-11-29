package br.edu.ifpb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.model.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    public Optional<Record> findByPacienteId(Long pacienteId);
}