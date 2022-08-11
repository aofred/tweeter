package com.aofred.tweeter.repository;

import com.aofred.tweeter.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
