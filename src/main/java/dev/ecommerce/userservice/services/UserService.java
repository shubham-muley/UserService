package dev.ecommerce.userservice.services;

import dev.ecommerce.userservice.exceptions.UserExistsException;
import dev.ecommerce.userservice.exceptions.UserNotFoundException;
import dev.ecommerce.userservice.models.Token;
import dev.ecommerce.userservice.models.User;

import java.util.List;

public interface UserService {
    User createUser(String email, String hashedPassword, List<String> roleName) throws UserExistsException;
    Token loginUser(String email, String password) throws UserNotFoundException;
}