package com.fitnesshouse.api.services;

import java.util.List;

import com.fitnesshouse.api.documents.WorkoutSheet;

public interface WorkoutSheetService {
	
	List<WorkoutSheet> findAll();
	
	WorkoutSheet findById(String id);
	
	WorkoutSheet create(WorkoutSheet workoutSheet);
	
	WorkoutSheet update(WorkoutSheet workoutSheet);
	
	void delete(String id);
}
