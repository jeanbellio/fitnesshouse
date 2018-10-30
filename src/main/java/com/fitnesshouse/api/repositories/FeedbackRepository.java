package com.fitnesshouse.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fitnesshouse.api.documents.Feedback;

public interface FeedbackRepository extends MongoRepository<Feedback, String>{

}
