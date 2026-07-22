package com.yuri.sistema_chamados.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "comentario")

public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chamado", nullable = false)
    private Chamado chamado;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String texto;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @PrePersist
    public void prePersist() {
        this.dataHora = LocalDateTime.now();
    }

}
