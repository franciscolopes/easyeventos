package com.franciscolopes.easyeventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.franciscolopes.easyeventos.domain.Atividade;
import com.franciscolopes.easyeventos.repositories.AtividadeRepository;
import com.franciscolopes.easyeventos.services.exceptions.ObjectNotFoundException;

@Service
public class AtividadeService {
	
	@Autowired
	private AtividadeRepository eventoRepo;//automaticamente instanciada pelo spring por causa da anotação autowired
	public Atividade buscar(Integer codAtividade) {
		Atividade obj = eventoRepo.findOne(codAtividade);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! código: " + codAtividade
					+ ", Tipo: " + Atividade.class.getName());
		}
		
		return obj;
	}
}