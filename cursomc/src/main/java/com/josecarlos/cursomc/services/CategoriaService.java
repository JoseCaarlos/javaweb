package com.josecarlos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josecarlos.cursomc.domain.Categoria;
import com.josecarlos.cursomc.repositories.CategoriaRepository;
import com.josecarlos.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired // Essa depedencia instancia automaticamente;
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"O Objeto não encontrado! ID: " + id
						+ ", Tipo" + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	//Igual o salvar verificando somente se o ID é nulo
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
}
