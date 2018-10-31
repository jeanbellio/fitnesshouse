package com.fitnesshouse.api.services;

import java.util.List;

import com.fitnesshouse.api.documents.Aluno;

public interface AlunoService {
	List<Aluno> listarTodos();
	
	Aluno listarPorId(String id);
	
	Aluno cadastrar(Aluno cliente);
	
	Aluno atualizar(Aluno cliente);
	
	void remover(String id);
}
