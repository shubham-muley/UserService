package dev.ecommerce.userservice.repositories;

import dev.ecommerce.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;

public interface UserMySqlRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User save(User user);
}