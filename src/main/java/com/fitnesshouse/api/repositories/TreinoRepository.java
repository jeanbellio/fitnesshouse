package com.fitnesshouse.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fitnesshouse.api.documents.Treino;

public interface TreinoRepository extends MongoRepository<Treino, String> {

}
