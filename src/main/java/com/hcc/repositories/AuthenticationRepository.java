package com.hcc.repositories;

import com.hcc.entities.AuthenticationRequest;
import com.hcc.entities.Hello;
import com.hcc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// this is an example repository feel free to delete this once you have created your own.
public interface AuthenticationRepository extends JpaRepository<Hello, Long> {
    Optional<AuthenticationRequest> authenticate(String username, String password);
}
