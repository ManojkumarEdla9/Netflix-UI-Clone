package com.example.healthcare.repository;

import com.example.healthcare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByMobile(String mobile);
}
