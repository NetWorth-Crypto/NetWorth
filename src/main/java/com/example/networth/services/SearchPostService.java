package com.example.networth.services;

import com.example.networth.models.Post;
import com.example.networth.repositories.PostRepository;
import com.example.networth.repositories.SearchPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchPostService {

    @Autowired
    private SearchPostRepository postrepository;

    /*
     * TODO: Get the List of Shops
     */
    public List<Post> getAllPost(){
        List<Post> list =  (List<Post>)postrepository.findAll();
        return list;
    }

    /*
     * TODO: Get Shop By keyword
     */
    public List<Post> getByKeyword(String keyword){
        return postrepository.findByKeyword(keyword);
    }
}
