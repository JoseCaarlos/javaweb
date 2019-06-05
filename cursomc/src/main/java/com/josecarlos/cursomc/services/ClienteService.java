package com.josecarlos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josecarlos.cursomc.domain.Cliente;
import com.josecarlos.cursomc.repositories.ClienteRepository;
import com.josecarlos.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired // Essa depedencia instancia automaticamente;
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"O Objeto não encontrado! ID: " + id
						+ ", Tipo" + Cliente.class.getName()));
	}
}
