package dev.ecommerce.userservice.controllers;

import dev.ecommerce.userservice.dtos.UserSignUpRequestDto;
import dev.ecommerce.userservice.dtos.UserSignUpResponseDto;
import dev.ecommerce.userservice.models.User;
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

     public UserController(BasicUserService basicUserService) {
         this.basicUserService = basicUserService;
     }

     @PostMapping("")
     public ResponseEntity<UserSignUpResponseDto> UserSignUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto) throws Exception {
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
}
