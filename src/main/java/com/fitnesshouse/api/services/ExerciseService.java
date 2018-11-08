package com.fitnesshouse.api.services;

import java.util.List;

import com.fitnesshouse.api.documents.Exercise;

public interface ExerciseService {
//	List<Exercise> findByNameAndMuscleGroupName(String name, String muscleGroup);
	Exercise create(Exercise student);
	
	@Deprecated List<Exercise> findByTitle(String name);
}
