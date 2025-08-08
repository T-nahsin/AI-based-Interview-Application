package com.nishant.interviewPrep.interviewPrepApp.service;


import com.nishant.interviewPrep.interviewPrepApp.entity.Question;
import com.nishant.interviewPrep.interviewPrepApp.entity.User;
import com.nishant.interviewPrep.interviewPrepApp.repository.QuestionRepository;
import com.nishant.interviewPrep.interviewPrepApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class QuestionService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    QuestionRepository questionRepository;

    public List<String> extractQuestions(String questions) {
        List<String> ques = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\*\\*\\d+\\.\\s(.+?)\\*\\*");
        Matcher matcher = pattern.matcher(questions);

        while (matcher.find()) {
            ques.add(matcher.group(1).trim());
        }
        return ques;
    }
    public void saveQuestions(String questions) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserName(username);

        List<String>ques = extractQuestions(questions);
        int i = 0;
        for(String s: ques) {
            Question question = new Question();
            question.setId(username+i);
            i++;
            question.setUserId(user.getId());
            question.setText(s);
            question.setCreatedAt(LocalDateTime.now());
            questionRepository.save(question);
            user.getQuestions().add(question);
            userRepository.save(user);
        }
    }
}
