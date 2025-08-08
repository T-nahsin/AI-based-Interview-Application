package com.nishant.interviewPrep.interviewPrepApp.controller;

import com.nishant.interviewPrep.interviewPrepApp.dto.UserDto;
import com.nishant.interviewPrep.interviewPrepApp.entity.User;
import com.nishant.interviewPrep.interviewPrepApp.service.UserService;
import com.nishant.interviewPrep.interviewPrepApp.utilis.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    UserService userService;


    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        user.setEmail(userDto.getEmail());
        user.setLevel(userDto.getLevel());
        user.setField(userDto.getField());
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto){
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
            String token = jwtUtil.generateToken(user);
            return new ResponseEntity<>(token, HttpStatus.FOUND);
        }catch(Exception e) {
            log.error("not authenticated due to exception{}", String.valueOf(e));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
