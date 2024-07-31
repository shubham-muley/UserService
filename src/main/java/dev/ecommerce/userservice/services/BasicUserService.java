package dev.ecommerce.userservice.services;

import dev.ecommerce.userservice.models.Role;
import dev.ecommerce.userservice.models.User;
import dev.ecommerce.userservice.repositories.UserMySqlRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasicUserService implements UserService {

    public UserMySqlRepository userMySqlRepository;

    public BasicUserService(UserMySqlRepository userMySqlRepository) {
        this.userMySqlRepository = userMySqlRepository;
    }

    @Override
    public User createUser(String email, String hashedPassword, List<String> roleNames) {
        List<Role> roles = new ArrayList<>();
        for(String roleName: roleNames) {
            roles.add(new Role(roleName));
        }
        User user = new User(email, hashedPassword, roles);
        return userMySqlRepository.save(user);
    }
}
