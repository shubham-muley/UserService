package dev.ecommerce.userservice.controllers;

import dev.ecommerce.userservice.dtos.TokenResponseDto;
import dev.ecommerce.userservice.dtos.UserLoginRequestDto;
import dev.ecommerce.userservice.dtos.UserSignUpRequestDto;
import dev.ecommerce.userservice.dtos.UserSignUpResponseDto;
import dev.ecommerce.userservice.exceptions.UserNotFoundException;
import dev.ecommerce.userservice.models.Token;
import dev.ecommerce.userservice.models.User;
import dev.ecommerce.userservice.repositories.UserMySqlRepository;
import dev.ecommerce.userservice.services.BasicUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
     public BasicUserService basicUserService;

     public UserController(BasicUserService basicUserService, UserMySqlRepository userMySqlRepository) {
         this.basicUserService = basicUserService;
     }

     @PostMapping("/signup")
     public ResponseEntity<UserSignUpResponseDto> userSignUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto) throws Exception {
          User user = basicUserService.createUser(
                  userSignUpRequestDto.getEmail(),
                  userSignUpRequestDto.getPassword(),
                  userSignUpRequestDto.getRoleNames());


          UserSignUpResponseDto userSignUpResponseDto =  UserSignUpResponseDto.builder()
                  .email(user.getEmail())
                  .id(user.getId())
                  .signUpDate(user.getCreatedAt())
                  .updatedDate(user.getUpdatedAt())
                  .roles(user.getRoles())
                  .build();
          return new ResponseEntity<>(userSignUpResponseDto, HttpStatus.OK);
     }

     @PostMapping("/login")
     public ResponseEntity<TokenResponseDto> userLogin(@RequestBody UserLoginRequestDto userLoginRequestDto) throws UserNotFoundException {
           Token token = basicUserService.loginUser(
                   userLoginRequestDto.getEmail(),
                   userLoginRequestDto.getPassword()
           );

           User user = token.getUser();

           UserSignUpResponseDto userSignUpResponseDto = UserSignUpResponseDto
                   .builder()
                   .id(user.getId())
                   .email(user.getEmail())
                   .signUpDate(user.getCreatedAt())
                   .updatedDate(user.getUpdatedAt())
                   .roles(user.getRoles())
                   .build();

           TokenResponseDto tokenResponseDto = TokenResponseDto.builder()
                 .token(token.getTokenValue())
                 .user(userSignUpResponseDto)
                 .expiryDate(token.getExpiryDate())
                 .build();

           return new ResponseEntity<>(tokenResponseDto, HttpStatus.OK);
     }
}
