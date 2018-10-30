package com.fitnesshouse.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnesshouse.api.documents.Professor;
import com.fitnesshouse.api.repositories.ProfessorRepository;
import com.fitnesshouse.api.services.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService{

	@Autowired
	private ProfessorRepository professorRepository;
	
	@Override
	public List<Professor> listarTodos() {
		return this.professorRepository.findAll();
	}

	@Override
	public Professor listarPorId(String id) {
		return null;
		//return this.professorRepository.findById(id);
	}

	@Override
	public Professor cadastrar(Professor professor) {
		return this.professorRepository.save(professor);
	}

	@Override
	public Professor atualizar(Professor professor) {
		return this.professorRepository.save(professor);
	}

	@Override
	public void remover(String id) {
		this.professorRepository.deleteById(id);
	}


}
