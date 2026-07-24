package com.yuri.sistema_chamados.controller;

import com.yuri.sistema_chamados.dto.ComentarioResponseDTO;
import com.yuri.sistema_chamados.model.Comentario;
import com.yuri.sistema_chamados.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping("/chamado/{idChamado}")
    public List<ComentarioResponseDTO> listarPorChamado(@PathVariable Integer idChamado) {
        return comentarioService.listarPorChamado(idChamado);
    }

    @PostMapping
    public ComentarioResponseDTO adicionar(@RequestBody Comentario comentario) {
        return comentarioService.adicionar(comentario);
    }
}