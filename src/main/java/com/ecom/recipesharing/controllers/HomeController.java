package com.ecom.recipesharing.controllers;

import com.ecom.recipesharing.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/home")
    public  String homeController(){
        return "setup working ";
    }

}
