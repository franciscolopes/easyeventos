package com.franciscolopes.easyeventos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.franciscolopes.easyeventos.domain.Bloco;
import com.franciscolopes.easyeventos.services.BlocoService;

@RestController
@RequestMapping(value="/blocos")
public class BlocoResource {
	
	@Autowired
	 private BlocoService service;
	
	@RequestMapping(value="/{codBloco}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer codBloco) {
		
		Bloco obj = service.find(codBloco);
		return ResponseEntity.ok().body(obj);	
	}
}