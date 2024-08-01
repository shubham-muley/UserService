package dev.ecommerce.userservice.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class TokenResponseDto {
    private String token;
    private Date expiryDate;
    private UserSignUpResponseDto user;
}
