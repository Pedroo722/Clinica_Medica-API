package br.edu.ifpb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medico")
public class Medic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "especialidade", nullable = false)
    private String especialidade;

    @Column(name = "status_disponibilidade", nullable = false)
    private String statusDisponibilidade;

    @Column(name = "crm", nullable = false)
    private String crm;

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getEspecialidade() { return especialidade; }
    public String getStatusDisponibilidade() { return statusDisponibilidade; }
    public String getCrm() { return crm; }

    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public void setStatusDisponibilidade(String statusDisponibilidade) { this.statusDisponibilidade = statusDisponibilidade; }
    public void setCrm(String crm) { this.crm = crm; }
}
