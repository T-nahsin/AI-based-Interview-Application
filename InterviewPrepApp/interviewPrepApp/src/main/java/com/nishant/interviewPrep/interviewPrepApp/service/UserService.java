package com.nishant.interviewPrep.interviewPrepApp.service;

import com.nishant.interviewPrep.interviewPrepApp.entity.User;
import com.nishant.interviewPrep.interviewPrepApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Autowired
    UserRepository userRepository;
     public void saveUser(User user) {
         user.setPassword(passwordEncoder.encode(user.getPassword()));
         userRepository.save(user);
     }

    public void saveField(ObjectId userId, String field, String level) {
        User user = userRepository.findById(userId).get();
        user.setField(field);
        user.setLevel(level);

        userRepository.save(user);
    }
}
