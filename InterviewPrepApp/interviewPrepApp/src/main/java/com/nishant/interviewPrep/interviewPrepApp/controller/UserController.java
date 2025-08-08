package com.nishant.interviewPrep.interviewPrepApp.controller;


import com.nishant.interviewPrep.interviewPrepApp.dto.PrepReq;
import com.nishant.interviewPrep.interviewPrepApp.entity.User;
import com.nishant.interviewPrep.interviewPrepApp.repository.UserRepository;
import com.nishant.interviewPrep.interviewPrepApp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@PreAuthorize("hasRole('user')")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @PostMapping("/health")
    public String chackHealth(@RequestBody String text){
        return text;
    }

    @PostMapping("/Preparing-for")
    public ResponseEntity<?> prep(@RequestParam ObjectId userId, @RequestBody PrepReq prepReq){
        String field = prepReq.getField();
        String level = prepReq.getLevel();
        try {
            User user = userRepository.findById(userId).get();
            if(field == null)
                user.setField("no");
            if(level == null)
                user.setLevel("no");
            userService.saveField(userId, field, level);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.warn("Exception in getting user");
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
