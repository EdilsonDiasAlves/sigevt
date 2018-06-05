package com.mzo.sigevt.repository;

import org.springframework.data.repository.CrudRepository;

import com.mzo.sigevt.model.Convidado;
import com.mzo.sigevt.model.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String> {
	
	public Iterable<Convidado> findByEvento(Evento evento);
}