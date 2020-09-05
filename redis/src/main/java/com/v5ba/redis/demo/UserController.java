package com.v5ba.redis.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
public class UserController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @GetMapping("get")
    public String hello(String key){
        String name = (String)redisTemplate.opsForValue().get(key);
        System.out.println(key+":"+name);
        return "ok";
    }

    @GetMapping("set")
    public String set(String key, String val){
        redisTemplate.opsForValue().set(key, val, Duration.ofMinutes(1));
        return "ok";
    }
}
