package com.yuri.sistema_chamados.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "anexo")

public class Anexo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_chamado", nullable = false)
	private Chamado chamado;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	
	@Column(nullable = false, length = 255)
	private String nomeArquivo;
	
	@Column(nullable = false, length = 500)
	private String caminho;
	
	@Column(length = 50)
	private String tipo;
	
	@Column(nullable = false)
	private LocalDateTime dataUpload;
	
}
