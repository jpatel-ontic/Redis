package com.example.rest4.model;

import org.redisson.api.RMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private RMap<String, User> redisTemplate;

    @Override
    public void save(User user) {
        redisTemplate.put(user.getId(), user);
    }

    @Override
    public Collection<User> findAll() {
        return redisTemplate.values();

    }


    @Override
    public User findById(String id) {
        return (User) redisTemplate.get(id);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(String id) {
        redisTemplate.remove(id);
    }
}
