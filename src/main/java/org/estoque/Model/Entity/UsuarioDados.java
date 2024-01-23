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
@Data
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
}
