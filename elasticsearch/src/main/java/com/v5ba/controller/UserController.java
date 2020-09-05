package com.v5ba.controller;

import com.v5ba.entity.User;
import com.v5ba.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("add")
    public String add(HttpServletRequest request) {
        userService.save();
        return "ok";
    }
    @GetMapping("all")
    public Iterable<User> list(HttpServletRequest request) {
        return userService.findAll();
    }
    @GetMapping("findById")
    public User findById(HttpServletRequest request, String id) {
        return userService.findById(id);
    }
    @GetMapping("findByName")
    public List<User> findByName(HttpServletRequest request, String name) {
        return userService.findByName(name);
    }
}
