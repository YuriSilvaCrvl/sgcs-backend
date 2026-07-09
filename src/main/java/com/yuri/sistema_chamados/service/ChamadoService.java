package com.yuri.sistema_chamados.service;

import com.yuri.sistema_chamados.model.Chamado;
import com.yuri.sistema_chamados.model.enums.Prioridade;
import com.yuri.sistema_chamados.model.enums.Status;
import com.yuri.sistema_chamados.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    public Chamado cadastrar(Chamado chamado) {
        return chamadoRepository.save(chamado);
    }

    public List<Chamado> listar() {
        return chamadoRepository.findAll();
    }

    public Optional<Chamado> buscarPorId(Integer id) {
        return chamadoRepository.findById(id);
    }

    public Chamado editar(Integer id, Chamado chamadoAtualizado) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));
        chamado.setTitulo(chamadoAtualizado.getTitulo());
        chamado.setDescricao(chamadoAtualizado.getDescricao());
        chamado.setStatus(chamadoAtualizado.getStatus());
        chamado.setPrioridade(chamadoAtualizado.getPrioridade());
        return chamadoRepository.save(chamado);
    }

    public List<Chamado> listarPorUsuario(Integer idUsuario) {
        return chamadoRepository.findByUsuarioId(idUsuario);
    }

    public List<Chamado> listarPorSistema(Integer idSistema) {
        return chamadoRepository.findBySistemaId(idSistema);
    }

    public Chamado atualizarStatus(Integer id, String status) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));
        chamado.setStatus(Status.valueOf(status));
        return chamadoRepository.save(chamado);
    }

    public Chamado definirPrioridade(Integer id, String prioridade) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));
        chamado.setPrioridade(Prioridade.valueOf(prioridade));
        return chamadoRepository.save(chamado);
    }
}