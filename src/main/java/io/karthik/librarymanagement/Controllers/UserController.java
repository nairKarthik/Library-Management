package io.karthik.librarymanagement.Controllers;

import io.karthik.librarymanagement.Models.Users;
import io.karthik.librarymanagement.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class UserController {
    public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        LOGGER.info("getAllUsers called!!");
        List<Users> users = new ArrayList<>();
        try {
            users = userRepository.findAll();
            if (users.size() == 0) {
                LOGGER.severe("Mo user found!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @GetMapping("/users/{id}")
    public Optional<Users> getUserById(@PathVariable int id) {
        Optional<Users> user = userRepository.findById(id);
        return user;
    }

    @PostMapping("/users")
    public void createUser(@RequestBody Users user) {
        userRepository.save(user);
    }
}
