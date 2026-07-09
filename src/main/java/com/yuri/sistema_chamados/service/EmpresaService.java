package com.yuri.sistema_chamados.service;

import com.yuri.sistema_chamados.model.Empresa;
import com.yuri.sistema_chamados.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa cadastrar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public List<Empresa> listar() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> buscarPorId(Integer id) {
        return empresaRepository.findById(id);
    }

    public Empresa editar(Integer id, Empresa empresaAtualizada) {
        Empresa empresa = empresaRepository.findById(id).orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
        empresa.setNome(empresaAtualizada.getNome());
        empresa.setCnpj(empresaAtualizada.getCnpj());
        empresa.setTelefone(empresaAtualizada.getTelefone());
        empresa.setEmail(empresaAtualizada.getEmail());
        return empresaRepository.save(empresa);
    }

    public void deletar(Integer id) {
        empresaRepository.deleteById(id);
    }

}
