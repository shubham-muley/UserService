package dev.ecommerce.userservice.controllers;

import dev.ecommerce.userservice.services.BasicUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
     public BasicUserService basicUserService;

     public UserController(BasicUserService basicUserService) {
         this.basicUserService = basicUserService;
     }
}
