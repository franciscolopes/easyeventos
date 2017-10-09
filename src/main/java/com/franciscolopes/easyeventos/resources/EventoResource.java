package com.franciscolopes.easyeventos.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.franciscolopes.easyeventos.domain.Evento;
import com.franciscolopes.easyeventos.services.EventoService;

@RestController
@RequestMapping(value = "/eventos")
public class EventoResource {

	@Autowired
	private EventoService service;

	@RequestMapping(value = "/{codEvento}", method = RequestMethod.GET)
	public ResponseEntity<Evento> find(@PathVariable Integer codEvento) {

		Evento obj = service.find(codEvento);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Evento obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codEvento}")
				.buildAndExpand(obj.getCodEvento()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{codEvento}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Evento obj, @PathVariable Integer codEvento) {
		obj.setCodEvento(codEvento);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{codEvento}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer codEvento) {
		service.delete(codEvento);
		return ResponseEntity.noContent().build();
	}

}
