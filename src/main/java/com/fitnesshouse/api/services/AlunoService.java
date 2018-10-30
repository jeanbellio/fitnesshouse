package com.fitnesshouse.api.services;

import java.util.List;

import com.fitnesshouse.api.documents.Aluno;

public interface AlunoService {
	
	List<Aluno> listarTodos();
	
	Aluno listarPorId(String id);
	
	Aluno cadastrar(Aluno aluno);
	
	Aluno atualizar(Aluno aluno);
	
	void remover(String id);
}
