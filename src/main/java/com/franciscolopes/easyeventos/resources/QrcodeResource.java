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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.franciscolopes.easyeventos.domain.Bloco;
import com.franciscolopes.easyeventos.domain.Usuario;
import com.franciscolopes.easyeventos.services.BlocoService;
import com.franciscolopes.easyeventos.services.UsuarioService;
import com.google.zxing.WriterException;

@RestController
@RequestMapping(value="/qrcode")
public class QrcodeResource {
	
	@Autowired
	 private UsuarioService service;
	 private BlocoService blocoService;
	
	
	@PostMapping(value = "/frequencia")
	public Integer postFrequencia(@RequestParam String  qrcodeString) {
		int freq = 0;
		int codBlocoOriginal = 1;//usado apenas para testes, refere-se ao codigo do bloco que deseja controlar a frequencia do participante
		Bloco objBlocoOriginal = blocoService.buscar(codBlocoOriginal);
		int codEventoBlocoOriginal = objBlocoOriginal.getAtividade().getEvento().getCodEvento();
		int codAtividadeBlocoOriginal = objBlocoOriginal.getAtividade().getCodAtividade();
		
		
		
		String qrcodeBase = qrcodeString;//OLHAR ISSO
		String[] elementosQrcodeBase = qrcodeBase.split(";");
		int codEventoQrCode = Integer.parseInt(elementosQrcodeBase[1]);
		
		boolean fazParteEvento = blocoService.verificaEvento(codEventoBlocoOriginal, codEventoQrCode);
		

		int codUsuarioQrCode = Integer.parseInt(elementosQrcodeBase[0]);
		//Usuario objUsuario = service.find(codUsuarioQrCode);
		
		
		boolean cadastradoAtividade = service.verificaUsuarioCadastrado(codUsuarioQrCode, codAtividadeBlocoOriginal);
		
		if(fazParteEvento == true && cadastradoAtividade == true) {
			 freq = objBlocoOriginal.getInscricoes().get(0).alteraFrequncia();
		}
		
		
		//List<String> presenca = new ArrayList<String>();
		//presenca.add("presenca");
		
		//Create Response Object
		//Response response = new Response("Done", customer);
		return freq;
	}
	
	
	@RequestMapping(value="/{codUsuario}", method=RequestMethod.GET)
	public ResponseEntity<byte[]> geraImagemQrcode(@PathVariable Integer codUsuario) throws WriterException, IOException {
		
		Usuario obj = service.find(codUsuario);
		String baseQrcode = obj.getInscricoes().iterator().next().getBaseQrcode();
		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		headers.setContentType(MediaType.IMAGE_PNG);
		
		
		//try {
			byte [] qrCode = obj.getQrcode(baseQrcode, 350, 350);
			ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(qrCode, headers, HttpStatus.OK);
			
        //} catch (WriterException e) {
            //System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        //} catch (IOException e) {
          //  System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        //}
		return responseEntity;
		
	}
}