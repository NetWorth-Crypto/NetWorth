package com.example.networth.controllers;

import com.example.networth.models.Comment;
import com.example.networth.models.User;
import com.example.networth.repositories.CommentRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentController {

    private CommentRepository commentDao;

    public CommentController(CommentRepository commentDao) {
        this.commentDao = commentDao;
    }

    /* Create Comment */
    @GetMapping("/createComment")
    public String showCommentForm(Model model) {
        model.addAttribute("Comment", new Comment());
        return "comments/createComment";
    }

    @PostMapping("comments/createComment")
    public String submitComment(@ModelAttribute("submitComment") Comment comment, Model model) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        comment.setComment("comment");

        model.addAttribute("Comment", comment);

        return "redirect:/comments/{id}";
    }

    /* Read Comment */
    @GetMapping("/comments/{id}")
    public String showComment(@PathVariable long id, Model model) {
        model.addAttribute("comment", commentDao.getReferenceById(id));
        return "comments/readComment";
    }

    /* Delete Comment */
    @DeleteMapping("/comments/{id}/delete")
    public String deleteComment(@PathVariable long id) {
        commentDao.delete(commentDao.getReferenceById(id));
        return "redirect:/comments";
    }

    /* Edit Comment */
    @GetMapping("/comments/{id}/editComment")
    public String getEditComment(@PathVariable long id, Model model)
    {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Comment comment =  commentDao.getReferenceById(id);
        System.out.println(comment.getId());
        System.out.println(comment.getPostingUserId());
        System.out.println(comment.getPost().getId());
        System.out.println(comment.getComment());
        System.out.println("This is the user: " + user);

//        model.addAttribute("editComment", commentDao.getReferenceById(id));

        return "comments/editComment";
    }

    @PostMapping("/comments/editComment")
    public String postEditComment()
    {
        System.out.println("Reached Edit Final");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user);
//        commentDao.save(comment);

//        return "redirect:/comments/" + comment.getId();
        return "/comments/readComment";
    }
}