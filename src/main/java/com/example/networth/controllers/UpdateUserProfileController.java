package com.example.networth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class UpdateUserProfileController
{
    @GetMapping("/update-profile")
    public String update()
    {
        return "update-profile";
    }
}
