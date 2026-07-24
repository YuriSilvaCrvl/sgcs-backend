package com.yuri.sistema_chamados.dto;

import lombok.Data;

@Data
public class SistemaResponseDTO {
    private Integer id;
    private String nome;
    private String descricao;
    private String versao;
    private Integer idEmpresa;
    private String nomeEmpresa;
}