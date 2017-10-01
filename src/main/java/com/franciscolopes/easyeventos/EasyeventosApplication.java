package com.franciscolopes.easyeventos;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.franciscolopes.easyeventos.domain.Atividade;
import com.franciscolopes.easyeventos.domain.Evento;
import com.franciscolopes.easyeventos.repositories.AtividadeRepository;
import com.franciscolopes.easyeventos.repositories.EventoRepository;

@SpringBootApplication
public class EasyeventosApplication implements CommandLineRunner {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EasyeventosApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {//executa a instanciação dos objetos no momento que a aplicação é iniciada
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Evento evento1 = new Evento (null, "SNCT2017",sdf.parse("23/10/2017 18:45"),sdf.parse("27/10/2017 22:45"),"A Semana Nacional de Ciência e Tecnologia - SNCT - é coordenada pelo Ministério de Ciência e Tecnologia e tem como objetivo aproximar a Ciência e a Tecnologia da população.");
		Evento evento2 = new Evento (null, "3ª Mostra de Trabalhos do IFTM",sdf.parse("24/10/2017 18:45"),sdf.parse("24/10/2017 22:45")," Mostra de Trabalhos da Semana Nacional de Ciência e Tecnologia, a ocorrer no IFTM Campus Uberlândia Centro.");
	
		Atividade a1 = new Atividade(null,"Arduino","Joao",100,100,sdf.parse("23/10/2017 18:45"),sdf.parse("27/10/2017 22:45"),"Curso arduino",40,"Minicurso",true,true,evento1);
		Atividade a2 = new Atividade(null,"Testes","Joao",100,100,sdf.parse("23/10/2017 18:45"),sdf.parse("27/10/2017 22:45"),"Curso arduino",40,"Minicurso",true,true,evento1);
		Atividade a3 = new Atividade(null,"Matematica","Joao",100,100,sdf.parse("23/10/2017 18:45"),sdf.parse("27/10/2017 22:45"),"Curso arduino",40,"Minicurso",true,true,evento2);
		Atividade a4 = new Atividade(null,"HTML","Joao",100,100,sdf.parse("23/10/2017 18:45"),sdf.parse("27/10/2017 22:45"),"Curso arduino",40,"Minicurso",true,true,evento2);
		
		evento1.getAtividades().addAll(Arrays.asList(a1, a2));
		evento2.getAtividades().addAll(Arrays.asList(a3, a4));
		
		
		eventoRepository.save(Arrays.asList(evento1, evento2));
		atividadeRepository.save(Arrays.asList(a1, a2, a3, a4));
		
			
		
	}
}
