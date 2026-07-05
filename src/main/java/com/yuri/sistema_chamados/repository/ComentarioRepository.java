package com.yuri.sistema_chamados.repository;

import com.yuri.sistema_chamados.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
	List<Comentario> findByChamadoId(Integer idChamado);
}
