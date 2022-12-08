package com.example.networth.controllers;


import com.example.networth.models.Post;
import com.example.networth.models.User;
import com.example.networth.repositories.PostRepository;
import com.example.networth.repositories.UserRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {
    private PostRepository postDao;
    private UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }
    
        @GetMapping("/search")
    public String getSearch()
    {
        return "post/search";
    }
    @PostMapping("/search")
    public String postSearch(@RequestParam(value = "searchValue")String searchValue) {
        System.out.println(searchValue);
        return "redirect:profile";
    }

    
    @GetMapping("/testpost")
    public String testPost(Model model){
        Post post = postDao.getReferenceById(3L);
        model.addAttribute("post", post);
        return "TestTemplates/PostCrud";
    }

    @PostMapping("/create/testpost")
    public String testPost1(@ModelAttribute("post") Post post){

//        System.out.println(post.getUser().getFirstName());
//        System.out.println(post.getTitle());
//        System.out.println(post.getDescription());
        postDao.save(post);
        return "TestTemplates/PostCrud";
    }

    @PostMapping("/like/testpost")
    public String likeTestPost(@ModelAttribute Post post){
        Post likedPost = postDao.getReferenceById(post.getId());

        int likes = likedPost.getLikes()+1;
        likedPost.setLikes(likes);
        System.out.println(likedPost.getLikes());


        postDao.save(likedPost);

        return "TestTemplates/PostCrud";
    }

    @PostMapping("/dislike/testpost")
    public String dislikeTestPost(@ModelAttribute Post post){
        Post dislikedPost = postDao.getReferenceById(post.getId());

        int dislikes = dislikedPost.getDislikes()+1;
        dislikedPost.setDislikes(dislikes);
        System.out.println(dislikedPost.getLikes());

        postDao.save(dislikedPost);

        return "TestTemplates/PostCrud";
    }
}
