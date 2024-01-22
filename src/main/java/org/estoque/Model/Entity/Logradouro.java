package org.estoque.Model.Entity;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "logradouro")
@Getter
@Setter
public class Logradouro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "rua", nullable = false)
    private String rua;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "cep", nullable = false)
    private String cep;

    public Logradouro(Long id, String endereco, String rua, String estado, String cidade, String cep) {
        this.id = id;
        this.endereco = endereco;
        this.rua = rua;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
    }

    public Logradouro(){

    }
}
