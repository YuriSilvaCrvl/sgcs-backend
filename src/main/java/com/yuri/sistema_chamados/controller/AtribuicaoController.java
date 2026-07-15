package com.yuri.sistema_chamados.controller;

import com.yuri.sistema_chamados.model.Atribuicao;
import com.yuri.sistema_chamados.service.AtribuicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atribuicoes")
public class AtribuicaoController {

    @Autowired
    private AtribuicaoService atribuicaoService;

    @GetMapping("/chamado/{idChamado}")
    public List<Atribuicao> listarPorChamado(@PathVariable Integer idChamado) {
        return atribuicaoService.listarPorChamado(idChamado);
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<Atribuicao> listarPorUsuario(@PathVariable Integer idUsuario) {
        return atribuicaoService.listarPorUsuario(idUsuario);
    }

    @PostMapping
    public Atribuicao atribuir(@RequestBody Atribuicao atribuicao) {
        return atribuicaoService.atribuir(atribuicao);
    }
}
