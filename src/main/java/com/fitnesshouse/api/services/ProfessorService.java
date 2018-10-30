package com.fitnesshouse.api.services;

import java.util.List;

import com.fitnesshouse.api.documents.Professor;

public interface ProfessorService {
	
	List<Professor> listarTodos();
	
	Professor listarPorId(String id);
	
	Professor cadastrar(Professor professor);
	
	Professor atualizar(Professor professor);
	
	void remover(String id);
}
