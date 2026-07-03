package com.yuri.sistema_chamados.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sistema")

public class Sistema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable = false)
	private Empresa empresa;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	@Column(length = 20)
	private String versao;
}
