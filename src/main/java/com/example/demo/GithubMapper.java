package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GithubMapper {


    public String mapRepoToNames(Map<String, Object> repo) {
        return (String)repo.get("name");
    }
}
