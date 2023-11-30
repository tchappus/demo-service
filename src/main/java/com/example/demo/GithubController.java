package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class GithubController {

    @Autowired
    GithubService githubService;

    @GetMapping(value = "/repos", produces = "application/json")
    public ResponseEntity<Mono<List<String>>> getAllRepos(@RequestParam String username) {
        return ResponseEntity.ok(githubService.getReposForUser(username).collect(Collectors.toList()));
    }
}
