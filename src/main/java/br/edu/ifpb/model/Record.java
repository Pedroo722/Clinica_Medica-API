package br.edu.ifpb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ficha")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificador_ficha")
    private Long id;

    @Column(name = "status_paciente", nullable = false)
    private String statusPaciente;

    @Column(name = "historico_medico")
    private String historicoMedico;

    @Column(name = "diagnostico")
    private String diagnostico;

    @Column(name = "tratamento")
    private String tratamento;

    @Column(name = "observacoes")
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Patient paciente;

    public Long getId() { return id; }
    public String getStatusPaciente() { return statusPaciente; }
    public String getHistoricoMedico() { return historicoMedico; }
    public String getDiagnostico() { return diagnostico; }
    public String getTratamento() { return tratamento; }
    public String getObservacoes() { return observacoes; }
    public Patient getPaciente() { return paciente; }

    public void setId(Long id) { this.id = id; }
    public void setStatusPaciente(String statusPaciente) { this.statusPaciente = statusPaciente; }
    public void setHistoricoMedico(String historicoMedico) { this.historicoMedico = historicoMedico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }
    public void setTratamento(String tratamento) { this.tratamento = tratamento; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
    public void setPaciente(Patient paciente) { this.paciente = paciente; }
}
