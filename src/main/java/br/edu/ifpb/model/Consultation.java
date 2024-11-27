package br.edu.ifpb.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consulta")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificador_consulta")
    private Long id;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "horario", nullable = false)
    private LocalTime horario;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Patient paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medic medico;

    public Long getId() { return id; }
    public LocalDate getData() { return data; }
    public LocalTime getHorario() { return horario; }
    public String getStatus() { return status; }
    public String getTipo() { return tipo; }
    public Patient getPaciente() { return paciente; }
    public Medic getMedico() { return medico; }

    public void setId(Long id) { this.id = id; }
    public void setData(LocalDate data) { this.data = data; }
    public void setHorario(LocalTime horario) { this.horario = horario; }
    public void setStatus(String status) { this.status = status; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setPaciente(Patient paciente) { this.paciente = paciente; }
    public void setMedico(Medic medico) { this.medico = medico; }
}
