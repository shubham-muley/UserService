package dev.ecommerce.userservice.advice;

import dev.ecommerce.userservice.dtos.ErrorDto;
import dev.ecommerce.userservice.exceptions.UserExistsException;
import dev.ecommerce.userservice.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<ErrorDto> userExistsExceptionHandler() {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorMessage("User Already Exists, Please Login");
        return new ResponseEntity<>(errorDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDto> userNotFoundExceptionHandler() {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorMessage("User not found, Please signup");
        return new ResponseEntity<>(errorDto, HttpStatus.CONFLICT);
    }
}
