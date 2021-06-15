package com.saleka.application.blog.tag;

import com.saleka.application.blog.comment.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tags")
public class TagController {
    private final TagService tagService;
    private final HttpHeaders headers = new HttpHeaders();

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
        this.headers.add("Content-type", "application/json");
    }

    @GetMapping
    public ResponseEntity<List<Tag>> getTags(){
        List<Tag> tags = tagService.getTags();
        return ResponseEntity.ok().headers(headers).body(tags);
    }

    @PostMapping
    public ResponseEntity<Tag> newTag(@RequestBody Tag tag){
        Tag tag1 = tagService.newTag(tag);
        return ResponseEntity.ok().headers(headers).body(tag1);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteTag(@PathVariable("id") Long id){
        tagService.deleteTag(id);
        return ResponseEntity.ok().headers(headers).body("Deleted Completed");
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<String> UpdateTag(@PathVariable("id") Long id, @RequestBody Tag tag){
        tagService.updateTag(id, tag);
        return ResponseEntity.ok().headers(headers).body("Update Completed");
    }
}
