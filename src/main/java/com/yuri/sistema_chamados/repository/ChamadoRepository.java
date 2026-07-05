package com.yuri.sistema_chamados.repository;

import com.yuri.sistema_chamados.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
	List<Chamado> findByUsuarioId(Integer idUsuario);
	List<Chamado> findBySistemaId(Integer idSistema);
}
