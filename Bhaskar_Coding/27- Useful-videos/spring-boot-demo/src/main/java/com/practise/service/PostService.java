package com.practise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PostService {

    private ContentStrategy strategy;

    @Autowired
    public PostService(@Qualifier("videoContentStrategy") ContentStrategy strategy) {
        this.strategy = strategy;
    }

    public void post(){
        strategy.contentPost();;
    }
}

