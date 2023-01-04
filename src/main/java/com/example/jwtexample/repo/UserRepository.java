package com.example.jwtexample.repo;

import com.example.jwtexample.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Integer> {

    Optional<Users>findByEmail(String email);
}
