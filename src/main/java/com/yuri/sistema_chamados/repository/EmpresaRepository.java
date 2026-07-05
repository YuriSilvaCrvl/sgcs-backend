package com.yuri.sistema_chamados.repository;

import com.yuri.sistema_chamados.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{
}