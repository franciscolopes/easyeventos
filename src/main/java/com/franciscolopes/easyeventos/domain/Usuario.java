package com.franciscolopes.easyeventos.domain;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.franciscolopes.easyeventos.domain.enums.CategoriaUsuario;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Entity
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//RETIRAR ESSA ANOTAÇÃO?
	private Integer codUsuario;
	
	private String nome;
	private String senha;
	private String email;
	private String cpf;
	private Integer categoria;
	
	@OneToMany(mappedBy="id.usuario")
	private Set<Certificado> certificados = new HashSet<>();
	
	@OneToMany(mappedBy="id.usuario")
	private Set<Inscricao> inscricoes = new HashSet<>();
	
	public Usuario() {
		
	}

	public Usuario(Integer codUsuario, String nome, String senha, String email, String cpf,
			CategoriaUsuario categoria) {
		super();
		this.codUsuario = codUsuario;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.cpf = cpf;
		this.categoria = (categoria==null) ? null : categoria.getCod();
	}

	
	
	
	
	
	
	
	
	public List<Atividade> getAtividades() {
		List<Atividade> lista = new ArrayList<>();
		for (Inscricao x : inscricoes) {
			lista.add(x.getAtividade());
		}
		return lista;
	}
	
	public List<Evento> getEventos() {
		List<Evento> lista = new ArrayList<>();
		for (Certificado x : certificados) {
			lista.add(x.getEvento());
		}
		return lista;
	}
	
	public Set<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(Set<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}

	public Integer getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public CategoriaUsuario getCategoria() {
		return CategoriaUsuario.toEnum(categoria);
	}

	public void setCategoria(CategoriaUsuario categoria) {
		this.categoria = categoria.getCod();
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
		result = prime * result + ((codUsuario == null) ? 0 : codUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (codUsuario == null) {
			if (other.codUsuario != null)
				return false;
		} else if (!codUsuario.equals(other.codUsuario))
			return false;
		return true;
	}

	
	/*-----------QRCODE-----------*/
	public byte[] getQrcode(String baseQrcode, int largura, int altura) throws WriterException, IOException {
	    QRCodeWriter qrCodeWriter = new QRCodeWriter();
	    BitMatrix bitMatrix = qrCodeWriter.encode(baseQrcode, BarcodeFormat.QR_CODE, largura, altura);
	    
	    ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
	    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
	    byte[] pngData = pngOutputStream.toByteArray(); 
	    return pngData;
	}
	/*-----------QRCODE-----------*/
	
	
	
	
	
	
	
	
	
}
