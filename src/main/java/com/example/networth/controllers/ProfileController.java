package com.example.networth.controllers;

import com.example.networth.models.User;
import com.example.networth.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController
{
    private final UserRepository userDao;

    public ProfileController(UserRepository userDao)
    {
        this.userDao = userDao;
    }

    @GetMapping("/profile")
    public String profile(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() == "anonymousUser")
        {
            return "redirect:login";
        }
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("updateProfile", user);
        return "users/profile";
    }

    @GetMapping("/update-profile")
    public String updateProfile(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() == "anonymousUser")
        {
            return "redirect:login";
        }
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("updateProfile", user);

        return "users/update-profile";
    }
    @PostMapping("/update-profile")
    public String updateProfile
            (@RequestParam("username")String username)
//             @RequestParam("firstname") String firstname,
//             @RequestParam("lastname") String lastname,
//             @RequestParam("email") String email,
//             @RequestParam("password") String password)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        user.setUsername(username);
//        user.setFirstName(firstname);
//        user.setLastName(lastname);
//        user.setEmail(email);
//        user.setPassword(password);
        System.out.println(username);
        userDao.save(user);
        System.out.println(user);

        return "redirect:/profile";
    }

    @PostMapping("/delete")
    public String deleteUser()
    {
        return "redirect:/login";
    }
}
