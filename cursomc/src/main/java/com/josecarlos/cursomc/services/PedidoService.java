package com.josecarlos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josecarlos.cursomc.domain.Pedido;
import com.josecarlos.cursomc.repositories.PedidoRepository;
import com.josecarlos.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired // Essa depedencia instancia automaticamente;
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"O Objeto não encontrado! ID: " + id
						+ ", Tipo" + Pedido.class.getName()));
	}
}
