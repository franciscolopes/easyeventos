package com.franciscolopes.easyeventos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Inscricao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private InscricaoPK id = new InscricaoPK(); 
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataInscricao;
	private Boolean inscricaoCancelada;
	
	@ManyToMany(mappedBy="inscricoes")
	private List<Bloco> blocos = new ArrayList<>();
	
	public Inscricao() {
		
	}

	public Inscricao(Usuario usuario, Atividade atividade, Date dataInscricao, Boolean inscricaoCancelada) {
		super();
		id.setUsuario(usuario);
		id.setAtividade(atividade);
		this.dataInscricao = dataInscricao;
		this.inscricaoCancelada = inscricaoCancelada;
	}

	@JsonIgnore
	public Usuario getUsuario() {
		return id.getUsuario();
	}
	
	@JsonIgnore
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

	public List<Bloco> getBlocos() {
		return blocos;
	}

	public void setBlocos(List<Bloco> blocos) {
		this.blocos = blocos;
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