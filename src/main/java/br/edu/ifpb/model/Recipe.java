package br.edu.ifpb.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "receita")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificador_receita")
    private Long id;

    @Column(name = "medicamentos_prescritos", nullable = false)
    private String medicamentosPrescritos;

    @Column(name = "validade", nullable = false)
    private LocalDate validade;

    @Column(name = "observacoes")
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "id_consulta", nullable = false)
    private Consultation consulta;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medic medico;

    public Long getId() { return id; }
    public String getMedicamentosPrescritos() { return medicamentosPrescritos; }
    public LocalDate getValidade() { return validade; }
    public String getObservacoes() { return observacoes; }
    public Consultation getConsulta() { return consulta; }
    public Medic getMedico() { return medico; }

    public void setId(Long id) { this.id = id; }
    public void setMedicamentosPrescritos(String medicamentosPrescritos) { this.medicamentosPrescritos = medicamentosPrescritos; }
    public void setValidade(LocalDate validade) { this.validade = validade; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
    public void setConsulta(Consultation consulta) { this.consulta = consulta; }
    public void setMedico(Medic medico) { this.medico = medico; }
}