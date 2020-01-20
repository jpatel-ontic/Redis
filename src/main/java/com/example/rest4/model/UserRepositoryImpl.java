package com.example.rest4.model;

import org.redisson.api.RMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private RMap<String, User> map;

    @Override
    public void save(User user) {

        map.put(user.getId(), user);
    }

    @Override
    public Collection<User> findAll() {
        return map.values();

    }


    @Override
    public User findById(String id) {
        return (User) map.get(id);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(String id) {
        map.remove(id);
    }
}
