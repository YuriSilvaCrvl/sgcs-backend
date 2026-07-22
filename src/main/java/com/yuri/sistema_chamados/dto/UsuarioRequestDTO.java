package com.yuri.sistema_chamados.dto;

import com.yuri.sistema_chamados.model.enums.TipoUsuario;
import lombok.Data;

@Data
public class UsuarioRequestDTO {
    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario;
    private Integer idEmpresa;
}