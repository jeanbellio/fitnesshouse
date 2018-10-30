package com.fitnesshouse.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fitnesshouse.api.documents.Serie;

public interface SerieRepository extends MongoRepository<Serie, String> {

}
