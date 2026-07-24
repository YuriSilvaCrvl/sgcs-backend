package com.yuri.sistema_chamados.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AnexoResponseDTO {
    private Integer id;
    private Integer idChamado;
    private Integer idUsuario;
    private String nomeUsuario;
    private String nomeArquivo;
    private String caminho;
    private String tipo;
    private LocalDateTime dataUpload;
}