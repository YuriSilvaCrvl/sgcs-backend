package com.yuri.sistema_chamados.service;

import com.yuri.sistema_chamados.model.Atribuicao;
import com.yuri.sistema_chamados.repository.AtribuicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtribuicaoService {

    @Autowired
    private AtribuicaoRepository atribuicaoRepository;

    public Atribuicao atribuir(Atribuicao atribuicao){
        return atribuicaoRepository.save(atribuicao);
    }

    public List<Atribuicao> listarPorChamado(Integer idChamado) {
        return atribuicaoRepository.findByChamadoId(idChamado);
    }

    public List<Atribuicao> listarPorUsuario(Integer idUsuario) {
        return atribuicaoRepository.findByUsuarioId(idUsuario);
    }

}
