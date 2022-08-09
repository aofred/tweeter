package com.aofred.tweeter.service;

import com.aofred.tweeter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    /*
    public User addUser(String name, String handle) {
        User user = new User(name, handle, new ArrayList<>());
        return userRepository.save(user);
    }
    */
}
