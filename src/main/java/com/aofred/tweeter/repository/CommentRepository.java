package com.aofred.tweeter.repository;

import com.aofred.tweeter.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
