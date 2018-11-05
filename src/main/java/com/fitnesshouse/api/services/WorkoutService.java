package com.fitnesshouse.api.services;

import java.util.List;

import com.fitnesshouse.api.documents.Workout;

public interface WorkoutService {
	
	List<Workout> findAll();
	
	Workout findById(String id);
	
	Workout create(Workout workout);
	
	Workout update(Workout workout);
	
	void delete(String id);
}
