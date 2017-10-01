package com.franciscolopes.easyeventos;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.franciscolopes.easyeventos.domain.Atividade;
import com.franciscolopes.easyeventos.domain.Bloco;
import com.franciscolopes.easyeventos.domain.Equipamento;
import com.franciscolopes.easyeventos.domain.Evento;
import com.franciscolopes.easyeventos.domain.Local;
import com.franciscolopes.easyeventos.repositories.AtividadeRepository;
import com.franciscolopes.easyeventos.repositories.BlocoRepository;
import com.franciscolopes.easyeventos.repositories.EquipamentoRepository;
import com.franciscolopes.easyeventos.repositories.EventoRepository;
import com.franciscolopes.easyeventos.repositories.LocalRepository;

@SpringBootApplication
public class EasyeventosApplication implements CommandLineRunner {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@Autowired
	private LocalRepository localRepository;
	
	@Autowired
	private EquipamentoRepository equipamentoRepository;
	
	@Autowired
	private BlocoRepository blocoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EasyeventosApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {//executa a instanciação dos objetos no momento que a aplicação é iniciada
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Evento evento1 = new Evento (null, "SNCT2017",sdf.parse("23/10/2017 18:45"),sdf.parse("27/10/2017 22:45"),"A Semana Nacional de Ciência e Tecnologia - SNCT - é coordenada pelo Ministério de Ciência e Tecnologia e tem como objetivo aproximar a Ciência e a Tecnologia da população.");
		Evento evento2 = new Evento (null, "3ª Mostra de Trabalhos do IFTM",sdf.parse("24/10/2017 18:45"),sdf.parse("24/10/2017 22:45")," Mostra de Trabalhos da Semana Nacional de Ciência e Tecnologia, a ocorrer no IFTM Campus Uberlândia Centro.");
	
		
		
		Atividade a1 = new Atividade(null,"Arduino","Joao",100,100,sdf.parse("23/10/2017 18:45"),sdf.parse("24/10/2017 22:45"),"Curso arduino",40,"Minicurso",true,true,evento1);
		Atividade a2 = new Atividade(null,"Testes","Alice",100,100,sdf.parse("23/10/2017 18:45"),sdf.parse("24/10/2017 22:45"),"Curso Html",10,"Minicurso",true,true,evento1);
		Atividade a3 = new Atividade(null,"Matematica","Ana",100,100,sdf.parse("23/10/2017 18:45"),sdf.parse("24/10/2017 22:45"),"Curso Css",20,"Minicurso",true,true,evento2);
		Atividade a4 = new Atividade(null,"HTML","Andre",100,100,sdf.parse("23/10/2017 18:45"),sdf.parse("26/10/2017 22:45"),"Curso Jquery",30,"Curso",true,true,evento2);
		
		Bloco bloco1 = new Bloco(null, 100, 200, a1);
		Bloco bloco2 = new Bloco(null, 100, 200, a1);
		
		Bloco bloco3 = new Bloco(null, 100, 200, a2);
		Bloco bloco4 = new Bloco(null, 100, 200, a2);
		
		Bloco bloco5 = new Bloco(null, 100, 200, a3);
		Bloco bloco6 = new Bloco(null, 100, 200, a3);
		
		Bloco bloco7 = new Bloco(null, 100, 200, a4);
		Bloco bloco8 = new Bloco(null, 100, 200, a4);
		Bloco bloco9 = new Bloco(null, 100, 200, a4);
		
		
		Local local1 = new Local(null, "Auditorio", "Auditorio do campus", 150, a1);
		a1.setLocal(local1);
		
		Local local2 = new Local(null, "Sala 18", "Sala de aula do campus", 30, a2);
		a2.setLocal(local2);
		
		Local local3 = new Local(null, "Sala 19", "Sala de aula do campus", 30, a3);
		a3.setLocal(local3);
		
		Local local4 = new Local(null, "Sala 20", "Sala de aula do campus", 30, a4);
		a4.setLocal(local4);
		
		evento1.getAtividades().addAll(Arrays.asList(a1, a2));
		evento2.getAtividades().addAll(Arrays.asList(a3, a4));
		
		a1.getBlocos().addAll(Arrays.asList(bloco1, bloco2));
		a2.getBlocos().addAll(Arrays.asList(bloco3, bloco4));
		a2.getBlocos().addAll(Arrays.asList(bloco5, bloco6));
		a4.getBlocos().addAll(Arrays.asList(bloco7, bloco8, bloco9));
		
		
		
		eventoRepository.save(Arrays.asList(evento1, evento2));
		atividadeRepository.save(Arrays.asList(a1, a2, a3, a4));
		blocoRepository.save(Arrays.asList(bloco1, bloco2, bloco3, bloco4,
				bloco5, bloco6, bloco7, bloco8, bloco9));
		
	
		
		Equipamento equipamento1 = new Equipamento(null, "Notebook", "Notebook com 4G  de RAM e HD de 500G ", local1);
		Equipamento equipamento2 = new Equipamento(null, "Datashow", "Datashow com saída de audio", local1);
		Equipamento equipamento3 = new Equipamento(null, "Notebook", "Notebook com 8G  de RAM e HD de 1T ", local2);
		Equipamento equipamento4 = new Equipamento(null, "Datashow", "Datashow sem saída de audio", local2);
		Equipamento equipamento5 = new Equipamento(null, "Notebook", "Notebook com 4G  de RAM e HD de 500G ", local3);
		Equipamento equipamento6 = new Equipamento(null, "Datashow", "Datashow com saída de audio", local3);
		Equipamento equipamento7 = new Equipamento(null, "Notebook", "Notebook com 8G  de RAM e HD de 1T ", local4);
		Equipamento equipamento8 = new Equipamento(null, "Datashow", "Datashow sem saída de audio", local4);
		
		local1.getEquipamentos().addAll(Arrays.asList(equipamento1, equipamento2));
		local2.getEquipamentos().addAll(Arrays.asList(equipamento3, equipamento4));
		local3.getEquipamentos().addAll(Arrays.asList(equipamento5, equipamento6));
		local4.getEquipamentos().addAll(Arrays.asList(equipamento7, equipamento8));
		
		localRepository.save(Arrays.asList(local1, local2, local3, local4));
		equipamentoRepository.save(Arrays.asList(equipamento1, equipamento2, equipamento3, equipamento4, equipamento5, equipamento6, equipamento7, equipamento8));
		
	}
}
