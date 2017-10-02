package com.franciscolopes.easyeventos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Evento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer codEvento;
	
	private String nome;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataInicio;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataFim;
	private String descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy="id.evento")
	private Set<Certificado> certificados = new HashSet<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy="evento")
	private List<Atividade> atividades = new ArrayList<>(); 
	
	public Evento() {
		
	}

	public Evento(Integer codEvento, String nome, Date dataInicio, Date dataFim, String descricao) {
		super();
		this.codEvento = codEvento;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.descricao = descricao;
	}
	@JsonIgnore/*Deve ser serializado?*/
	public List<Usuario> getUsuarios() {
		List<Usuario> lista = new ArrayList<>();
		for (Certificado x : certificados) {
			lista.add(x.getUsuario());
		}
		return lista;
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
	
	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	
	public Set<Certificado> getCertificados() {
		return certificados;
	}

	public void setCertificados(Set<Certificado> certificados) {
		this.certificados = certificados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codEvento == null) ? 0 : codEvento.hashCode());
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
		Evento other = (Evento) obj;
		if (codEvento == null) {
			if (other.codEvento != null)
				return false;
		} else if (!codEvento.equals(other.codEvento))
			return false;
		return true;
	}
	
}
