package com.fitnesshouse.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fitnesshouse.api.documents.Teacher;

public interface TeacherRepository extends MongoRepository<Teacher, String> {

}
