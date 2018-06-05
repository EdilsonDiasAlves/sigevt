package com.mzo.sigevt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mzo.sigevt.model.Convidado;
import com.mzo.sigevt.model.Evento;
import com.mzo.sigevt.repository.ConvidadoRepository;
import com.mzo.sigevt.repository.EventoRepository;

@Controller
public class EventoController {
	
	@Autowired
	EventoRepository er;
	
	@Autowired
	ConvidadoRepository cr;

	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
	public String form(@Valid Evento evt, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarEvento";
		}
		
		er.save(evt);
		attributes.addFlashAttribute("mensagem", "Evento adicionado com sucesso!");
		return "redirect:/cadastrarEvento";
	}
	
	@RequestMapping(value="/eventos", method=RequestMethod.GET)
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = er.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		Evento evento = er.findById(id);
		Iterable<Convidado> convidados = cr.findByEvento(evento);
		
		mv.addObject("convidados", convidados);
		mv.addObject("evento", evento);
		return mv;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String detalhesEventoPost(@PathVariable("id") long id, @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{id}";
		}
		
		Evento evt = er.findById(id);
		convidado.setEvento(evt);
		cr.save(convidado);
		attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!");
		return "redirect:/{id}";
	}	
}
