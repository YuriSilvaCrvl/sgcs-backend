package com.yuri.sistema_chamados.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AtribuicaoResponseDTO {
    private Integer id;
    private Integer idChamado;
    private Integer idUsuario;
    private String nomeUsuario;
    private LocalDateTime dataAtribuicao;
    private boolean ativo;
}