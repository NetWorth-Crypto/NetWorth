package com.example.networth.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class PostDislike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    Post post;

    public PostDislike() {
    }

    public PostDislike(User user, Post post) {
        this.user = user;
        this.post = post;
    }
}
