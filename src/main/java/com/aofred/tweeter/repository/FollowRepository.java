package com.aofred.tweeter.repository;

import com.aofred.tweeter.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
}
