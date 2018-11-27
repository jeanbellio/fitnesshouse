package com.fitnesshouse.api.services;

import java.util.List;

import com.fitnesshouse.api.documents.Serie;

public interface SerieService {
	
	List<Serie> findAll();
	
	Serie findById(String id);
	
	Serie create(Serie workout);
	
	Serie update(Serie workout);
	
	void delete(String id);
	
	List<Serie> findByIdWorkout(String idWorkout);
}
