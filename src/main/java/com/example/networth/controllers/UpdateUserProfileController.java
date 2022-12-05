package com.example.networth.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class UpdateUserProfileController
{
    @GetMapping("/update-profile")
    public String update()
    {
        return "update-profile";
    }
}
