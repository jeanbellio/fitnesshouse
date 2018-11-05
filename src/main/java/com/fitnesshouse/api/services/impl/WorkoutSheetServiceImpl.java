package com.fitnesshouse.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnesshouse.api.documents.WorkoutSheet;
import com.fitnesshouse.api.repositories.WorkoutSheetRepository;
import com.fitnesshouse.api.services.WorkoutSheetService;

@Service
public class WorkoutSheetServiceImpl implements WorkoutSheetService {

	@Autowired
	private WorkoutSheetRepository workoutSheetRepository;
	
	@Override
	public List<WorkoutSheet> findAll() {
		return this.workoutSheetRepository.findAll(); 
	}

	@Override
	public WorkoutSheet findById(String id) {
		return this.workoutSheetRepository.findOne(id);
	}

	@Override
	public WorkoutSheet create(WorkoutSheet workoutSheet) {
		return this.workoutSheetRepository.save(workoutSheet);
	}

	@Override
	public WorkoutSheet update(WorkoutSheet workoutSheet) {
		return this.workoutSheetRepository.save(workoutSheet);
	}

	@Override
	public void delete(String id) {
		this.workoutSheetRepository.delete(id);
	}

}
