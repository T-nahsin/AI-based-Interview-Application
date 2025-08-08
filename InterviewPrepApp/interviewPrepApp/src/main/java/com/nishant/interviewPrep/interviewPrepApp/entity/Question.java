package com.nishant.interviewPrep.interviewPrepApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    String id;
    private ObjectId userId;
    private String text;
    private String answerId;
    private LocalDateTime createdAt;
}
