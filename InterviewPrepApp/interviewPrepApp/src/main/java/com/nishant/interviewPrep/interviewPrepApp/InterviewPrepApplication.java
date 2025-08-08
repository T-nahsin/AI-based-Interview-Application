package com.nishant.interviewPrep.interviewPrepApp;

import com.nishant.interviewPrep.interviewPrepApp.config.HuggingFaceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableConfigurationProperties(HuggingFaceProperties.class)
public class InterviewPrepApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewPrepApplication.class, args);
	}

}
