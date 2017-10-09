package com.franciscolopes.easyeventos.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.franciscolopes.easyeventos.domain.Evento;

public class EventoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer codEvento;
	private String nome;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataInicio;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataFim;
	private String descricao;

	public EventoDTO() {
	}

	public EventoDTO(Evento obj) {
		
		codEvento = obj.getCodEvento();
		nome = obj.getNome();
		dataInicio = obj.getDataInicio();
		dataFim = obj.getDataFim();
		descricao = obj.getDescricao();
	}

	public Integer getCodEvento() {
		return codEvento;
	}

	public void setCodEvento(Integer codEvento) {
		this.codEvento = codEvento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	
}