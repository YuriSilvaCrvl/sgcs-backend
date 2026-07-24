package com.yuri.sistema_chamados.service;

import com.yuri.sistema_chamados.dto.ComentarioResponseDTO;
import com.yuri.sistema_chamados.model.Comentario;
import com.yuri.sistema_chamados.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    private ComentarioResponseDTO toDTO(Comentario comentario) {
        ComentarioResponseDTO dto = new ComentarioResponseDTO();
        dto.setId(comentario.getId());
        dto.setIdChamado(comentario.getChamado().getId());
        dto.setIdUsuario(comentario.getUsuario().getId());
        dto.setNomeUsuario(comentario.getUsuario().getNome());
        dto.setTexto(comentario.getTexto());
        dto.setDataHora(comentario.getDataHora());
        return dto;
    }

    public ComentarioResponseDTO adicionar(Comentario comentario) {
        return toDTO(comentarioRepository.save(comentario));
    }

    public Optional<ComentarioResponseDTO> buscarPorId(Integer id) {
        return comentarioRepository.findById(id).map(this::toDTO);
    }

    public List<ComentarioResponseDTO> listarPorChamado(Integer idChamado) {
        return comentarioRepository.findByChamadoId(idChamado)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}