package org.estoque.Model.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.estoque.Model.Enum.Status;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarioDados")
@Getter
@Setter
public class UsuarioDados {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "status", columnDefinition = "varchar(5) default 'USER'")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "dataRegistro", nullable = false)
    private LocalDateTime dataRegistro;

    @ManyToOne
    @JoinColumn(name = "logradouro_id")
    private Logradouro logradouro;

    public UsuarioDados() {
    }

    public UsuarioDados(Long id, String username, String senha, String nome, String email, String telefone, Status status, LocalDateTime dataRegistro, Logradouro logradouro) {
        this.id = id;
        this.username = username;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.status = status;
        this.dataRegistro = dataRegistro;
        this.logradouro = logradouro;
    }

    @Override
    public String toString() {
        return "UsuarioDados{" +
                "status=" + status +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }
}
