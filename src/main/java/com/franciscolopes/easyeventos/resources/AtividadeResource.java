package com.franciscolopes.easyeventos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.franciscolopes.easyeventos.domain.Atividade;
import com.franciscolopes.easyeventos.services.AtividadeService;

@RestController
@RequestMapping(value="/atividades")
public class AtividadeResource {
	
	@Autowired
	 private AtividadeService service;
	
	@RequestMapping(value="/{codAtividade}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer codAtividade) {
		
		Atividade obj = service.buscar(codAtividade);
		return ResponseEntity.ok().body(obj);	
	}
}