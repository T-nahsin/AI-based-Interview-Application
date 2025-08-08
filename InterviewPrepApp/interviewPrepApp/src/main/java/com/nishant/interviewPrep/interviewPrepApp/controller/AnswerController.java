package com.nishant.interviewPrep.interviewPrepApp.controller;


import com.nishant.interviewPrep.interviewPrepApp.dto.AnswerDto;
import com.nishant.interviewPrep.interviewPrepApp.entity.Answer;
import com.nishant.interviewPrep.interviewPrepApp.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/ans")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping("/health")
    public String chackHealth(@RequestBody String text){
        return text;
    }

    @PostMapping("/give-answer")
    public ResponseEntity<String> generateAnswer(@RequestBody AnswerDto answerDto, @RequestParam String quesId) {
        Answer answer = new Answer();
        answer.setId(quesId+"Ans");
        answer.setQuestionId(quesId);
        answer.setText(answer.getId());
        answer.setAnsweredAt(LocalDateTime.now());
        String result = "";
        if(answerService.checkValid(answer, quesId))
            result = answerService.getEvaluation(answer, quesId);
        else return new ResponseEntity<>("time out late response", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.FOUND);
    }
}
