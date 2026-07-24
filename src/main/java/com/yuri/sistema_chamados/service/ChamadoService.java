package com.yuri.sistema_chamados.service;

import com.yuri.sistema_chamados.dto.ChamadoResponseDTO;
import com.yuri.sistema_chamados.model.Chamado;
import com.yuri.sistema_chamados.model.enums.Prioridade;
import com.yuri.sistema_chamados.model.enums.Status;
import com.yuri.sistema_chamados.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    private ChamadoResponseDTO toDTO(Chamado chamado) {
        ChamadoResponseDTO dto = new ChamadoResponseDTO();
        dto.setId(chamado.getId());
        dto.setIdUsuario(chamado.getUsuario().getId());
        dto.setNomeUsuario(chamado.getUsuario().getNome());
        dto.setIdSistema(chamado.getSistema().getId());
        dto.setNomeSistema(chamado.getSistema().getNome());
        dto.setIdCategoria(chamado.getCategoria().getId());
        dto.setNomeCategoria(chamado.getCategoria().getNome());
        dto.setTitulo(chamado.getTitulo());
        dto.setDescricao(chamado.getDescricao());
        dto.setStatus(chamado.getStatus());
        dto.setPrioridade(chamado.getPrioridade());
        dto.setDataAbertura(chamado.getDataAbertura());
        return dto;
    }

    public ChamadoResponseDTO cadastrar(Chamado chamado) {
        return toDTO(chamadoRepository.save(chamado));
    }

    public List<ChamadoResponseDTO> listar() {
        return chamadoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ChamadoResponseDTO> buscarPorId(Integer id) {
        return chamadoRepository.findById(id).map(this::toDTO);
    }

    public ChamadoResponseDTO editar(Integer id, Chamado chamadoAtualizado) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));
        chamado.setTitulo(chamadoAtualizado.getTitulo());
        chamado.setDescricao(chamadoAtualizado.getDescricao());
        chamado.setStatus(chamadoAtualizado.getStatus());
        chamado.setPrioridade(chamadoAtualizado.getPrioridade());
        return toDTO(chamadoRepository.save(chamado));
    }

    public List<ChamadoResponseDTO> listarPorUsuario(Integer idUsuario) {
        return chamadoRepository.findByUsuarioId(idUsuario)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<ChamadoResponseDTO> listarPorSistema(Integer idSistema) {
        return chamadoRepository.findBySistemaId(idSistema)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ChamadoResponseDTO atualizarStatus(Integer id, String status) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));
        chamado.setStatus(Status.valueOf(status));
        return toDTO(chamadoRepository.save(chamado));
    }

    public ChamadoResponseDTO definirPrioridade(Integer id, String prioridade) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));
        chamado.setPrioridade(Prioridade.valueOf(prioridade));
        return toDTO(chamadoRepository.save(chamado));
    }
}