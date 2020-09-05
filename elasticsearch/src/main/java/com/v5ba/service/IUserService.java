package com.v5ba.service;

import com.v5ba.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService {
    Iterable<User> findAll();
    void save();
    User findById(String id);
    List<User> findByName(String name);
}
