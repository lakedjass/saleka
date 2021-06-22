package com.saleka.application.blog.comment;

import com.saleka.application.blog.post.Post;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/comments")
public class CommentController {
    private final CommentService commentService;
    private final HttpHeaders headers = new HttpHeaders();

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
        this.headers.add("Content-type", "application/json");
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getComments(){
        List<Comment> comments = commentService.getComments();
        return ResponseEntity.ok().headers(headers).body(comments);
    }

    @PostMapping
    public ResponseEntity<Comment> newComment(@RequestBody Comment comment){
        Comment comment1 = commentService.newComment(comment);
        return ResponseEntity.ok().headers(headers).body(comment1);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") Long id){
        commentService.deleteComment(id);
        return ResponseEntity.ok().headers(headers).body("Deleted Completed");
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<String> UpdateComment(@PathVariable("id") Long id, @RequestBody Comment comment){
        commentService.updateComment(id, comment);
        return ResponseEntity.ok().headers(headers).body("Update Completed");
    }
}
