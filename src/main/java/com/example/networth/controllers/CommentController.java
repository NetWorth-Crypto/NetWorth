package com.example.networth.controllers;

import com.example.networth.models.Comment;
import com.example.networth.models.User;
import com.example.networth.repositories.CommentRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController
{

    private CommentRepository commentDao;

    public CommentController(CommentRepository commentDao)
    {
        this.commentDao = commentDao;
    }

    @GetMapping("/CommentCrud")
    public String showCommentForm (Model model)
    {
        model.addAttribute("Comment", new Comment());
        return "TestCommentCrud/CommentCrud";
    }

    @PostMapping("/TestCommentCrud/CommentCrud")
    public String submitComment(@ModelAttribute("submitComment") Comment comment, Model model)
    {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        comment.setComment("comment");

        model.addAttribute("Comment", comment);

        return "TestCommentCrud/commentTestResult";
    }
}