package com.aofred.tweeter.service;

import com.aofred.tweeter.model.User;
import com.aofred.tweeter.repository.FollowRepository;
import com.aofred.tweeter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FollowRepository followRepository;

    private String getLoggedInUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
    private User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getLoggedInUser() {
        return findByUsername(getLoggedInUsername());
    }

    private List<User> getFollowing() {
        return followRepository.findAll()
                .stream()
                .filter(f -> f.getFollower() == getLoggedInUser())
                .map(f -> f.getFollowee())
                .collect(Collectors.toList());
    }

    public List<User> getUserAndFollowing() {
        List<User> result = new ArrayList<>();
        User user = userRepository.findByUsername(getLoggedInUsername());
        List<User> following = getFollowing();
        result.add(user);
        result.addAll(following);
        return result;
    }
}
