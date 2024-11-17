package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(Long username);

	org.springframework.security.core.userdetails.User findByUsername(String username);
}