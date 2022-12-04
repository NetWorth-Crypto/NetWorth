package com.example.networth.controllers;

import com.example.networth.models.User;
import com.example.networth.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        System.out.println("reached");
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        userService.saveUser(user);


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





