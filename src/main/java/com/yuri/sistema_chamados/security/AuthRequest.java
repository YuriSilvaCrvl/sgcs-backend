package com.yuri.sistema_chamados.security;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String senha;
}