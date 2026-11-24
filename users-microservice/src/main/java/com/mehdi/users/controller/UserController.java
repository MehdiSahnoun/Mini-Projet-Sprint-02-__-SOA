package com.mehdi.users.controller;

import com.mehdi.users.entities.User;
import com.mehdi.users.exception.EmailAlreadyExistsException;
import com.mehdi.users.exception.ExpiredTokenException;
import com.mehdi.users.exception.InvalidTokenException;
import com.mehdi.users.register.RegistationRequest;
import com.mehdi.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody RegistationRequest request) {
        return userService.registerUser(request);
    }

    @GetMapping("/verifyEmail/{token}")
    public User verifyEmail(@PathVariable("token") String token) {
        return userService.validateToken(token);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleEmailAlreadyExists(
            EmailAlreadyExistsException exception) {
        Map<String, Object> data = new HashMap<>();
        data.put("errorCause", "email_exists");
        data.put("message", exception.getMessage());
        data.put("errorCode", "USER_EMAIL_ALREADY_EXISTS");
        data.put("timestamp", LocalDateTime.now());
        return ResponseEntity.badRequest().body(data);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidToken(
            InvalidTokenException exception) {
        Map<String, Object> data = new HashMap<>();
        data.put("errorCause", "invalid_token");
        data.put("message", exception.getMessage());
        data.put("errorCode", "INVALID_TOKEN");
        data.put("timestamp", LocalDateTime.now());
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ExpiredTokenException.class)
    public ResponseEntity<Map<String, Object>> handleExpiredToken(
            ExpiredTokenException exception) {
        Map<String, Object> data = new HashMap<>();
        data.put("errorCause", "expired_token");
        data.put("message", exception.getMessage());
        data.put("errorCode", "EXPIRED_TOKEN");
        data.put("timestamp", LocalDateTime.now());
        return ResponseEntity.badRequest().body(data);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(
            Exception exception) {
        Map<String, Object> data = new HashMap<>();
        data.put("errorCause", "internal_error");
        data.put("message", exception.getMessage());
        data.put("errorCode", "INTERNAL_SERVER_ERROR");
        data.put("timestamp", LocalDateTime.now());
        return ResponseEntity.internalServerError().body(data);
    }
}