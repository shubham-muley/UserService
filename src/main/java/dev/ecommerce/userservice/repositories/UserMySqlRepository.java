package dev.ecommerce.userservice.repositories;

import dev.ecommerce.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserMySqlRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    User save(User user);
}