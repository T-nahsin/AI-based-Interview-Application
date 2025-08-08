package com.nishant.interviewPrep.interviewPrepApp.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasRole('admin')")
@RestController
@RequestMapping("/admin ")
@Slf4j
public class AdminController {

    @GetMapping("/Health-check")
    public String healthCheck()  {
        try{
        return "Ok for admin";
        }catch(Exception e ){
            log.error("Exception : {}", String.valueOf(e));
        }
        return "Error caused";
    }
}
