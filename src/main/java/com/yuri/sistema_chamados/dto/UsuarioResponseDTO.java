package com.yuri.sistema_chamados.dto;

import com.yuri.sistema_chamados.model.enums.TipoUsuario;
import lombok.Data;

@Data
public class UsuarioResponseDTO {
    private Integer id;
    private String nome;
    private String email;
    private TipoUsuario tipoUsuario;
    private Integer idEmpresa;
    private String nomeEmpresa;
}