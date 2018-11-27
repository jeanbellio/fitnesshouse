package com.fitnesshouse.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnesshouse.api.documents.Serie;
import com.fitnesshouse.api.repositories.SerieRepository;
import com.fitnesshouse.api.services.SerieService;

@Service
public class SerieServiceImpl implements SerieService {

	@Autowired
	private SerieRepository serieRepository;
	
	@Override
	public List<Serie> findAll() {
		return this.serieRepository.findAll(); 
	}

	@Override
	public Serie findById(String id) {
		return this.serieRepository.findOne(id);
	}

	@Override
	public Serie create(Serie serie) {
		return this.serieRepository.save(serie);
	}

	@Override
	public Serie update(Serie serie) {
		return this.serieRepository.save(serie);
	}

	@Override
	public void delete(String id) {
		this.serieRepository.delete(id);
	}

	@Override
	public List<Serie> findByIdWorkout(String idWorkout) {
		return this.serieRepository.findByIdWorkout(idWorkout); 
	}
}
