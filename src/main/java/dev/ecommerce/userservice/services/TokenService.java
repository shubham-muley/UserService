package dev.ecommerce.userservice.services;

import dev.ecommerce.userservice.models.Token;
import dev.ecommerce.userservice.models.User;

public interface TokenService {
    public Token createToken(User user);
}
