package com.yuri.sistema_chamados.service;

import com.yuri.sistema_chamados.dto.AnexoResponseDTO;
import com.yuri.sistema_chamados.model.Anexo;
import com.yuri.sistema_chamados.repository.AnexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnexoService {

    @Autowired
    private AnexoRepository anexoRepository;

    private AnexoResponseDTO toDTO(Anexo anexo) {
        AnexoResponseDTO dto = new AnexoResponseDTO();
        dto.setId(anexo.getId());
        dto.setIdChamado(anexo.getChamado().getId());
        dto.setIdUsuario(anexo.getUsuario().getId());
        dto.setNomeUsuario(anexo.getUsuario().getNome());
        dto.setNomeArquivo(anexo.getNomeArquivo());
        dto.setCaminho(anexo.getCaminho());
        dto.setTipo(anexo.getTipo());
        dto.setDataUpload(anexo.getDataUpload());
        return dto;
    }

    public AnexoResponseDTO adicionar(Anexo anexo) {
        return toDTO(anexoRepository.save(anexo));
    }

    public List<AnexoResponseDTO> listarPorChamado(Integer idChamado) {
        return anexoRepository.findByChamadoId(idChamado)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}