package com.franciscolopes.easyeventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.franciscolopes.easyeventos.domain.Evento;
import com.franciscolopes.easyeventos.repositories.EventoRepository;
import com.franciscolopes.easyeventos.services.exceptions.ObjectNotFoundException;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRepo;//automaticamente instanciada pelo spring por causa da anotação autowired
	public Evento buscar(Integer codEvento) {
		Evento obj = eventoRepo.findOne(codEvento);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! código: " + codEvento
					+ ", Tipo: " + Evento.class.getName());
		}
		
		return obj;
	}
}
