package com.franciscolopes.easyeventos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.franciscolopes.easyeventos.domain.Evento;
import com.franciscolopes.easyeventos.services.EventoService;

@RestController
@RequestMapping(value="/eventos")
public class EventoResource {
	
	@Autowired
	 private EventoService service;
	
	@RequestMapping(value="/{codEvento}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer codEvento) {
		
		Evento obj = service.buscar(codEvento);
		return ResponseEntity.ok().body(obj);
		
		
		
	}
}
