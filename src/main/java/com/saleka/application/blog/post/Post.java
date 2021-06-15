package com.saleka.application.blog.post;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.saleka.application.blog.comment.Comment;
import com.saleka.application.blog.tag.Tag;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String author,title;

    private String body;

    private LocalDate doc= LocalDate.now();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Comment> comments;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Tag> tags;

    public Post() {
    }

    public Post(String title) {
        this.title = title;
        this.author = "Djialeu";
        this.body = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    }

    public Post(Long id, String author, String title, String body, LocalDate doc) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.body = body;
        this.doc = doc;
    }

    public Post(String author, String title, String body, LocalDate doc) {
        this.author = author;
        this.title = title;
        this.body = body;
        this.doc = doc;
    }

    public Post(Long id, String author, String title, String body, LocalDate doc, List<Comment> comments) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.body = body;
        this.doc = doc;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public LocalDate getDoc() {
        return doc;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDoc(LocalDate doc) {
        this.doc = doc;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setAllProperties(Post post , boolean withId){
        setAuthor(post.getAuthor());
        setBody(post.getBody());
        setDoc(post.getDoc());
        setTitle(post.getTitle());
        if(withId){
            setId(post.getId());
        }
    }
}
