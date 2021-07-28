package com.saleka.application.blog.post;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.saleka.application.blog.category.Category;
import com.saleka.application.blog.comment.Comment;
import com.saleka.application.blog.tag.Tag;
import com.saleka.application.security.User;
import com.saleka.application.security.UserPrincipal;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User author;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "post_category",
            joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id" , referencedColumnName = "id")
    )
    private Collection<Category> categories;

    @Column(nullable = false, columnDefinition = "TEXT", length = 255)
    private String title;

    @Column(columnDefinition = "TEXT", length = 500)
    private String body;

    private Date doc;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name= "tag_id" , referencedColumnName = "id")
    )
    private Collection<Tag> tags;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    public Post() {
        this.doc =  new Date();
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

    public Date getDoc() {
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

    public void setDoc(Date doc) {
        this.doc = doc;
    }

    public Collection<Tag> getTags() {
        return tags;
    }

    public void setTags(Collection<Tag> tags) {
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
        setAuthor(post.getAuthor());
        setCategories(post.getCategories());
        setTags(post.getTags());
        if(withId){
            setId(post.getId());
        }
    }
}
