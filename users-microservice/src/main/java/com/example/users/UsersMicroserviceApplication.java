package com.example.users;

import com.mehdi.users.entities.Role;
import com.mehdi.users.entities.User;
import com.mehdi.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.example.users", "com.mehdi.users"})
@EntityScan({"com.mehdi.users.entities"})
@EnableJpaRepositories({"com.mehdi.users.repositories"})
public class UsersMicroserviceApplication {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UsersMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner init_users() {
        return args -> {
            // ajouter les rôles
            userService.addRole(new Role(null, "ADMIN"));
            userService.addRole(new Role(null, "USER"));

            // ajouter les users
            userService.saveUser(new User(null, "admin", "123", true, null));
            userService.saveUser(new User(null, "mehdi", "123", true, null));
            userService.saveUser(new User(null, "mehdi2", "123", true, null));
            userService.saveUser(new User(null, "yassine", "123", true, null));

            // ajouter les rôles aux users
            userService.addRoleToUser("admin", "ADMIN");
            userService.addRoleToUser("admin", "USER");
            userService.addRoleToUser("mehdi", "USER");
            userService.addRoleToUser("mehdi2", "USER");
            userService.addRoleToUser("yassine", "USER");
        };
    }
}