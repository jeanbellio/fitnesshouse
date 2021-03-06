package com.fitnesshouse.api.services;

import java.util.List;

import com.fitnesshouse.api.documents.Exercise;
import com.fitnesshouse.api.documents.User;

public interface ExerciseService {
	Exercise create(Exercise student);
	
	List<Exercise> findByMuscleGroupAndTitleLike(String muscleGroupName, String name);
	
	Exercise update(Exercise exercise);
	
	void delete(String id);
	
	List<Exercise> findAll();
	
	List<Exercise> findByMuscleGroupLike(String muscleGroupName);
	
	//void saveAll(List<Exercise> exercises);
}
