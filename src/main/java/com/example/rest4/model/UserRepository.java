package com.example.rest4.model;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface UserRepository {
    void save(User user);

    Collection<User> findAll();

    User findById(String id);

    void update(User user);

    void delete(String id);


}
