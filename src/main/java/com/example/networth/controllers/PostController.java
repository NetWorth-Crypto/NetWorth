package com.example.networth.controllers;

import com.example.networth.models.Post;
import com.example.networth.models.User;
import com.example.networth.repositories.PostRepository;
import com.example.networth.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    private PostRepository postDao;
    private UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/testpost")
    public String testPost(Model model){
        model.addAttribute("post", new Post());
        return "TestTemplates/PostCrud";
    }

    @PostMapping("/testpost")
    public String testPost1(@ModelAttribute Post post){
        User user = userDao.getReferenceById(1L);

        post.setUser(user);
//        System.out.println(post.getUser().getFirstName());
//        System.out.println(post.getTitle());
//        System.out.println(post.getDescription());
        postDao.save(post);
        return "TestTemplates/PostCrud";
    }
}
