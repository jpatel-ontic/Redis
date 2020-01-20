package com.example.rest4.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

/**
 *
 */
@RestController
@RequestMapping("/user")
public class UserResource {
    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User add(@Valid @RequestBody User user) {
        userRepository.save(user);
        return userRepository.findById(user.getId());
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable("id") final String id,
                       @Valid @RequestBody User user) {
        userRepository.update(new User(id, user.getName(), user.getSalary()));
        return userRepository.findById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public User delete(@PathVariable("id") final String id) {
        User user = userRepository.findById(id);
        userRepository.delete(id);
        return user;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<User> all() {
        return userRepository.findAll();
    }

}
