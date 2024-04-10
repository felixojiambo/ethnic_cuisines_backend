package com.ecom.recipesharing.controllers;
import com.ecom.recipesharing.models.User;
import com.ecom.recipesharing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")
public class UserController {
   @Autowired
    private UserService userService;
   @GetMapping("/profile")
   private  User findUserByJwt(@RequestHeader("Authorization") String jwt) throws Exception {
       return userService.findUserByJwt(jwt);
   }
}

