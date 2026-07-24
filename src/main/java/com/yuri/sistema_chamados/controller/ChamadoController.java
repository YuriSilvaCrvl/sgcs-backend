package com.yuri.sistema_chamados.controller;

import com.yuri.sistema_chamados.dto.ChamadoResponseDTO;
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
    public List<ChamadoResponseDTO> listarTodos() {
        return chamadoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChamadoResponseDTO> buscarPorId(@PathVariable Integer id) {
        return chamadoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<ChamadoResponseDTO> listarPorUsuario(@PathVariable Integer idUsuario) {
        return chamadoService.listarPorUsuario(idUsuario);
    }

    @GetMapping("/sistema/{idSistema}")
    public List<ChamadoResponseDTO> listarPorSistema(@PathVariable Integer idSistema) {
        return chamadoService.listarPorSistema(idSistema);
    }

    @PostMapping
    public ChamadoResponseDTO abrir(@RequestBody Chamado chamado) {
        return chamadoService.cadastrar(chamado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChamadoResponseDTO> editar(@PathVariable Integer id, @RequestBody Chamado chamado) {
        try {
            return ResponseEntity.ok(chamadoService.editar(id, chamado));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ChamadoResponseDTO> atualizarStatus(@PathVariable Integer id, @RequestBody String status) {
        try {
            return ResponseEntity.ok(chamadoService.atualizarStatus(id, status));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/prioridade")
    public ResponseEntity<ChamadoResponseDTO> definirPrioridade(@PathVariable Integer id, @RequestBody String prioridade) {
        try {
            return ResponseEntity.ok(chamadoService.definirPrioridade(id, prioridade));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/fechar")
    public ResponseEntity<ChamadoResponseDTO> fechar(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(chamadoService.atualizarStatus(id, "FECHADO"));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}