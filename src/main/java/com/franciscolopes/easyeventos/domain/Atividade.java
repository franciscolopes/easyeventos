package com.franciscolopes.easyeventos.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Atividade implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codAtividade;
	private String nome;
	private String ministrante;
	private Integer horarioInicio;
	private Integer horarioFim;
	private Date dataInicio;
	private Date dataFim;
	private String descricao;
	private Integer nroVagas;
	private String tipoAtividade;
	private Boolean inscricaoAberta;
	private Boolean atividadeAtiva;
		
	
	@ManyToOne
	@JoinColumn(name="evento_id")
	private Evento evento;
	
	public Atividade() {
		
	}

	public Atividade(Integer codAtividade, String nome, String ministrante, Integer horarioInicio, Integer horarioFim,
			Date dataInicio, Date dataFim, String descricao, Integer nroVagas, String tipoAtividade,
			Boolean inscricaoAberta, Boolean atividadeAtiva, Evento evento) {
		super();
		this.codAtividade = codAtividade;
		this.nome = nome;
		this.ministrante = ministrante;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.descricao = descricao;
		this.nroVagas = nroVagas;
		this.tipoAtividade = tipoAtividade;
		this.inscricaoAberta = inscricaoAberta;
		this.atividadeAtiva = atividadeAtiva;
		this.evento = evento;
	}

	public Integer getCodAtividade() {
		return codAtividade;
	}

	public void setCodAtividade(Integer codAtividade) {
		this.codAtividade = codAtividade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMinistrante() {
		return ministrante;
	}

	public void setMinistrante(String ministrante) {
		this.ministrante = ministrante;
	}

	public Integer getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Integer horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Integer getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(Integer horarioFim) {
		this.horarioFim = horarioFim;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getNroVagas() {
		return nroVagas;
	}

	public void setNroVagas(Integer nroVagas) {
		this.nroVagas = nroVagas;
	}

	public String getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(String tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public Boolean getInscricaoAberta() {
		return inscricaoAberta;
	}

	public void setInscricaoAberta(Boolean inscricaoAberta) {
		this.inscricaoAberta = inscricaoAberta;
	}

	public Boolean getAtividadeAtiva() {
		return atividadeAtiva;
	}

	public void setAtividadeAtiva(Boolean atividadeAtiva) {
		this.atividadeAtiva = atividadeAtiva;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAtividade == null) ? 0 : codAtividade.hashCode());
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
		Atividade other = (Atividade) obj;
		if (codAtividade == null) {
			if (other.codAtividade != null)
				return false;
		} else if (!codAtividade.equals(other.codAtividade))
			return false;
		return true;
	}
	
	
	
	
}
