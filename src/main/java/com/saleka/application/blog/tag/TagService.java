package com.saleka.application.blog.tag;

import com.saleka.application.blog.category.Category;
import com.saleka.application.blog.tag.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagService {
    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getTags(){
        List<Tag> tags = tagRepository.findAll();
        if(tags == null){
            throw new IllegalStateException("Error Found");
        }
        return tags;
    }

    public Page<Tag> getTags(int page , int size){
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Tag> tags = tagRepository.findAll(pageable);
        if(tags == null){
            throw new IllegalStateException("Error Found");
        }
        return tags;
    }

    public Tag newTag(Tag tag){
        if(tag == null){
            throw new IllegalStateException("Tag Not Found");
        }
        tagRepository.saveAndFlush(tag);
        return tag;
    }


    public Tag findById(Long id){
        return tagRepository.findById(id).orElseThrow(() -> new IllegalStateException("No Tag Found"));
    }

    public void deleteTag(Long id){
        boolean exist = tagRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("No Tag Found For This ID");
        }
        tagRepository.deleteById(id);
    }


    @Transactional
    public void updateTag(Long id, Tag tag){
        if(tag == null){
            throw new IllegalStateException("The Update couldn't be resolved the Tag object given was null");
        }
        Tag tag1 = tagRepository.findById(id).orElseThrow(() -> new IllegalStateException("No Tag Found For This ID"));
        tag1.setAllProperties(tag , false);
        tagRepository.saveAndFlush(tag1);
    }


}
