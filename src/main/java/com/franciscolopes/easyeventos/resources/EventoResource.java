package com.franciscolopes.easyeventos.resources;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.franciscolopes.easyeventos.domain.Evento;

@RestController
@RequestMapping(value="/eventos")
public class EventoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Evento> listar() {
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1988);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date data1 = cal.getTime();
		
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.YEAR, 1989);
		cal1.set(Calendar.MONTH, Calendar.JANUARY);
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		Date data2 = cal1.getTime();
		
		Evento e1 = new Evento (1,"SNCT",data1,data2,"Teste"); 
		
		Evento e2 = new Evento (1,"SNCT",data1,data2,"Teste"); 
		
		List<Evento>  lista = new ArrayList<>();
		lista.add(e1);
		lista.add(e2);
		return lista;
		
	}
}
