package com.fitnesshouse.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnesshouse.api.documents.Exercise;
import com.fitnesshouse.api.repositories.ExerciseRepository;
import com.fitnesshouse.api.services.ExerciseService;

@Service
public class ExerciseServiceImpl implements ExerciseService {
	
	@Autowired
	private ExerciseRepository exerciseRepository;

//	@Override
//	public List<Exercise> findByNameAndMuscleGroupName(String name, String muscleGroup) {
//		return this.exerciseRepository.findByNameAndMuscleGroupName(name, muscleGroup);
//	}

	@Override
	public Exercise create(Exercise exercise) {
		return this.exerciseRepository.save(exercise);
	}

	@Override
	public List<Exercise> findByTitle(String name) {
		return this.exerciseRepository.findByTitleLike(name);
	}

}
