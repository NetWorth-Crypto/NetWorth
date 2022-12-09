package com.example.networth.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column()
    private String title;

    @Column
    private String imgUrl;

    @Column(length = 1000)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post",orphanRemoval = true)
    private List<Comment> comments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", orphanRemoval = true)
    private List<PostLike> likes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", orphanRemoval = true)
    private List<PostDislike> dislikes;

    //Constructors
    public Post() {
    }

    public Post(String title, String imgUrl, String description) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.description = description;
    }


    //Add and Remove PostLike objects
    public void addLike(PostLike postLike){
        this.likes.add(postLike);
        postLike.setPost(this);
    }

    public void removeLike(PostLike postLike){
        this.likes.remove(postLike);
        postLike.setPost(null);
    }

    //Add and Remove PostDisLike objects
    public void addDislike(PostDislike postDisLike){
        this.dislikes.add(postDisLike);
        postDisLike.setPost(this);
    }

    public void removeDislike(PostDislike postDisLike){
        this.dislikes.remove(postDisLike);
        postDisLike.setPost(null);
    }



}
