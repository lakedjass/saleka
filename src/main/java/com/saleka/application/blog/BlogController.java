package com.saleka.application.blog;

import com.saleka.application.admin.AdminController;
import com.saleka.application.blog.category.Category;
import com.saleka.application.blog.category.CategoryService;
import com.saleka.application.blog.comment.Comment;
import com.saleka.application.blog.comment.CommentService;
import com.saleka.application.blog.post.Post;
import com.saleka.application.blog.post.PostService;
import com.saleka.application.blog.tag.Tag;
import com.saleka.application.blog.tag.TagService;
import com.saleka.application.security.User;
import com.saleka.application.security.UserPrincipal;
import com.saleka.application.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class BlogController {
    private final PostService postService;
    private final UserService userService;
    private final CategoryService categoryService;
    private final CommentService commentService;
    private final TagService tagService;


    @Autowired
    public BlogController(PostService postService, UserService userService, CategoryService categoryService, CommentService commentService, TagService tagService) {
        this.postService = postService;
        this.userService = userService;
        this.categoryService = categoryService;
        this.commentService = commentService;
        this.tagService = tagService;
    }


    @GetMapping("/blog")
    public String viewBlog(@RequestParam(required = false , defaultValue = "1") int page , Model model){
        int size = 2;
        int size_for_recentsPost = 5;
        List<Category> categories = categoryService.getCategories();
        Page<Post> pagePosts = postService.getPosts(page , size);
        List<Post> posts = pagePosts.getContent();
        List<Post> recentPosts = postService.getRecentPosts(1 , size_for_recentsPost).getContent();
        List<Tag> randomTags = tagService.getTags();
        model.addAttribute("categories", categories);
        model.addAttribute("posts", posts);
        model.addAttribute("tags", randomTags);
        model.addAttribute("recentPosts", recentPosts);
        model.addAttribute("currentPage" , page);
        model.addAttribute("totalPages", pagePosts.getTotalPages());
        model.addAttribute("totalItems", pagePosts.getTotalElements());
        return "blog/blog";
    }



    @GetMapping("/blog-single")
    public String viewPost(@RequestParam Long id ,Model model){
        Post post = postService.findById(id);
        model.addAttribute("post" , post);
        List<Category> categories = (List<Category>) post.getCategories();
        List<Tag> postTags =  (List<Tag>) post.getTags();
        Page<Post> recentPosts = postService.getRecentPosts(1 , 5);
        model.addAttribute("categories", categories);
        model.addAttribute("tags", postTags);
        model.addAttribute("recentPosts", recentPosts.getContent());
        UserPrincipal principal = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("user", principal);
        return "blog/blog-single";
    }

    @PostMapping("/new-comment")
    public String newComment(@RequestParam() Long postId, @RequestParam(required =  false) Long commentId ,Comment comment){
        comment.setPost(postService.findById(postId));
        if(commentId != null){
            comment.setComment(commentService.findById(commentId));
        }
        UserPrincipal principal = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        User connectedUser = userService.findUserByEmail(principal.getEmail());
        comment.setAuthor(connectedUser);
        commentService.newComment(comment);
        return "redirect:/blog-single?id=" + postId;
    }

    @GetMapping("admin/tags")
    public String getTags(@RequestParam(required = false , defaultValue = "1") int page ,Model model){
        int size = 5;
        Page<Tag> pageTags = tagService.getTags(page , size);
        List<Tag> tags = pageTags.getContent();
        model.addAttribute("tags", tags);
        model.addAttribute("currentPage" , page);
        model.addAttribute("totalPages", pageTags.getTotalPages());
        model.addAttribute("totalItems", pageTags.getTotalElements());
        return "admin/blog/list-tags";
    }

    @GetMapping("admin/comments")
    public String getComments(@RequestParam(required = false , defaultValue = "1") int page ,Model model){
        int size = 5;
        Page<Comment> pageComments = commentService.getComments(page , size);
        List<Comment> comments = pageComments.getContent();
        model.addAttribute("comments", comments);
        model.addAttribute("currentPage" , page);
        model.addAttribute("totalPages", pageComments.getTotalPages());
        model.addAttribute("totalItems", pageComments.getTotalElements());
        return "admin/blog/list-comments";
    }

    @GetMapping("admin/categories")
    public String getCategories(@RequestParam(required = false , defaultValue = "1") int page , @RequestParam(required = false) Long id ,Model model){
        int size = 5;
        Page<Category> pageCategories = categoryService.getCategories(page , size);
        List<Category> categories = pageCategories.getContent();
        if(id != null){
            model.addAttribute("category" , categoryService.findById(id));
        }
        model.addAttribute("categories", categories);
        model.addAttribute("currentPage" , page);
        model.addAttribute("totalPages", pageCategories.getTotalPages());
        model.addAttribute("totalItems", pageCategories.getTotalElements());
        return "admin/blog/list-categories";
    }

    @PostMapping("admin/addCategory")
    public String newCategory(Category category, @RequestParam(required = false) String catId){
        if(catId == null){
            categoryService.newCategory(category);
        }else{
            categoryService.updateCategory(Long.parseLong(catId),category);
        }
        return "admin/categories";
    }

    @GetMapping("admin/posts")
    public String getPosts(@RequestParam(required = false , defaultValue = "1") int page ,Model model){
        int size = 5;
        Page<Post> pagePosts = postService.getPosts(page , size);
        List<Post> posts = pagePosts.getContent();
        model.addAttribute("posts", posts);
        model.addAttribute("currentPage" , page);
        model.addAttribute("totalPages", pagePosts.getTotalPages());
        model.addAttribute("totalItems", pagePosts.getTotalElements());
        return "admin/blog/list-posts";
    }

    @PostMapping("admin/addPost")
    public String newPost(Post post, @RequestParam() Collection<String> categoryIdList , @RequestParam() Collection<String> tagIdList , @RequestParam() String postId ){
        UserPrincipal principal = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        User connectedUser = userService.findUserByEmail(principal.getEmail());
        post.setAuthor( connectedUser );
        Collection<Category> categories = new ArrayList<>();
        Collection<Tag> tags = new ArrayList<>();
        //post.setTitle( title );
        categoryIdList.forEach(
                (categoryId) -> categories.add(categoryService.findById(Long.parseLong(categoryId)))
        );
        tagIdList.forEach(
                (tagId) -> tags.add(tagService.findById(Long.parseLong(tagId)))
        );
        post.setCategories(categories);
        post.setTags(tags);
        if(postId == null){
            postService.newPost(post);
        }else {
            postService.updatePost(Long.parseLong(postId) , post);
        }

        return "redirect:/admin/posts";
    }

    @GetMapping("admin/addPost")
    public String showPostForm(@RequestParam(required = false) Long id ,Model model){
        UserPrincipal principal = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("user", principal);
        List<Category> categories = categoryService.getCategories();
        List<Tag> tags = tagService.getTags();
        model.addAttribute("categories", categories);
        model.addAttribute("tags", tags);
        if(id != null){
            model.addAttribute("post" , postService.findById(id));
        }
        return "admin/blog/new-post";
    }

    @GetMapping("admin/showPost")
    public String showPost(@RequestParam() Long id, Model model){
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "redirect:/blog-single?id=" +id;
    }


    @GetMapping("admin/deletePost")
    public String deletePost(@RequestParam() Long id){
        postService.deletePost(id);
        return "redirect:/admin/posts";
    }

}
