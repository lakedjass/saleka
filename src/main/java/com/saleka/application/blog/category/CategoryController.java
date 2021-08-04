package com.saleka.application.blog.category;

import com.saleka.application.blog.category.Category;
import com.saleka.application.blog.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final HttpHeaders headers = new HttpHeaders();

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
        this.headers.add("Content-Type", "application/json");
    }


    @GetMapping
    public ResponseEntity<List<Category>> getCategorys(){
        return ResponseEntity.ok().headers(headers).body(categoryService.getCategories());
    }

    @PostMapping
    public ResponseEntity<Category> newCategory(@RequestBody Category category){
        return  ResponseEntity.ok().headers(headers).body(categoryService.newCategory(category)) ;
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().headers(headers).body("Deleted Completed");
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<String> UpdateCategory(@PathVariable("id") Long id, @RequestBody Category category){
        categoryService.updateCategory(id, category);
        return ResponseEntity.ok().headers(headers).body("Update Completed");
    }

}
