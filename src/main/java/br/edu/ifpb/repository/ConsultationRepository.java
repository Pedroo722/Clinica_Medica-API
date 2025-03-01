package br.edu.ifpb.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.model.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    @Query("SELECT p FROM Consultation p WHERE LOWER(p.status) LIKE LOWER(CONCAT('%', :status, '%'))")
    public List<Consultation> findByStatus(String status);

    public List<Consultation> findByData(LocalDate data);
}