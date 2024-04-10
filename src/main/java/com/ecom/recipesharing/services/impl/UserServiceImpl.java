package com.ecom.recipesharing.services.impl;

import com.ecom.recipesharing.config.JwtProvider;
import com.ecom.recipesharing.models.User;
import com.ecom.recipesharing.repositories.UserRepository;
import com.ecom.recipesharing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProvider jwtProvider;
    @Override
    public User findUserById(Long userId) throws Exception {
        Optional<User> opt=userRepository.findById(userId);
        if(opt.isPresent()){
            return  opt.get();
        }throw  new Exception("User not found "+userId);
    }

    @Override
    public User findUserByJwt(String jwt) throws Exception {
        String email=jwtProvider.getEmailFromJwtToken(jwt);
        if(email==null){
            throw new Exception("please provide a valid jwt token...");
        }
        User user=userRepository.findByEmail(email);
        if(user==null){
            throw new Exception("user not found with email...");
        }
        return user;
    }
}
