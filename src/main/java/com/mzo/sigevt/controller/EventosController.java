package com.mzo.sigevt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mzo.sigevt.model.Evento;
import com.mzo.sigevt.repository.EventoRepository;

@Controller
public class EventosController {
	
	@Autowired
	EventoRepository evtRepository;

	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
	public String form(Evento evt) {
		
		evtRepository.save(evt);
		return "redirect:/cadastrarEvento";
	}	
}
