package dev.ecommerce.userservice.services;

import dev.ecommerce.userservice.dtos.TokenResponseDto;
import dev.ecommerce.userservice.exceptions.UserExistsException;
import dev.ecommerce.userservice.exceptions.UserNotFoundException;
import dev.ecommerce.userservice.models.Role;
import dev.ecommerce.userservice.models.Token;
import dev.ecommerce.userservice.models.User;
import dev.ecommerce.userservice.repositories.TokenRepository;
import dev.ecommerce.userservice.repositories.UserMySqlRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BasicUserService implements UserService {

    public UserMySqlRepository userMySqlRepository;
    public BCryptPasswordEncoder bCryptPasswordEncoder;
    public TokenRepository tokenRepository;
    public TokenService tokenService;

    public BasicUserService(UserMySqlRepository userMySqlRepository,
                            BCryptPasswordEncoder bCryptPasswordEncoder,
                            TokenRepository tokenRepository,
                            TokenService tokenService) {
        this.userMySqlRepository = userMySqlRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenRepository = tokenRepository;
        this.tokenService = tokenService;
    }

    @Override
    public User createUser(String email, String hashedPassword, List<String> roleNames) throws UserExistsException{
        Optional<User> user = userMySqlRepository.findByEmail(email);
        if (user.isPresent()) {
            throw new UserExistsException();
        }
        List<Role> roles = new ArrayList<>();
        for(String roleName: roleNames) {
            roles.add(new Role(roleName));
        }
        User newUser = new User(email, bCryptPasswordEncoder.encode(hashedPassword), roles);
        return userMySqlRepository.save(newUser);
    }

    @Override
    public Token loginUser(String email, String password) throws UserNotFoundException {
        Optional<User> user = userMySqlRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }
        Token token = tokenService.createToken(user.get());
        return token;
    }
}
