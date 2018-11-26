package com.fitnesshouse.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnesshouse.api.documents.Exercise;
import com.fitnesshouse.api.enums.MuscleGroupEnum;
import com.fitnesshouse.api.repositories.ExerciseRepository;
import com.fitnesshouse.api.services.ExerciseService;

@Service
public class ExerciseServiceImpl implements ExerciseService {
	
	@Autowired
	private ExerciseRepository exerciseRepository;

	@Override
	public Exercise create(Exercise exercise) {
		return this.exerciseRepository.save(exercise);
	}

	@Override
	public List<Exercise> findByMuscleGroupAndTitleLike(String name, String muscleGroupName) {
		MuscleGroupEnum muscleGroup = MuscleGroupEnum.findMuscleGroupByEnum(muscleGroupName);
		return this.exerciseRepository.findByMuscleGroupAndTitleLike(muscleGroup, name);
	}

	@Override
	public Exercise update(Exercise exercise) {
		return this.exerciseRepository.save(exercise);
	}

	@Override
	public void delete(String id) {
		this.exerciseRepository.delete(id);
	}
	
	/*@Override
	public void saveAll(List<Exercise> exercises) {
		this.exerciseRepository.saveAll(exercises);
	}*/
}
