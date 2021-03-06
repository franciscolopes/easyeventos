package com.franciscolopes.easyeventos;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.franciscolopes.easyeventos.domain.Atividade;
import com.franciscolopes.easyeventos.domain.Bloco;
import com.franciscolopes.easyeventos.domain.Certificado;
import com.franciscolopes.easyeventos.domain.Equipamento;
import com.franciscolopes.easyeventos.domain.Evento;
import com.franciscolopes.easyeventos.domain.Inscricao;
import com.franciscolopes.easyeventos.domain.Local;
import com.franciscolopes.easyeventos.domain.Usuario;
import com.franciscolopes.easyeventos.domain.enums.CategoriaUsuario;
import com.franciscolopes.easyeventos.repositories.AtividadeRepository;
import com.franciscolopes.easyeventos.repositories.BlocoRepository;
import com.franciscolopes.easyeventos.repositories.CertificadoRepository;
import com.franciscolopes.easyeventos.repositories.EquipamentoRepository;
import com.franciscolopes.easyeventos.repositories.EventoRepository;
import com.franciscolopes.easyeventos.repositories.InscricaoRepository;
import com.franciscolopes.easyeventos.repositories.LocalRepository;
import com.franciscolopes.easyeventos.repositories.UsuarioRepository;

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
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private InscricaoRepository inscricaoRepository;
	
	@Autowired
	private CertificadoRepository certificadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EasyeventosApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {//executa a instanciação dos objetos no momento que a aplicação é iniciada
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm");
		
		Usuario usuario1 = new Usuario(null, "Maria","4585","maria@gmail.com","10098415871",CategoriaUsuario.SERVIDOR);
		Usuario usuario2 = new Usuario(null, "Celio","4dd5","celio@gmail.com","96098515871",CategoriaUsuario.ALUNO);
		Usuario usuario3 = new Usuario(null, "Alan","try5","alan@gmail.com","15668415871",CategoriaUsuario.VISITANTE);
		
		Evento evento1 = new Evento (null, "SNCT2017",sdf.parse("23/10/2017"),sdf.parse("27/10/2017"),"A Semana Nacional de Ciência e Tecnologia - SNCT - é coordenada pelo Ministério de Ciência e Tecnologia e tem como objetivo aproximar a Ciência e a Tecnologia da população.");
		Evento evento2 = new Evento (null, "3ª Mostra de Trabalhos do IFTM",sdf.parse("24/10/2017"),sdf.parse("24/10/2017")," Mostra de Trabalhos da Semana Nacional de Ciência e Tecnologia, a ocorrer no IFTM Campus Uberlândia Centro.");
		eventoRepository.save(Arrays.asList(evento1, evento2));
		
		usuarioRepository.save(Arrays.asList(usuario1, usuario2, usuario3));
		
		Certificado cert1 = new Certificado(usuario1, evento1, "bE7Za^Rx8");
		Certificado cert2 = new Certificado(usuario1, evento2, "N2STdF_^s");
		Certificado cert3 = new Certificado(usuario2, evento1, "2*$mjFmra");
		Certificado cert4 = new Certificado(usuario3, evento2, "8+W4hzFpN");
		
		usuario1.getCertificados().addAll(Arrays.asList(cert1, cert2));
		usuario2.getCertificados().addAll(Arrays.asList(cert3));
		usuario3.getCertificados().addAll(Arrays.asList(cert4));
		
		evento1.getCertificados().addAll(Arrays.asList(cert1, cert3));
		evento2.getCertificados().addAll(Arrays.asList(cert2, cert4));
		
		certificadoRepository.save(Arrays.asList(cert1, cert2, cert3, cert4));
		
		Atividade a1 = new Atividade(null,"Arduino","Joao",sdf2.parse("18:45"),sdf2.parse("22:45"),sdf.parse("23/10/2017"),sdf.parse("24/10/2017"),"Minicurso arduino",40,"Minicurso",true,true,evento1);
		Atividade a2 = new Atividade(null,"Testes de Sistemas","Alice",sdf2.parse("18:45"),sdf2.parse("22:45"),sdf.parse("23/10/2017"),sdf.parse("24/10/2017"),"Minicurso Testes",10,"Minicurso",true,true,evento1);
		Atividade a3 = new Atividade(null,"CSS 3","Ana",sdf2.parse("18:45"),sdf2.parse("22:45"),sdf.parse("23/10/2017"),sdf.parse("24/10/2017"),"Minicurso Css",20,"Minicurso",true,true,evento2);
		Atividade a4 = new Atividade(null,"HTML 5","Andre",sdf2.parse("18:45"),sdf2.parse("22:45"),sdf.parse("23/10/2017"),sdf.parse("26/10/2017"),"Minicurso Html",30,"Minicurso",true,true,evento2);
		
		Bloco bloco1 = new Bloco(null, sdf2.parse("18:45"),sdf2.parse("22:45"), a1);
		Bloco bloco2 = new Bloco(null, sdf2.parse("18:45"),sdf2.parse("22:45"), a1);
		
		Bloco bloco3 = new Bloco(null, sdf2.parse("18:45"),sdf2.parse("22:45"), a2);
		Bloco bloco4 = new Bloco(null, sdf2.parse("18:45"),sdf2.parse("22:45"), a2);
		
		Bloco bloco5 = new Bloco(null, sdf2.parse("18:45"),sdf2.parse("22:45"), a3);
		Bloco bloco6 = new Bloco(null, sdf2.parse("18:45"),sdf2.parse("22:45"), a3);
		
		Bloco bloco7 = new Bloco(null, sdf2.parse("18:45"),sdf2.parse("22:45"), a4);
		Bloco bloco8 = new Bloco(null, sdf2.parse("18:45"),sdf2.parse("22:45"), a4);
		Bloco bloco9 = new Bloco(null, sdf2.parse("18:45"),sdf2.parse("22:45"), a4);
		
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
		
		atividadeRepository.save(Arrays.asList(a1, a2, a3, a4));
		blocoRepository.save(Arrays.asList(bloco1, bloco2, bloco3, bloco4, bloco5, bloco6, bloco7, bloco8, bloco9));
		
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
		
		Inscricao inscricao1 = new Inscricao(usuario1, a1, sdf.parse("20/10/2017"), false, 0);/*-----ACRESCENTEI FREQUENCIA 23/11--------*/
		Inscricao inscricao2 = new Inscricao(usuario1, a4, sdf.parse("21/10/2017"), false, 0);/*-----ACRESCENTEI FREQUENCIA 23/11--------*/
		Inscricao inscricao3 = new Inscricao(usuario2, a2, sdf.parse("10/10/2017"), false, 0);/*-----ACRESCENTEI FREQUENCIA 23/11--------*/
		Inscricao inscricao4 = new Inscricao(usuario3, a3, sdf.parse("17/10/2017"), false, 0);/*-----ACRESCENTEI FREQUENCIA 23/11--------*/
		
		a1.getInscricoes().addAll(Arrays.asList(inscricao1));
		a2.getInscricoes().addAll(Arrays.asList(inscricao3));
		a3.getInscricoes().addAll(Arrays.asList(inscricao4));
		a4.getInscricoes().addAll(Arrays.asList(inscricao2));
		
		usuario1.getInscricoes().addAll(Arrays.asList(inscricao1, inscricao2));
		usuario2.getInscricoes().addAll(Arrays.asList(inscricao3));
		usuario3.getInscricoes().addAll(Arrays.asList(inscricao4));
		
		inscricao1.getBlocos().addAll(Arrays.asList(bloco1, bloco2));
		inscricao2.getBlocos().addAll(Arrays.asList(bloco7, bloco8, bloco9));
		inscricao3.getBlocos().addAll(Arrays.asList(bloco3, bloco4));
		inscricao4.getBlocos().addAll(Arrays.asList(bloco5, bloco6));
		
		bloco1.getInscricoes().addAll(Arrays.asList(inscricao1));
		bloco2.getInscricoes().addAll(Arrays.asList(inscricao1));
		bloco3.getInscricoes().addAll(Arrays.asList(inscricao3));
		bloco4.getInscricoes().addAll(Arrays.asList(inscricao3));
		bloco5.getInscricoes().addAll(Arrays.asList(inscricao4));
		bloco6.getInscricoes().addAll(Arrays.asList(inscricao4));
		bloco7.getInscricoes().addAll(Arrays.asList(inscricao2));
		bloco8.getInscricoes().addAll(Arrays.asList(inscricao2));
		bloco9.getInscricoes().addAll(Arrays.asList(inscricao2));
		
		inscricaoRepository.save(Arrays.asList(inscricao1, inscricao2, inscricao3, inscricao4));
		blocoRepository.save(Arrays.asList(bloco1, bloco2, bloco3, bloco4, bloco5, bloco6, bloco7, bloco8, bloco9));

	}
}
