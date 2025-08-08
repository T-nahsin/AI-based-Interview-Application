package com.nishant.interviewPrep.interviewPrepApp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "huggingface.api")
@Getter
@Setter
public class HuggingFaceProperties {
    private String url;     // maps to huggingface.api.url
    private String token;   // maps to huggingface.api.token
}
