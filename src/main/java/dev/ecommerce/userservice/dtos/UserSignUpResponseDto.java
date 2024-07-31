package dev.ecommerce.userservice.dtos;

import dev.ecommerce.userservice.models.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class UserSignUpResponseDto{
    private Long id;
    private String email;
    private List<Role> roles;
    private Date signUpDate;
    private Date updatedDate;
}
