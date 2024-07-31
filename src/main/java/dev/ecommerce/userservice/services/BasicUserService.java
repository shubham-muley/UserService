package dev.ecommerce.userservice.services;

import dev.ecommerce.userservice.models.Role;
import dev.ecommerce.userservice.models.User;
import dev.ecommerce.userservice.repositories.UserMySqlRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BasicUserService implements UserService {

    public UserMySqlRepository userMySqlRepository;
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    public BasicUserService(UserMySqlRepository userMySqlRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userMySqlRepository = userMySqlRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User createUser(String email, String hashedPassword, List<String> roleNames) throws Exception {
        Optional<User> user = userMySqlRepository.findByEmail(email);
        if (user.isPresent()) {
            // TODO: Add specific exception
            throw new Exception();
        }
        List<Role> roles = new ArrayList<>();
        for(String roleName: roleNames) {
            roles.add(new Role(roleName));
        }
        User newUser = new User(email, bCryptPasswordEncoder.encode(hashedPassword), roles);
        return userMySqlRepository.save(newUser);
    }
}
