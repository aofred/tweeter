package com.aofred.tweeter.service;

import com.aofred.tweeter.model.Post;
import com.aofred.tweeter.model.User;
import com.aofred.tweeter.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    private List<Post> getPostsByUser(User user) {
         return postRepository.findAll()
                 .stream()
                .filter(p -> p.getAuthor() == user)
                .collect(Collectors.toList());
    }

    public List<Post> getPostsByUsers(List<User> users, Pageable pageable) {
        return postRepository.findAll(pageable)
                .stream()
                .filter(p -> users.contains(p.getAuthor()))
                .collect(Collectors.toList());
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }
}
