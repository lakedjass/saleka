package com.saleka.application.blog.post;

import com.saleka.application.blog.comment.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts(){
        List<Post> posts = postRepository.findAll();
        if(posts == null){
            throw new IllegalStateException("Error Found");
        }
        return posts;
    }

    public Post newPost(Post post){
        if(post == null){
            throw new IllegalStateException("Post Not Found");
        }
        postRepository.saveAndFlush(post);
        return post;
    }

    public void deletePost(Long id){
        boolean exist = postRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("No Post Found For This ID");
        }
        postRepository.deleteById(id);
    }

    public Post findById(Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalStateException("No Post Found... Please pass a correct ID"));
        return post;
    }

    @Transactional
    public void updatePost(Long id, Post post){
        if(post == null){
            throw new IllegalStateException("The Update couldn't be resolved the Post object given was null");
        }
        Post post1 = postRepository.findById(id).orElseThrow(() -> new IllegalStateException("No Post Found For This ID"));
        post1.setAllProperties(post , false);
        postRepository.saveAndFlush(post1);
    }
}
