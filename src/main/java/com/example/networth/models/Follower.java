package com.example.networth.models;


import javax.persistence.*;
@Entity
public class Follower{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long follower_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Column(nullable = false,unique = true)
    private long follower_user_id;
}
