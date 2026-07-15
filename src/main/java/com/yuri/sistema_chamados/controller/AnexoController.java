package com.yuri.sistema_chamados.controller;

import com.yuri.sistema_chamados.model.Anexo;
import com.yuri.sistema_chamados.service.AnexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anexos")
public class AnexoController {

    @Autowired
    private AnexoService anexoService;

    @GetMapping("/chamado/{idChamado}")
    public List<Anexo> listarPorChamado(@PathVariable Integer idChamado) {
        return anexoService.listarPorChamado(idChamado);
    }

    @PostMapping
    public Anexo adicionar(@RequestBody Anexo anexo) {
        return anexoService.adicionar(anexo);
    }
}
