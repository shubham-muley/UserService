package dev.ecommerce.userservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserSignUpRequestDto {
    private String email;
    private String password;
    private List<String> roleNames;
}
