package com.franciscolopes.easyeventos.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bloco  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codBloco;
	private Integer horarioIncio;
	private Integer horarioFim;
	
	@ManyToOne
	@JoinColumn(name="atividade_id")
	private Atividade atividade;
	
	public Bloco() {
		
	}

	public Bloco(Integer codBloco, Integer horarioIncio, Integer horarioFim, Atividade atividade) {
		super();
		this.codBloco = codBloco;
		this.horarioIncio = horarioIncio;
		this.horarioFim = horarioFim;
		this.atividade = atividade;
	}

	public Integer getCodBloco() {
		return codBloco;
	}

	public void setCodBloco(Integer codBloco) {
		this.codBloco = codBloco;
	}

	public Integer getHorarioIncio() {
		return horarioIncio;
	}

	public void setHorarioIncio(Integer horarioIncio) {
		this.horarioIncio = horarioIncio;
	}

	public Integer getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(Integer horarioFim) {
		this.horarioFim = horarioFim;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codBloco == null) ? 0 : codBloco.hashCode());
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
		Bloco other = (Bloco) obj;
		if (codBloco == null) {
			if (other.codBloco != null)
				return false;
		} else if (!codBloco.equals(other.codBloco))
			return false;
		return true;
	}
	
	
}
