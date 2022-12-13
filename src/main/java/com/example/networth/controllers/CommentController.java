package com.example.networth.controllers;

import com.example.networth.models.Comment;
import com.example.networth.models.User;
import com.example.networth.repositories.CommentRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

        return "comments/createComment";
    }

    /* Read Comment */
    @GetMapping("/comments/{id}")
    public String showComment(@PathVariable long id, Model model) {
        model.addAttribute("comment", commentDao.getReferenceById(id));
        return "comments/readComment";
    }

    /* Delete Comment */
    @PostMapping("/comments/{id}/delete")
    public String deleteComment(@PathVariable long id) {
        commentDao.delete(commentDao.getReferenceById(id));
        return "redirect:/comments";
    }

    /* Edit Comment */
    @GetMapping("/comments/{id}/editComment")
    public String editComment(@PathVariable long id, Model model)
    {
        model.addAttribute("comment", commentDao.getReferenceById(id));
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        commentDao.save();

        return "comments/editComment";
    }
}