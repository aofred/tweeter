package com.aofred.tweeter.repository;

import com.aofred.tweeter.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
