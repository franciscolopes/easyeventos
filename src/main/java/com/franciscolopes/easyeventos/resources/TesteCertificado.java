package com.franciscolopes.easyeventos.resources;

import org.springframework.web.bind.annotation.RequestMapping;

public class TesteCertificado {

	@RequestMapping(value = "/certificado")
	public String index() {
		return "certificado.html";
	}
}