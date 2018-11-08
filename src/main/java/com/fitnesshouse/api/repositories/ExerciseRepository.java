package com.fitnesshouse.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.fitnesshouse.api.documents.Exercise;

public interface ExerciseRepository extends MongoRepository<Exercise, String> {
//	@Query("{ 'name' : { '$regex' : ?0}, 'muscleGroup' : { '$regex' : ?1}}")
//	List<Exercise> findByNameAndMuscleGroupName(String name, String muscleGroup);

	List<Exercise> findByTitleLike(String name);

}
