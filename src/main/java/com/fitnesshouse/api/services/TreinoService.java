package com.fitnesshouse.api.services;

import java.util.List;

import com.fitnesshouse.api.documents.Treino;

public interface TreinoService {
	
	List<Treino> listarTodos();
	
	Treino listarPorId(String id);
	
	Treino cadastrar(Treino treino);
	
	Treino atualizar(Treino treino);
	
	void remover(String id);
}
