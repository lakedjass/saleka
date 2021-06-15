package com.saleka.application.blog.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments(){
        List<Comment> posts = commentRepository.findAll();
        if(posts.equals(null)){
            throw new IllegalStateException("Error Found");
        }
        //return new ResponseEntity<>(commentRepository.findAll() , this.headers , HttpStatus.OK) ;
        return posts;
    }

    public Comment newComment(Comment comment){
        if(comment == null){
            throw new IllegalStateException("Comment is null");
        }
        commentRepository.saveAndFlush(comment);
        return comment;
    }

    public void deleteComment(Long id){
        boolean exist = commentRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("No Comment Found For This ID");
        }
        commentRepository.deleteById(id);
    }

    @Transactional
    public void updateComment(Long id, Comment comment){
        if(comment == null){
            throw new IllegalStateException("The Update couldn't be resolved the Comment object given was null");
        }
        Comment comment1 = commentRepository.findById(id).orElseThrow(() -> new IllegalStateException("No Comment Found For This ID"));
        comment1.setAllProperties(comment , false);
        commentRepository.saveAndFlush(comment1);
    }
}
