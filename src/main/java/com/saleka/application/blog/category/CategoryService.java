package com.saleka.application.blog.category;

import com.saleka.application.blog.category.Category;
import com.saleka.application.blog.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        List<Category> categories = categoryRepository.findAll();
        if(categories == null){
            throw new IllegalStateException("Error Found");
        }
        return categories;
    }

    public Page<Category> getCategories(int page , int size){
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Category> categories = categoryRepository.findAll(pageable);
        if(categories == null){
            throw new IllegalStateException("Error Found");
        }
        return categories;
    }

    public Category newCategory(Category category){
        if(category == null){
            throw new IllegalStateException("Category Not Found");
        }
        categoryRepository.saveAndFlush(category);
        return category;
    }

    public void deleteCategory(Long id){
        boolean exist = categoryRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("No Category Found For This ID");
        }
        categoryRepository.deleteById(id);
    }

    public Category findById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException("No Category Found... Please pass a correct ID"));
        return category;
    }

    @Transactional
    public void updateCategory(Long id, Category category){
        if(category == null){
            throw new IllegalStateException("The Update couldn't be resolved the Category object given was null");
        }
        Category category1 = categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException("No Category Found For This ID"));
        category1.setAllProperties(category , false);
        categoryRepository.saveAndFlush(category1);
    }
}
