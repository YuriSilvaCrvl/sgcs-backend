package com.yuri.sistema_chamados.controller;

import com.yuri.sistema_chamados.model.Chamado;
import com.yuri.sistema_chamados.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @GetMapping
    public List<Chamado> listarTodos() {
        return chamadoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chamado> buscarPorId(@PathVariable Integer id) {
        return chamadoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<Chamado> listarPorUsuario(@PathVariable Integer idUsuario) {
        return chamadoService.listarPorUsuario(idUsuario);
    }

    @GetMapping("/sistema/{idSistema}")
    public List<Chamado> listarPorSistema(@PathVariable Integer idSistema) {
        return chamadoService.listarPorSistema(idSistema);
    }

    @PostMapping
    public Chamado abrir(@RequestBody Chamado chamado) {
        return chamadoService.cadastrar(chamado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chamado> editar(@PathVariable Integer id, @RequestBody Chamado chamado) {
        try {
            return ResponseEntity.ok(chamadoService.editar(id, chamado));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Chamado> atualizarStatus(@PathVariable Integer id, @RequestBody String status) {
        try {
            return ResponseEntity.ok(chamadoService.atualizarStatus(id, status));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/prioridade")
    public ResponseEntity<Chamado> definirPrioridade(@PathVariable Integer id, @RequestBody String prioridade) {
        try {
            return ResponseEntity.ok(chamadoService.definirPrioridade(id, prioridade));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/fechar")
    public ResponseEntity<Chamado> fechar(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(chamadoService.atualizarStatus(id, "FECHADO"));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}