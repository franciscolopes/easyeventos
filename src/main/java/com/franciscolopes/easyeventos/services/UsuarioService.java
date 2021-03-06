package com.franciscolopes.easyeventos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.franciscolopes.easyeventos.domain.Atividade;
import com.franciscolopes.easyeventos.domain.Bloco;
import com.franciscolopes.easyeventos.domain.Usuario;
import com.franciscolopes.easyeventos.dto.UsuarioDTO;
import com.franciscolopes.easyeventos.repositories.BlocoRepository;
import com.franciscolopes.easyeventos.repositories.UsuarioRepository;
import com.franciscolopes.easyeventos.services.exceptions.DataIntegrityException;
import com.franciscolopes.easyeventos.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;// automaticamente instanciada pelo spring por causa da anotação autowired
	private BlocoRepository blocoRepo;
	
	/*-----------VERFICA SE USUARIO DO QRCODE ESTA INSCRITO NA ATIVIDADE DO BLOCO-----------*/
	public boolean verificaUsuarioCadastrado(Integer codUsuario, Integer codBloco) {
		Usuario objUsuario = usuarioRepo.findOne(codUsuario);
		Bloco objBloco = blocoRepo.findOne(codBloco);
		int codAtividade = objBloco.getAtividade().getCodAtividade();
		List<Atividade> atividades = new ArrayList<Atividade>();
		atividades = objUsuario.getAtividades();
		boolean resultadoVerificacao = false;
		
		for(Atividade x : atividades){
			if(x.getCodAtividade() == codAtividade){
				resultadoVerificacao = true;
			}
		}
		return resultadoVerificacao;
	}
	/*-----------VERFICA SE USUARIO DO QRCODE ESTA INSCRITO NA ATIVIDADE DO BLOCO-----------*/
	
	public Usuario find(Integer codUsuario) {
		Usuario obj = usuarioRepo.findOne(codUsuario);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! código: " + codUsuario + ", Tipo: " + Usuario.class.getName());
		}

		return obj;
	}

	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getCodUsuario());
		updateData(newObj, obj);
		return usuarioRepo.save(newObj);
	}

	public void delete(Integer codUsuario) {
		find(codUsuario);
		try {
			usuarioRepo.delete(codUsuario);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
	}

	public List<Usuario> findAll() {
		return usuarioRepo.findAll();
	}

	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return usuarioRepo.findAll(pageRequest);
	}

	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getCodUsuario(), objDto.getNome(), null, objDto.getEmail(), null, null);
	}

	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

}