package br.edu.ifpb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.model.Medic;

@Repository
public interface MedicRepository extends JpaRepository<Medic, Long> {
    @Query("SELECT p FROM Medic p WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    public List<Medic> findByName(String nome);

    public List<Medic> findByCrm(String crm);
}