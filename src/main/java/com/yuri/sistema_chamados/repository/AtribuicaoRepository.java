package com.yuri.sistema_chamados.repository;

import com.yuri.sistema_chamados.model.Atribuicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AtribuicaoRepository extends JpaRepository<Atribuicao, Integer>{
	List<Atribuicao> findByChamadoId (Integer idChamado);
	List<Atribuicao> findByUsuarioId (Integer idUsuario);
}
