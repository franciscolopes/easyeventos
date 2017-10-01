package com.franciscolopes.easyeventos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Local  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codLocal;
	private String nome;
	private String descricao;
	private Integer capacidadeMax;
	
	@OneToMany(mappedBy="local")
	private List<Equipamento> equipamentos = new ArrayList<>();
	
	/*@JsonBackReference*/
	@OneToOne
	@JoinColumn(name="atividade_id")
	@MapsId
	private Atividade atividade;
	
	
	public Local () {
		
	}

	public Local(Integer codLocal, String nome, String descricao, Integer capacidadeMax, Atividade atividade) {
		super();
		this.codLocal = codLocal;
		this.nome = nome;
		this.descricao = descricao;
		this.capacidadeMax = capacidadeMax;
		this.atividade = atividade;
	}

	public Integer getCodLocal() {
		return codLocal;
	}

	public void setCodLocal(Integer codLocal) {
		this.codLocal = codLocal;
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

	public Integer getCapacidadeMax() {
		return capacidadeMax;
	}

	public void setCapacidadeMax(Integer capacidadeMax) {
		this.capacidadeMax = capacidadeMax;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	/**
	 * @return the atividade
	 */
	public Atividade getAtividade() {
		return atividade;
	}

	/**
	 * @param atividade the atividade to set
	 */
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codLocal == null) ? 0 : codLocal.hashCode());
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
		Local other = (Local) obj;
		if (codLocal == null) {
			if (other.codLocal != null)
				return false;
		} else if (!codLocal.equals(other.codLocal))
			return false;
		return true;
	}
	
	
}
