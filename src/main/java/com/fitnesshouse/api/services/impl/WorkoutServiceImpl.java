package com.fitnesshouse.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnesshouse.api.documents.Workout;
import com.fitnesshouse.api.repositories.WorkoutRepository;
import com.fitnesshouse.api.services.WorkoutService;

@Service
public class WorkoutServiceImpl implements WorkoutService {

	@Autowired
	private WorkoutRepository workoutRepository;
	
	@Override
	public List<Workout> findAll() {
		return this.workoutRepository.findAll(); 
	}

	@Override
	public Workout findById(String id) {
		return this.workoutRepository.findOne(id);
	}

	@Override
	public Workout create(Workout workout) {
		return this.workoutRepository.save(workout);
	}

	@Override
	public Workout update(Workout workout) {
		return this.workoutRepository.save(workout);
	}

	@Override
	public void delete(String id) {
		this.workoutRepository.delete(id);
	}

}
