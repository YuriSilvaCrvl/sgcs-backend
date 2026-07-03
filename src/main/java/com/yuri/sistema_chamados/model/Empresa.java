package com.yuri.sistema_chamados.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "empresa")

public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false, unique = true, length = 14)
	private String cnpj;

	@Column(length = 20)
	private String telefone;

	@Column(nullable = false, length = 100)
	private String email;

}
