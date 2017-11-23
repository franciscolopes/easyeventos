package com.franciscolopes.easyeventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.franciscolopes.easyeventos.domain.Bloco;
import com.franciscolopes.easyeventos.repositories.BlocoRepository;
import com.franciscolopes.easyeventos.services.exceptions.ObjectNotFoundException;

@Service
public class BlocoService {
	
	@Autowired
	private BlocoRepository eventoRepo;//automaticamente instanciada pelo spring por causa da anotação autowired
	public Bloco buscar(Integer codBloco) {
		Bloco obj = eventoRepo.findOne(codBloco);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! código: " + codBloco
					+ ", Tipo: " + Bloco.class.getName());
		}
		
		return obj;
	}
	
	/*-----------VERFICA SE EVENTO DO QRCODE É O MESMO EVENTO DO BLOCO-----------*/
	public Boolean verificaEvento(int codEventoOriginal, int codEventoQrcode) {
		
		if(codEventoOriginal == codEventoQrcode) {
			return true;
		}
		else {
			return false;
		}
	}
	/*-----------VERFICA SE EVENTO DO QRCODE É O MESMO EVENTO DO BLOCO-----------*/
	
	
	
}