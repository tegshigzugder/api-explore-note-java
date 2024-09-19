package com.tegshigzugder.explorenote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tegshigzugder.explorenote.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}