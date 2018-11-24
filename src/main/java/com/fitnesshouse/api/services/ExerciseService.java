package com.fitnesshouse.api.services;

import java.util.List;

import com.fitnesshouse.api.documents.Exercise;

public interface ExerciseService {
	Exercise create(Exercise student);
	
	List<Exercise> findByMuscleGroupAndTitleLike(String name, String muscleGroupName);
	
	//void saveAll(List<Exercise> exercises);
}
