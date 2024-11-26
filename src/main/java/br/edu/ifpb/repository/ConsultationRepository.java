package br.edu.ifpb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.model.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}