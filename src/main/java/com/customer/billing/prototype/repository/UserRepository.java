package com.customer.billing.prototype.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.customer.billing.prototype.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}

