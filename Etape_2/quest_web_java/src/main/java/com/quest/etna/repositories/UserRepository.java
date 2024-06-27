package com.quest.etna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quest.etna.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findByUsernameIgnoreCase(String username); // Custom query method for case-insensitive search
}
