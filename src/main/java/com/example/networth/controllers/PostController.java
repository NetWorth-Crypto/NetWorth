package com.example.networth.controllers;


import com.example.networth.models.Post;
import com.example.networth.models.PostDislike;
import com.example.networth.models.PostLike;
import com.example.networth.models.User;
import com.example.networth.repositories.PostDislikeRepository;
import com.example.networth.repositories.PostLikeRepository;
import com.example.networth.repositories.PostRepository;
import com.example.networth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostRepository postDao;

    @Autowired
    private UserRepository userDao;

    @Autowired
    private PostLikeRepository postLikeDao;

    @Autowired
    private PostDislikeRepository postDislikeDao;


    
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
        Post post = postDao.getReferenceById(1L);
        model.addAttribute("post", post);
        return "TestTemplates/PostCrud";
    }

    @PostMapping("/create/testpost")
    public String testPost1(@ModelAttribute("post") Post post,
                            @RequestParam("imgUrl") String imgUrl){
        //Get UserId from logged-in user to create new post
        //Create new post
        //Save new post to database

        System.out.println(post.getTitle());
        System.out.println(post.getDescription());
        System.out.println(imgUrl);

//        postDao.save(post);
        return "TestTemplates/PostCrud";
    }

    @PostMapping("/like/testpost")
    public String likeTestPost(@ModelAttribute Post post){

        Post likedPost = postDao.getReferenceById(post.getId());

        /*Change this to the actual logged in user*/
        User user = userDao.getReferenceById(1L);

        List<PostLike> userLikes = user.getLikes();

        //Check user already like the post
        for(PostLike like: userLikes){
            if(like.getPost().getId() == likedPost.getId()){

                //remove from PostLike table
                user.removeLike(like);
                likedPost.removeLike(like);
                postLikeDao.delete(like);
                System.out.println("like removed");
                //return to page
                return "TestTemplates/PostCrud";
            }
        }

        PostLike postLike = new PostLike(user,likedPost);
        user.addLike(postLike);
        likedPost.addLike(postLike);
        postLikeDao.save(postLike);
        System.out.println("like added");


        return "TestTemplates/PostCrud";
    }

    @PostMapping("/dislike/testpost")
    public String dislikeTestPost(@ModelAttribute Post post){
        Post dislikedPost = postDao.getReferenceById(post.getId());

        /*Change this to the actual logged in user*/
        User user = userDao.getReferenceById(1L);

        List<PostDislike> userDislikes = user.getDislikes();

        //Check user already like the post
        for(PostDislike dislike: userDislikes){
            if(dislike.getPost().getId() == dislikedPost.getId()){

                //remove from PostDislike table
                user.removeDislike(dislike);
                dislikedPost.removeDislike(dislike);
                postDislikeDao.delete(dislike);
                System.out.println("dislike removed");
                //return to page
                return "TestTemplates/PostCrud";
            }
        }

        PostDislike postDislike = new PostDislike(user,dislikedPost);
        user.addDislike(postDislike);
        dislikedPost.addDislike(postDislike);
        postDislikeDao.save(postDislike);
        System.out.println("dislike added");

        return "TestTemplates/PostCrud";
    }
}
