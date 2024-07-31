package dev.ecommerce.userservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseModel{
    private String email;
    private String hashedPassword;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Role> roles;
}
