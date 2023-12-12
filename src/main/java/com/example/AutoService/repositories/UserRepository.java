package com.example.AutoService.repositories;

import com.example.AutoService.models.Mechanic;
import com.example.AutoService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
