package com.yuri.sistema_chamados.service;
import com.yuri.sistema_chamados.model.Sistema;
import com.yuri.sistema_chamados.repository.SistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SistemaService {

    @Autowired
    private SistemaRepository sistemaRepository;

    public Sistema cadastrar(Sistema sistema){
        return sistemaRepository.save(sistema);
    }

    public List<Sistema> listar() {
        return sistemaRepository.findAll();
    }

    public List<Sistema> listarPorEmpresa(Integer idEmpresa) {
        return sistemaRepository.findByEmpresaId(idEmpresa);
    }

    public Optional<Sistema> buscarPorId(Integer id) {
        return sistemaRepository.findById(id);
    }

    public Sistema editar(Integer id, Sistema sistemaAtualizado) {
        Sistema sistema = sistemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sistema não encontrado"));
        sistema.setNome(sistemaAtualizado.getNome());
        sistema.setDescricao(sistemaAtualizado.getDescricao());
        sistema.setVersao(sistemaAtualizado.getVersao());
        return sistemaRepository.save(sistema);
    }

    public void deletar(Integer id) {
        sistemaRepository.deleteById(id);
    }
}
