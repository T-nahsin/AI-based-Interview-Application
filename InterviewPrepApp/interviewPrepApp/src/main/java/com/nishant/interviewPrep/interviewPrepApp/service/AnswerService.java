package com.nishant.interviewPrep.interviewPrepApp.service;


import com.nishant.interviewPrep.interviewPrepApp.entity.Answer;
import com.nishant.interviewPrep.interviewPrepApp.entity.Question;
import com.nishant.interviewPrep.interviewPrepApp.entity.User;
import com.nishant.interviewPrep.interviewPrepApp.repository.AnswerRepository;
import com.nishant.interviewPrep.interviewPrepApp.repository.QuestionRepository;
import com.nishant.interviewPrep.interviewPrepApp.repository.UserRepository;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnswerService {

    @Autowired
    ChatModel chatModel;

    @Autowired
    QuestionRepository questionRepository;


    @Autowired
    UserRepository userRepository;

    @Autowired
    AnswerRepository answerRepository;

    public boolean checkValid(Answer answer , String questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        if(answer.getText().isEmpty())
            throw new RuntimeException("answer is null");


        LocalDateTime deadline = question.getCreatedAt().plusMinutes(30);
        if (LocalDateTime.now().isAfter(deadline)) {
            return false;
        }

        question.setAnswerId(answer.getId());
        questionRepository.save(question);
        answerRepository.save(answer);
        return true;
    }

    public String getEvaluation(Answer answer, String quesId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserName(username);
        String level = user.getLevel();
        Question question = questionRepository.findById(quesId).get();
        ChatResponse response = chatModel.call(
                new Prompt(
                         "Evaluate the answer "+answer.getText()+" for question -"+question.getText()+ " for level "+level+" and also rate it out of 10",
                        OpenAiChatOptions.builder()
                                .model("llama3-70b-8192")
                                .temperature(0.4)
                                .build()
                ));

        return response.getResult().getOutput().getText();
    }
}
