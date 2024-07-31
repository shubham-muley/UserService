package dev.ecommerce.userservice.services;

import dev.ecommerce.userservice.models.User;

import java.util.List;

public interface UserService {
    User createUser(String email, String hashedPassword, List<String> roleName);
}
