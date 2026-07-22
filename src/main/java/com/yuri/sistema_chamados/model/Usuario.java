package com.yuri.sistema_chamados.model;

import com.yuri.sistema_chamados.model.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")

public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa", nullable = false)
	private Empresa empresa;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false, unique = true, length = 100)
	private String email;

	@Column(nullable = false, length = 255)
	private String senha;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private TipoUsuario tipoUsuario;

}
