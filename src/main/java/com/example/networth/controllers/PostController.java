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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
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


    @GetMapping("/createpost")
    public String testPost(Model model){
        model.addAttribute("post", new Post());
        return "TestTemplates/CreatePost";
    }

    @GetMapping("/posts")
    public String userPost(Model model){
        //Get All Post
        List<Post> posts = postDao.findAll();
        Collections.reverse(posts);

//        User user = userDao.getReferenceById(1l);
//        Post post = postDao.getReferenceById(1l);

//        model.addAttribute("user",user);
//        model.addAttribute("post",post);
        model.addAttribute("posts",posts);
        model.addAttribute("newPost",new Post());

        return "feed";
    }


    @PostMapping("/posts/create")
    public String testPost1(@ModelAttribute("newPost") Post newPost,
                            @RequestParam("imgUrl") String imgUrl,
                            @RequestParam("videoUrl") String videoUrl){
        //Get UserId from logged-in user to create new post
        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User user = userDao.getReferenceById(loggedinUser.getId());
        //Create new post
//        newPost.setUser(user);
        newPost.setImgUrl(imgUrl);
        newPost.setVideoUrl(videoUrl);
        //Save new post to database

        System.out.println(newPost.getTitle());
        System.out.println(newPost.getDescription());
        System.out.println(imgUrl);
        System.out.println(videoUrl);


        user.getPosts().add(newPost);
        newPost.setUser(user);
        postDao.save(newPost);
        return "redirect:/posts";
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
                return "CreatePost";
            }
        }

        PostLike postLike = new PostLike(user,likedPost);
        user.addLike(postLike);
        likedPost.addLike(postLike);
        postLikeDao.save(postLike);
        System.out.println("like added");


        return "CreatePost";
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
                return "CreatePost";
            }
        }

        PostDislike postDislike = new PostDislike(user,dislikedPost);
        user.addDislike(postDislike);
        dislikedPost.addDislike(postDislike);
        postDislikeDao.save(postDislike);
        System.out.println("dislike added");

        return "CreatePost";
    }
}
