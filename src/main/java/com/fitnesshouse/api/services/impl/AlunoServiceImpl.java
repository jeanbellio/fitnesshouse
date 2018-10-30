package com.fitnesshouse.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnesshouse.api.documents.Aluno;
import com.fitnesshouse.api.repositories.AlunoRepository;
import com.fitnesshouse.api.services.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService{

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Override
	public List<Aluno> listarTodos() {
		return this.alunoRepository.findAll();
	}

	@Override
	public Aluno listarPorId(String id) {
		return null;
		//return this.alunoRepository.findById(id);
	}

	@Override
	public Aluno cadastrar(Aluno aluno) {
		return this.alunoRepository.save(aluno);
	}

	@Override
	public Aluno atualizar(Aluno aluno) {
		return this.alunoRepository.save(aluno);
	}

	@Override
	public void remover(String id) {
		this.alunoRepository.deleteById(id);
	}


}
