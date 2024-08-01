package dev.ecommerce.userservice.services;

import dev.ecommerce.userservice.models.Role;
import dev.ecommerce.userservice.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    public RoleRepository roleRepository;
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRoleByName(String roleName) {
        Optional<Role> role = roleRepository.findByName(roleName);
        return role.orElse(null);
    }
}
