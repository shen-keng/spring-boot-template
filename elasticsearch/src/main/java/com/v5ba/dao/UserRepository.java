package com.v5ba.dao;

import com.v5ba.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, String> {
    List<User> findByName(String name, Pageable pageable);
    @Query("")
    void findBy();
}
