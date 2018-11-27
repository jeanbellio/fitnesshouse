package com.fitnesshouse.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.fitnesshouse.api.documents.WorkoutSheet;

public interface WorkoutSheetRepository extends MongoRepository<WorkoutSheet, String> {

	//@Query("{ 'name' : { '$regex' : ?0}}")
	List<WorkoutSheet> findByIdStudent(String idStudent);

	WorkoutSheet findCurrentByIdStudent(String idStudent);
}
