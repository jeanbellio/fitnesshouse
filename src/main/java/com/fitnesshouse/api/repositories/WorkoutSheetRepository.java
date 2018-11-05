package com.fitnesshouse.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fitnesshouse.api.documents.WorkoutSheet;

public interface WorkoutSheetRepository extends MongoRepository<WorkoutSheet, String> {

}
