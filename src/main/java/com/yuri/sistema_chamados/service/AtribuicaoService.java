package com.yuri.sistema_chamados.service;

import com.yuri.sistema_chamados.dto.AtribuicaoResponseDTO;
import com.yuri.sistema_chamados.model.Atribuicao;
import com.yuri.sistema_chamados.repository.AtribuicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtribuicaoService {

    @Autowired
    private AtribuicaoRepository atribuicaoRepository;

    private AtribuicaoResponseDTO toDTO(Atribuicao atribuicao) {
        AtribuicaoResponseDTO dto = new AtribuicaoResponseDTO();
        dto.setId(atribuicao.getId());
        dto.setIdChamado(atribuicao.getChamado().getId());
        dto.setIdUsuario(atribuicao.getUsuario().getId());
        dto.setNomeUsuario(atribuicao.getUsuario().getNome());
        dto.setDataAtribuicao(atribuicao.getDataAtribuicao());
        dto.setAtivo(atribuicao.isAtivo());
        return dto;
    }

    public AtribuicaoResponseDTO atribuir(Atribuicao atribuicao) {
        return toDTO(atribuicaoRepository.save(atribuicao));
    }

    public List<AtribuicaoResponseDTO> listarPorChamado(Integer idChamado) {
        return atribuicaoRepository.findByChamadoId(idChamado)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<AtribuicaoResponseDTO> listarPorUsuario(Integer idUsuario) {
        return atribuicaoRepository.findByUsuarioId(idUsuario)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}