package com.ecom.recipesharing.controllers;

import com.ecom.recipesharing.models.User;
import com.ecom.recipesharing.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public  User createUser(@RequestBody User user) throws Exception {
        User isExist = userRepository.findByEmail(user.getEmail());
        if (isExist != null) {
            throw new Exception("User not found with email " + user.getEmail());

        }return userRepository.save(user);
    }
        @DeleteMapping("/delete/{userId}")
        public String deleteUser (@PathVariable Long userId) throws Exception {
            userRepository.deleteById(userId);
            return "User deleted successfully";
        }
    @GetMapping("/get}")
    public List<User> getAllUses () throws Exception {
      List<User> users=userRepository.findAll();
        return users;
    }
    }
//    public User findByEmail(String email) throws Exception {
//        User user=userRepository.findByEmail(email);
//        if(user==null){
//throw new Exception("User not found with email "+email);
//        }
//        return user;
//    }

