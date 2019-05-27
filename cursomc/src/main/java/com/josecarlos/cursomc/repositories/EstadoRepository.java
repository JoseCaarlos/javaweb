package com.josecarlos.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josecarlos.cursomc.domain.Estado;



//Essa Interface vai ser responsavel por realizar o acesso ao banco de dados
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
