package com.yuri.sistema_chamados.controller;

import com.yuri.sistema_chamados.model.Empresa;
import com.yuri.sistema_chamados.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa> listar() {
        return empresaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable Integer id) {
        return empresaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Empresa cadastrar(@RequestBody Empresa empresa) {
        return empresaService.cadastrar(empresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> editar(@PathVariable Integer id, @RequestBody Empresa empresa) {
        try {
            return ResponseEntity.ok(empresaService.editar(id, empresa));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (!empresaService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        empresaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}