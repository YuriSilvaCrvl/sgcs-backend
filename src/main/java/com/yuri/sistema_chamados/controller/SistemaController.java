package com.yuri.sistema_chamados.controller;

import com.yuri.sistema_chamados.model.Sistema;
import com.yuri.sistema_chamados.service.SistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sistemas")
public class SistemaController {

    @Autowired
    private SistemaService sistemaService;

    @GetMapping
    public List<Sistema> listar() {
        return sistemaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sistema> buscarPorId(@PathVariable Integer id) {
        return sistemaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/empresa/{idEmpresa}")
    public List<Sistema> listarPorEmpresa(@PathVariable Integer idEmpresa) {
        return sistemaService.listarPorEmpresa(idEmpresa);
    }

    @PostMapping
    public Sistema cadastrar(@RequestBody Sistema sistema) {
        return sistemaService.cadastrar(sistema);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sistema> editar(@PathVariable Integer id, @RequestBody Sistema sistema) {
        try {
            return ResponseEntity.ok(sistemaService.editar(id, sistema));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (!sistemaService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        sistemaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}