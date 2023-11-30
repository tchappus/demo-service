package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Map;

@Service
public class GithubDownstreamService {
    private static final ParameterizedTypeReference<Map<String, Object>> mapTypeReference = new ParameterizedTypeReference<>() {};

    @Autowired
    WebClient webClient;

    public Flux<Map<String, Object>> getAllRepos(String user, String foo) {
        return webClient.get()
                .uri("/users/{username}/repos", user)
                .retrieve()
                .bodyToFlux(mapTypeReference);
    }
}
