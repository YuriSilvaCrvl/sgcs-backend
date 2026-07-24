package com.yuri.sistema_chamados.service;

import com.yuri.sistema_chamados.dto.SistemaResponseDTO;
import com.yuri.sistema_chamados.model.Sistema;
import com.yuri.sistema_chamados.repository.SistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SistemaService {

    @Autowired
    private SistemaRepository sistemaRepository;

    private SistemaResponseDTO toDTO(Sistema sistema) {
        SistemaResponseDTO dto = new SistemaResponseDTO();
        dto.setId(sistema.getId());
        dto.setNome(sistema.getNome());
        dto.setDescricao(sistema.getDescricao());
        dto.setVersao(sistema.getVersao());
        dto.setIdEmpresa(sistema.getEmpresa().getId());
        dto.setNomeEmpresa(sistema.getEmpresa().getNome());
        return dto;
    }

    public SistemaResponseDTO cadastrar(Sistema sistema) {
        return toDTO(sistemaRepository.save(sistema));
    }

    public List<SistemaResponseDTO> listar() {
        return sistemaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<SistemaResponseDTO> listarPorEmpresa(Integer idEmpresa) {
        return sistemaRepository.findByEmpresaId(idEmpresa)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<SistemaResponseDTO> buscarPorId(Integer id) {
        return sistemaRepository.findById(id).map(this::toDTO);
    }

    public SistemaResponseDTO editar(Integer id, Sistema sistemaAtualizado) {
        Sistema sistema = sistemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sistema não encontrado"));
        sistema.setNome(sistemaAtualizado.getNome());
        sistema.setDescricao(sistemaAtualizado.getDescricao());
        sistema.setVersao(sistemaAtualizado.getVersao());
        return toDTO(sistemaRepository.save(sistema));
    }

    public void deletar(Integer id) {
        sistemaRepository.deleteById(id);
    }
}