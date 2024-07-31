package dev.ecommerce.userservice.models;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@Entity(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseModel {
    private String name;
}
