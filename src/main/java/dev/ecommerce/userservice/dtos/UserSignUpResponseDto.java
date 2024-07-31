package dev.ecommerce.userservice.dtos;

import dev.ecommerce.userservice.models.BaseModel;
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
    private String email;
    private List<Role> roles;
    private Long id;
    private Date signUpDate;
    private Date updatedDate;
}
