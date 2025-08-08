package com.nishant.interviewPrep.interviewPrepApp.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Document(collection = "User")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    ObjectId id;
    @NonNull
    private String userName;
    @NonNull
    private String password;
    @NonNull
    private List<String> role;
    private String email;

    private String field;
    private String level;

    List<Question> questions = new ArrayList<>();
}