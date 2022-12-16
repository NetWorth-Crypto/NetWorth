package com.example.networth.controllers;

import com.example.networth.models.Post;
import com.example.networth.services.SearchPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SearchPostController {

    @Autowired
    private SearchPostService searchPostService;

    @GetMapping(path = {"/searchPost"})
    public String search(Model model, String keyword) {
        if(keyword!=null) {
            List<Post> list = searchPostService.getByKeyword(keyword);
            model.addAttribute("list", list);
        }else {
            List<Post> list = searchPostService.getAllPost();
            model.addAttribute("list", list);}
        return "searchPost";
    }
}
