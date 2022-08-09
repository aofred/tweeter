package com.aofred.tweeter.repository;

import com.aofred.tweeter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
