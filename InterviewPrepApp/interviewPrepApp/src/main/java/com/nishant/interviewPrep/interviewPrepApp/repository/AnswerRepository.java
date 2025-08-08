package com.nishant.interviewPrep.interviewPrepApp.repository;

import com.nishant.interviewPrep.interviewPrepApp.entity.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnswerRepository extends MongoRepository<Answer, String> {

}
