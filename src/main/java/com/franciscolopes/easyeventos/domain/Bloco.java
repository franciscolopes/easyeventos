package com.franciscolopes.easyeventos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bloco  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codBloco;
	
	@JsonFormat(pattern="hh:mm")
	private Date horarioIncio;
	
	@JsonFormat(pattern="hh:mm")
	private Date horarioFim;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="atividade_id")
	private Atividade atividade;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "BLOCO_INSCRICAO",
		joinColumns = @JoinColumn(name = "bloco_id"),
		inverseJoinColumns = {@JoinColumn(table = "USUARIO",
                name = "usuario_id", 
                referencedColumnName = "usuario_id"),
    @JoinColumn(table = "ATIVIDADE",
                name = "atividade_id",                               
                referencedColumnName = "atividade_id", 
                nullable = true)}
	)
	private List<Inscricao> inscricoes = new ArrayList<>();
	
	public Bloco() {
		
	}

	public Bloco(Integer codBloco, Date horarioIncio, Date horarioFim, Atividade atividade) {
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

	public Date getHorarioIncio() {
		return horarioIncio;
	}

	public void setHorarioIncio(Date horarioIncio) {
		this.horarioIncio = horarioIncio;
	}

	public Date getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(Date horarioFim) {
		this.horarioFim = horarioFim;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
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
