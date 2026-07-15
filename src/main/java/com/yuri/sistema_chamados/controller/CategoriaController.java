package com.yuri.sistema_chamados.controller;

import com.yuri.sistema_chamados.model.Categoria;
import com.yuri.sistema_chamados.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Integer id) {
        return categoriaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria cadastrar(@RequestBody Categoria categoria) {
        return categoriaService.cadastrar(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> editar(@PathVariable Integer id, @RequestBody Categoria categoria) {
        try {
            return ResponseEntity.ok(categoriaService.editar(id, categoria));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (!categoriaService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}