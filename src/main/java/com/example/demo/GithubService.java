package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GithubService {

    @Autowired
    GithubDownstreamService githubDownstreamService;

    @Autowired
    GithubMapper githubMapper;


    public Flux<String> getReposForUser(String username) {
        return githubDownstreamService.getAllRepos(username)
                .map(githubMapper::mapRepoToNames);
    }
}
