package com.franciscolopes.easyeventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import com.franciscolopes.easyeventos.domain.Evento;
import com.franciscolopes.easyeventos.repositories.EventoRepository;
import com.franciscolopes.easyeventos.services.exceptions.DataIntegrityException;
import com.franciscolopes.easyeventos.services.exceptions.ObjectNotFoundException;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoRepo;// automaticamente instanciada pelo spring por causa da anotação autowired

	public Evento find(Integer codEvento) {
		Evento obj = eventoRepo.findOne(codEvento);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! código: " + codEvento + ", Tipo: " + Evento.class.getName());
		}

		return obj;
	}

	public Evento insert(Evento obj) {
		obj.setCodEvento(null);
		return eventoRepo.save(obj);
	}

	public Evento update(Evento obj) {
		find(obj.getCodEvento());
		return eventoRepo.save(obj);
	}

	public void delete(Integer codEvento) {
		find(codEvento);
		try {
			eventoRepo.delete(codEvento);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um evento que possui atividades");
		}
	}

	public List<Evento> findAll() {
		return eventoRepo.findAll();
	}

	public Page<Evento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return eventoRepo.findAll(pageRequest);
	}

}
