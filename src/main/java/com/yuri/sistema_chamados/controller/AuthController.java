package com.yuri.sistema_chamados.controller;

import com.yuri.sistema_chamados.model.Usuario;
import com.yuri.sistema_chamados.security.AuthRequest;
import com.yuri.sistema_chamados.security.JwtUtil;
import com.yuri.sistema_chamados.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        Optional<Usuario> usuario = usuarioService.buscarPorEmail(authRequest.getEmail());

        if (usuario.isEmpty()) {
            return ResponseEntity.status(401).body("Email não encontrado");
        }

        if (!passwordEncoder.matches(authRequest.getSenha(), usuario.get().getSenha())) {
            return ResponseEntity.status(401).body("Senha incorreta");
        }

        String token = jwtUtil.gerarToken(
                usuario.get().getEmail(),
                usuario.get().getTipoUsuario().name()
        );
        return ResponseEntity.ok(token);
    }
}