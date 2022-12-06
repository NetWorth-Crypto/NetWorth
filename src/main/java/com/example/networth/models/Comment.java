package com.example.networth.models;


import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(nullable = false)
    private long postingUserId;

    @Column(length = 2500)
    String imgUrl;

    @Column(nullable = false)
    String comment;

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public long getPostingUserId() {
        return postingUserId;
    }

    public void setPostingUserId(long postingUserId) {
        this.postingUserId = postingUserId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
