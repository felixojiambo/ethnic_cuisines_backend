package com.ecom.recipesharing.controllers;

import com.ecom.recipesharing.config.JwtProvider;
import com.ecom.recipesharing.dtos.AuthenticationResponse;
import com.ecom.recipesharing.models.User;
import com.ecom.recipesharing.repositories.UserRepository;
import com.ecom.recipesharing.services.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomUserDetailsService customUserDetails;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public AuthenticationResponse createUser(@RequestBody User user)throws Exception{
        String email=user.getEmail();
        String password= user.getPassword();
        String fullName= user.getFullName();
        User isExistEmail=userRepository.findByEmail(email);
        if(isExistEmail!=null){
            throw new Exception("User with email exists,try new email ");
        }User createdUser=new User();
        createdUser.setEmail(email);
        createdUser.setPassword(password);
        createdUser.setFullName(fullName);
        return  null;
    }
}
