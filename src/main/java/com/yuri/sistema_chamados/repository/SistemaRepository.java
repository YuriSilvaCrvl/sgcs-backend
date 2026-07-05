package com.yuri.sistema_chamados.repository;

import com.yuri.sistema_chamados.model.Sistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SistemaRepository extends JpaRepository<Sistema, Integer>{
}
