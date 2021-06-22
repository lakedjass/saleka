package com.saleka.application.blog.post;

import com.saleka.application.blog.comment.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/articles")
public class PostController {

    private final PostService postService;
    private final HttpHeaders headers = new HttpHeaders();

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
        this.headers.add("Content-Type", "application/json");
    }


    @GetMapping
    public ResponseEntity<List<Post>> getPosts(){
        return ResponseEntity.ok().headers(headers).body(postService.getPosts());
    }

    @PostMapping
    public ResponseEntity<Post> newPost(@RequestBody Post post){
        return  ResponseEntity.ok().headers(headers).body(postService.newPost(post)) ;
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Long id){
        postService.deletePost(id);
        return ResponseEntity.ok().headers(headers).body("Deleted Completed");
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<String> UpdatePost(@PathVariable("id") Long id, @RequestBody Post post){
        postService.updatePost(id, post);
        return ResponseEntity.ok().headers(headers).body("Update Completed");
    }

}