package com.trabalhobd.backend.repository;

import com.trabalhobd.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
