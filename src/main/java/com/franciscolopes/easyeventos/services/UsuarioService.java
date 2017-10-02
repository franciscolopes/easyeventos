package com.franciscolopes.easyeventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franciscolopes.easyeventos.domain.Usuario;
import com.franciscolopes.easyeventos.repositories.UsuarioRepository;
import com.franciscolopes.easyeventos.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository eventoRepo;//automaticamente instanciada pelo spring por causa da anotação autowired
	public Usuario buscar(Integer codUsuario) {
		Usuario obj = eventoRepo.findOne(codUsuario);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! código: " + codUsuario
					+ ", Tipo: " + Usuario.class.getName());
		}
		
		return obj;
	}
}
