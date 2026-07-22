package com.yuri.sistema_chamados.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "atribuicao")
public class Atribuicao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_chamado", nullable = false)
	private Chamado chamado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	@Column(nullable = false)
	private LocalDateTime dataAtribuicao;

	@Column(nullable = false)
	private boolean ativo;

	@PrePersist
	public void prePersist() {
		this.dataAtribuicao = LocalDateTime.now();
		if (!this.ativo) {
			this.ativo = true;
		}
	}
}