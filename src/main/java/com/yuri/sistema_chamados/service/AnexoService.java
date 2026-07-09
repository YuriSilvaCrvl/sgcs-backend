package com.yuri.sistema_chamados.service;

import com.yuri.sistema_chamados.model.Anexo;
import com.yuri.sistema_chamados.repository.AnexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnexoService {

    @Autowired
    private AnexoRepository anexoRepository;

    public Anexo adicionar(Anexo anexo){
        return anexoRepository.save(anexo);
    }

    public List<Anexo> listarPorChamado(Integer idChamado) {
        return anexoRepository.findByChamadoId(idChamado);
    }
}
