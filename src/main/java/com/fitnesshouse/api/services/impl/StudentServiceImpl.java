package com.fitnesshouse.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnesshouse.api.documents.Student;
import com.fitnesshouse.api.repositories.StudentRepository;
import com.fitnesshouse.api.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> findAll() {
		return this.studentRepository.findAll(); 
	}

	@Override
	public Student findById(String id) {
		return this.studentRepository.findOne(id);
	}

	@Override
	public Student create(Student student) {
		return this.studentRepository.save(student);
	}

	@Override
	public Student update(Student student) {
		return this.studentRepository.save(student);
	}

	@Override
	public void delete(String id) {
		this.studentRepository.delete(id);
	}

}
