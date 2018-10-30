package com.fitnesshouse.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnesshouse.api.documents.Treino;
import com.fitnesshouse.api.repositories.TreinoRepository;
import com.fitnesshouse.api.services.TreinoService;

@Service
public class TreinoServiceImpl implements TreinoService{

	@Autowired
	private TreinoRepository treinoRepository;
	
	@Override
	public List<Treino> listarTodos() {
		return this.treinoRepository.findAll();
	}

	@Override
	public Treino listarPorId(String id) {
		return null;
		//return this.treinoRepository.findById(id);
	}

	@Override
	public Treino cadastrar(Treino treino) {
		return this.treinoRepository.save(treino);
	}

	@Override
	public Treino atualizar(Treino treino) {
		return this.treinoRepository.save(treino);
	}

	@Override
	public void remover(String id) {
		this.treinoRepository.deleteById(id);
	}


}
