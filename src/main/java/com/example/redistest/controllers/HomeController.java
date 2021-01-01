package com.example.redistest.controllers;

import com.example.redistest.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.PostConstruct;

@Controller
public class HomeController {

    @Qualifier("reactiveRedisTemplate")
    @Autowired
    ReactiveRedisTemplate redisTemplate;

    @GetMapping("/")
    public String testPage() {

        redisTemplate.listenToChannel("channel1", "channel2").doOnNext(msg -> {
            System.out.println("msg = " + msg);
        }).subscribe();
        return "home";
    }

}
