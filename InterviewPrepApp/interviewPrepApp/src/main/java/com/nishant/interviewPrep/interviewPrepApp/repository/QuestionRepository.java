package com.nishant.interviewPrep.interviewPrepApp.repository;

import com.nishant.interviewPrep.interviewPrepApp.entity.Question;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface QuestionRepository extends MongoRepository<Question, String> {
    List<Question> findByUserId(ObjectId userId);
}
