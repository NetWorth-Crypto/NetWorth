package com.example.networth.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class UserController {
    @GetMapping("/login")
    public String index(){
        return "landing";
    }


}
