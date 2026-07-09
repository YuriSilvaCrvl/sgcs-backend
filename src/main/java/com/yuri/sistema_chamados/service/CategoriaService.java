package com.yuri.sistema_chamados.service;

import com.yuri.sistema_chamados.model.Categoria;
import com.yuri.sistema_chamados.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria cadastrar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarPorId(Integer id) {
        return categoriaRepository.findById(id);
    }

    public Categoria editar(Integer id, Categoria categoriaAtualizado) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        categoria.setNome(categoriaAtualizado.getNome());
        categoria.setDescricao(categoriaAtualizado.getDescricao());
        return categoriaRepository.save(categoria);
    }

    public void deletar(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
