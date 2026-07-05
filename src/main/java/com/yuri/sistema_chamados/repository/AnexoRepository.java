package com.yuri.sistema_chamados.repository;

import com.yuri.sistema_chamados.model.Anexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnexoRepository extends JpaRepository<Anexo, Integer>{
	List<Anexo> findByChamadoId (Integer idChamado);
}
