package com.yuri.sistema_chamados.service;

import com.yuri.sistema_chamados.model.Comentario;
import com.yuri.sistema_chamados.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public Comentario adicionar(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Optional<Comentario> buscarPorId(Integer id) {
        return comentarioRepository.findById(id);
    }

    public List<Comentario> listarPorChamado(Integer idChamado) {
        return comentarioRepository.findByChamadoId(idChamado);
    }
}
