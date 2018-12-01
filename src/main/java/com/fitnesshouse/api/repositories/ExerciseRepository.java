package com.fitnesshouse.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fitnesshouse.api.documents.Exercise;
import com.fitnesshouse.api.enums.MuscleGroupEnum;

@Repository
public interface ExerciseRepository extends MongoRepository<Exercise, String> {
	
	List<Exercise> findByMuscleGroupAndTitleLike(MuscleGroupEnum muscleGroup, String name);

	List<Exercise> findByMuscleGroupLikeIgnoreCase(MuscleGroupEnum muscleGroup);
	
	//void saveAll(List<Exercise> cars);

}
