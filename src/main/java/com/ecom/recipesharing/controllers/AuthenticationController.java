package com.ecom.recipesharing.controllers;

import com.ecom.recipesharing.config.JwtProvider;
import com.ecom.recipesharing.dtos.AuthenticationResponse;
import com.ecom.recipesharing.dtos.LoginRequest;
import com.ecom.recipesharing.models.User;
import com.ecom.recipesharing.repositories.UserRepository;
import com.ecom.recipesharing.services.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/signup")
    public AuthenticationResponse createUser(@RequestBody User user)throws Exception{
        String email=user.getEmail();
        String password= user.getPassword();
        String fullName= user.getFullName();
        User isExistEmail=userRepository.findByEmail(email);
        if(isExistEmail!=null){
            throw new Exception("User with email exists,try new email ");
        }User createdUser=new User();
        createdUser.setEmail(email);
        createdUser.setPassword(passwordEncoder.encode(password));
        createdUser.setFullName(fullName);
        User savedUser=userRepository.save(createdUser);
        Authentication authentication=new UsernamePasswordAuthenticationToken(email,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token=jwtProvider.generateToken(authentication);
        AuthenticationResponse res=new AuthenticationResponse();
        res.setJwt(token);
        res.setMessage("Successfully registered");
        return  res;
    }
    @PostMapping("/login")
    public  AuthenticationResponse signinHandler(@RequestBody LoginRequest loginRequest){
        String username=loginRequest.getEmail();
        String password=loginRequest.getPassword();
        Authentication authentication=authenticate(username,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token=jwtProvider.generateToken(authentication);
        AuthenticationResponse res=new AuthenticationResponse();
        res.setJwt(token);
        res.setMessage("Successfully registered");
        return  res;
    }

    private Authentication authenticate(String username, String password) {
        UserDetails userDetails= customUserDetails.loadUserByUsername(username);
        if(userDetails==null){
            throw  new BadCredentialsException("user not found");
        }
        if(!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("invalid password");
        }
return  new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}
