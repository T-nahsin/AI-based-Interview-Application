package com.nishant.interviewPrep.interviewPrepApp.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionGeneratorService {

    @Autowired
    ChatModel chatModel;

    @Autowired
    QuestionService questionService;

    public String generateInterviewQuestion(String field, String level) {
      ChatResponse response = chatModel.call(
                new Prompt(
                        "Generate  5 questions for "+field+" of "+level +" and don't generate the answers.",
                        OpenAiChatOptions.builder()
                                .model("llama3-70b-8192")
                                .temperature(0.4)
                                .build()
                ));

        String result = response.getResult().getOutput().getText();
//        String result = "Here are 5 Java questions for beginners:\n" +
//                "\n" +
//                "**1. What is the purpose of the `main` method in a Java program?**\n" +
//                "\n" +
//                "**2. How do you declare and initialize a variable of type `String` in Java? For example, a variable to store a person's name.**\n" +
//                "\n" +
//                "**3. What is the difference between the `==` operator and the `.equals()` method when comparing two strings in Java?**\n" +
//                "\n" +
//                "**4. Write a Java statement to print \"Hello, World!\" to the console using the `System.out` class.**\n" +
//                "\n" +
//                "**5. What is the purpose of the `public` access modifier in a Java class declaration, and how does it affect the visibility of the class?**";
        questionService.saveQuestions(result);

        return result;
    }
}