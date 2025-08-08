package com.nishant.interviewPrep.interviewPrepApp.controller;

import com.nishant.interviewPrep.interviewPrepApp.service.QuestionGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ques")
public class QuestionController {

    @Autowired
    QuestionGeneratorService questionGeneratorService;



    @GetMapping("/generate")
    public ResponseEntity<?> generateQuestions(
            @RequestParam String field,
            @RequestParam(defaultValue = "Intermediate") String level) {


        return new ResponseEntity<>(questionGeneratorService.generateInterviewQuestion(field , level), HttpStatus.OK);
    }
}
