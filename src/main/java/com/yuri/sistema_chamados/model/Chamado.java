package com.yuri.sistema_chamados.model;

import com.yuri.sistema_chamados.model.enums.Prioridade;
import com.yuri.sistema_chamados.model.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "chamado")

public class Chamado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_sistema", nullable = false)
	private Sistema sistema;

	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = false)
	private Categoria categoria;

	@Column(nullable = false, length = 150)
	private String titulo;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private Status status;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Prioridade prioridade;

	@Column(nullable = false)
	private LocalDateTime dataAbertura;

}
