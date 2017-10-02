package com.franciscolopes.easyeventos.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Inscricao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private InscricaoPK id = new InscricaoPK(); 
	
	private Date dataInscricao;
	private Boolean inscricaoCancelada;
	
	public Inscricao() {
		
	}

	public Inscricao(Usuario usuario, Atividade atividade, Date dataInscricao, Boolean inscricaoCancelada) {
		super();
		id.setUsuario(usuario);
		id.setAtividade(atividade);
		this.dataInscricao = dataInscricao;
		this.inscricaoCancelada = inscricaoCancelada;
	}

	public Usuario getUsuario() {
		return id.getUsuario();
	}
	
	public Atividade getAtividade() {
		return id.getAtividade();
	}
	
	public InscricaoPK getId() {
		return id;
	}

	public void setId(InscricaoPK id) {
		this.id = id;
	}

	public Date getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	public Boolean getInscricaoCancelada() {
		return inscricaoCancelada;
	}

	public void setInscricaoCancelada(Boolean inscricaoCancelada) {
		this.inscricaoCancelada = inscricaoCancelada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inscricao other = (Inscricao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
