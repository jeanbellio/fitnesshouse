package com.fitnesshouse.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fitnesshouse.api.documents.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

}
