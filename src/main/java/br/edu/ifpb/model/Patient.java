package br.edu.ifpb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "paciente")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificador_tarefa")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "data_nascimento", nullable = false)
    private String data_nascimento;

    @Column(name = "tipo_sanguineo", nullable = false)
    private String tipo_sanguineo;

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getSexo() { return sexo; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getEndereco() { return endereco; }
    public String getData_nascimento() { return data_nascimento; }
    public String getTipo_sanguineo() { return tipo_sanguineo; }
    
    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public void setData_nascimento(String data_nascimento) { this.data_nascimento = data_nascimento; }
    public void setTipo_sanguineo(String tipo_sanguineo) { this.tipo_sanguineo = tipo_sanguineo; }
}