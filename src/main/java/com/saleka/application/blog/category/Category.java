package com.saleka.application.blog.category;

import com.saleka.application.blog.post.Post;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToMany(mappedBy = "categories" , fetch = FetchType.EAGER)
    private Collection<Post> posts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }

    public void setAllProperties(Category category , boolean withId){
        setTitle(category.getTitle());
        if(withId){
            setId(category.getId());
        }
    }
}
