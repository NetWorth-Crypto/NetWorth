package com.example.networth.controllers;

import com.example.networth.models.Follower;
import com.example.networth.models.Following;
import com.example.networth.models.Post;
import com.example.networth.repositories.FollowerRepository;
import com.example.networth.repositories.FollowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NetworkController {

    @Autowired
    private FollowerRepository followerRepositoryDao;

    @Autowired
    private FollowingRepository followingRepositoryDao;

    @GetMapping("/followers")
    public String testFollower(Model model){
        model.addAttribute("follower", new Follower());
        return "users/followers";
    }

    @GetMapping("/following")
    public String testFollowing(Model model){
        model.addAttribute("following", new Following());
        return "users/following";
    }


}
