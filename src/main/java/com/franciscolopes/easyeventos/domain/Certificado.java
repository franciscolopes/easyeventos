package com.franciscolopes.easyeventos.domain;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Certificado implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private CertificadoPK id = new CertificadoPK();

	private String CodigoValidacao;

	public Certificado() {

	}

	public Certificado(Usuario usuario, Evento evento, String codigoValidacao) {
		super();
		id.setUsuario(usuario);
		id.setEvento(evento);
		CodigoValidacao = codigoValidacao;
	}

	
	/*---------METODO GERA CERTIFICADO-----------------*/
	//
	//
	//
	/*---------METODO GERA CERTIFICADO-----------------*/
	
	@JsonIgnore
	public Usuario getUsuario() {
		return id.getUsuario();
	}

	@JsonIgnore
	public Evento getEvento() {
		return id.getEvento();
	}

	public CertificadoPK getId() {
		return id;
	}

	public void setId(CertificadoPK id) {
		this.id = id;
	}

	public String getCodigoValidacao() {
		return CodigoValidacao;
	}

	public void setCodigoValidacao(String codigoValidacao) {
		CodigoValidacao = codigoValidacao;
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
		Certificado other = (Certificado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
