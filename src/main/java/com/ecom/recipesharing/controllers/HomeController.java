package com.ecom.recipesharing.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
public class HomeController {
    @GetMapping("/home")
    public  String homeController(){
        return "setup working ";
    }
}
