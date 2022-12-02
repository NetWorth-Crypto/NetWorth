package com.example.networth.controllers;

import com.example.networth.models.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class UserController {


    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        System.out.println("reached");
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        System.out.println("reached");

        return "redirect:/login";
    }


    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("user", new User());
        System.out.println("reached");
        return "users/login";
    }

    @PostMapping("/login")
    public String LoginUser(@ModelAttribute User user){
        System.out.println("reached");

        return "redirect:/landing";
    }



}





