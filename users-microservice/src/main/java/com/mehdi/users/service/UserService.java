package com.mehdi.users.service;

import com.mehdi.users.entities.Role;
import com.mehdi.users.entities.User;
import com.mehdi.users.register.RegistationRequest;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername(String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);
    List<User> findAllUsers();
    User registerUser(RegistationRequest request);
    User validateToken(String code);
    void sendEmailUser(User u, String code);
    String generateCode();
}