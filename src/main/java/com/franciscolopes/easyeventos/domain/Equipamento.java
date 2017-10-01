package com.franciscolopes.easyeventos.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Equipamento  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codEquipamento;
	private String nome;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="local_ID")
	private Local local;
	
	public Equipamento() {
		
	}

	public Equipamento(Integer codEquipamento, String nome, String descricao, Local local) {
		super();
		this.codEquipamento = codEquipamento;
		this.nome = nome;
		this.descricao = descricao;
		this.local = local;
	}

	public Integer getCodEquipamento() {
		return codEquipamento;
	}

	public void setCodEquipamento(Integer codEquipamento) {
		this.codEquipamento = codEquipamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codEquipamento == null) ? 0 : codEquipamento.hashCode());
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
		Equipamento other = (Equipamento) obj;
		if (codEquipamento == null) {
			if (other.codEquipamento != null)
				return false;
		} else if (!codEquipamento.equals(other.codEquipamento))
			return false;
		return true;
	}
	
}
