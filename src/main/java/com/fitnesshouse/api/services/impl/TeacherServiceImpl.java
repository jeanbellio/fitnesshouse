package com.fitnesshouse.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnesshouse.api.documents.Teacher;
import com.fitnesshouse.api.repositories.TeacherRepository;
import com.fitnesshouse.api.services.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public List<Teacher> findAll() {
		return this.teacherRepository.findAll(); 
	}

	@Override
	public Teacher findById(String id) {
		return this.teacherRepository.findOne(id);
	}

	@Override
	public Teacher create(Teacher teacher) {
		return this.teacherRepository.save(teacher);
	}

	@Override
	public Teacher update(Teacher teacher) {
		return this.teacherRepository.save(teacher);
	}

	@Override
	public void delete(String id) {
		this.teacherRepository.delete(id);
	}

}
