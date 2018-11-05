package com.fitnesshouse.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fitnesshouse.api.documents.Workout;

public interface WorkoutRepository extends MongoRepository<Workout, String> {

}
