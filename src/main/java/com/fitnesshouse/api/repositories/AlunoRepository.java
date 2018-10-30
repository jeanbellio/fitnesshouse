package com.fitnesshouse.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fitnesshouse.api.documents.Aluno;

public interface AlunoRepository extends MongoRepository<Aluno, String> {

}
