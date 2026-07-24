package com.yuri.sistema_chamados.dto;

import com.yuri.sistema_chamados.model.enums.Prioridade;
import com.yuri.sistema_chamados.model.enums.Status;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ChamadoResponseDTO {
    private Integer id;
    private Integer idUsuario;
    private String nomeUsuario;
    private Integer idSistema;
    private String nomeSistema;
    private Integer idCategoria;
    private String nomeCategoria;
    private String titulo;
    private String descricao;
    private Status status;
    private Prioridade prioridade;
    private LocalDateTime dataAbertura;
}