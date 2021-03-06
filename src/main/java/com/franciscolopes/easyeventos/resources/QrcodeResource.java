package com.franciscolopes.easyeventos.resources;

import java.io.IOException;

//import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.franciscolopes.easyeventos.domain.Usuario;
import com.franciscolopes.easyeventos.services.BlocoService;
import com.franciscolopes.easyeventos.services.EventoService;
import com.franciscolopes.easyeventos.services.UsuarioService;
import com.google.zxing.WriterException;

@RestController
@RequestMapping(value = "/qrcode")
public class QrcodeResource {

	@Autowired
	private UsuarioService service;
	

	@RequestMapping(value = "/frequencia", method = RequestMethod.GET)
	public ResponseEntity<Integer> postFrequencia(@RequestParam(value = "qrcodeString", required = true) String qrcodeString) throws WriterException, IOException {
//enviar como parametro o codigo do bloco
		
		int codBloco = 1;
//		int freq =qrcodeString.length(); 
		int codUsuario = Integer.parseInt(qrcodeString); 
		//Usuario obj = service.find(codUsuario);
		//boolean presente = service.verificaUsuarioCadastrado(codUsuario, codBloco);
		
		
		ResponseEntity<Integer> responseEntity = new ResponseEntity<>(codUsuario, HttpStatus.OK);
		return responseEntity;
		

	}

	@RequestMapping(value = "/{codUsuario}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> geraImagemQrcode(@PathVariable Integer codUsuario)
			throws WriterException, IOException {

		Usuario obj = service.find(codUsuario);
		String baseQrcode = Integer.toString(obj.getInscricoes().iterator().next().getBaseQrcode());
		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		headers.setContentType(MediaType.IMAGE_PNG);

		// try {
		byte[] qrCode = obj.getQrcode(baseQrcode, 350, 350);
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(qrCode, headers, HttpStatus.OK);

		// } catch (WriterException e) {
		// System.out.println("Could not generate QR Code, WriterException :: " +
		// e.getMessage());
		// } catch (IOException e) {
		// System.out.println("Could not generate QR Code, IOException :: " +
		// e.getMessage());
		// }
		return responseEntity;

	}
}