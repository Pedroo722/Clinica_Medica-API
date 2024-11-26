package br.edu.ifpb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.model.Medic;

@Repository
public interface MedicRepository extends JpaRepository<Medic, Long> {
}