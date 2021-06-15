package com.saleka.application.blog.tag;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.saleka.application.blog.comment.Comment;
import com.saleka.application.blog.post.Post;

import javax.persistence.*;

@Entity
@Table
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String key;

    @ManyToOne
    @JsonBackReference
    private Post post;

    @ManyToOne
    @JsonBackReference
    private Comment comment;

    public Tag() {
    }

    public Tag(Long id, String key) {
        this.id = id;
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void setAllProperties(Tag tag , boolean withId){
        setKey(tag.getKey());
        if(withId){
            setId(tag.getId());
        }
    }
}
