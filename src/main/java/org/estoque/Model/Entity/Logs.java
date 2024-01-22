package org.estoque.Model.Entity;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Table(name = "logs")
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioDados usuario;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "horarioLogin", nullable = false)
    private Timestamp horarioLogin;
}
