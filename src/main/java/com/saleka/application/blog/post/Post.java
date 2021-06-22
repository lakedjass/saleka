package com.saleka.application.blog.post;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.saleka.application.blog.comment.Comment;
import com.saleka.application.blog.tag.Tag;
import com.saleka.application.security.User;
import com.saleka.application.security.UserPrincipal;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User author;

    @Column(nullable = false, columnDefinition = "TEXT", length = 1000)
    private String title;

    @Column(columnDefinition = "TEXT", length = 25000)
    private String body;

    private LocalDate doc;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<Tag> tags;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Comment> comments;


    public Post() {
    }

    public Post(String title) {
        this.title = title;
        this.body = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDoc(LocalDate doc) {
        this.doc = doc;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setAllProperties(Post post , boolean withId){
        setBody(post.getBody());
        setDoc(post.getDoc());
        setTitle(post.getTitle());
        if(withId){
            setId(post.getId());
        }
    }
}
