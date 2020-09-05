package com.v5ba.service.impl;

import com.v5ba.dao.UserRepository;
import com.v5ba.entity.User;
import com.v5ba.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save() {
        User user = new User();
        user.setAge(30);
        user.setName("张三");
        userRepository.save(user);
    }

    @Override
    public Iterable<User> findAll() {

        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findByName(String name) {
        Pageable pageable = PageRequest.of(0, 10);
        return userRepository.findByName(name, pageable);
    }
}
