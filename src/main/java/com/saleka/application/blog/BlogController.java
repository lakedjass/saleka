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
import com.saleka.application.configuration.ConfigurationService;
import com.saleka.application.configuration.ConfigurationSite;
import com.saleka.application.security.User;
import com.saleka.application.security.UserPrincipal;
import com.saleka.application.security.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.*;

@Controller
public class BlogController implements WebMvcConfigurer {
    private final PostService postService;
    private final UserService userService;
    private final CategoryService categoryService;
    private final CommentService commentService;
    private final TagService tagService;
    private final ConfigurationService configurationService;


    @Autowired
    public BlogController(PostService postService, ConfigurationService configurationService , UserService userService, CategoryService categoryService, CommentService commentService, TagService tagService) {
        this.postService = postService;
        this.userService = userService;
        this.categoryService = categoryService;
        this.commentService = commentService;
        this.tagService = tagService;
        this.configurationService = configurationService;
    }

    //Front Office Routes

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
        List<ConfigurationSite> configurationAllSite = configurationService.getAllSiteConfigurations();
        model.addAttribute("site", configurationAllSite);
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
        List<ConfigurationSite> configurationAllSite = configurationService.getAllSiteConfigurations();
        model.addAttribute("site", configurationAllSite);
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
        return "redirect:blog-single?id=" + postId;
    }


    //BackOffice Routes


    @GetMapping("admin/tags")
    public String getTags(@RequestParam(required = false , defaultValue = "1") int page ,Model model){
        int size = 5;
        Page<Tag> pageTags = tagService.getTags(page , size);
        List<Tag> tags = pageTags.getContent();
        model.addAttribute("tags", tags);
        model.addAttribute("currentPage" , page);
        model.addAttribute("totalPages", pageTags.getTotalPages());
        model.addAttribute("totalItems", pageTags.getTotalElements());
        UserPrincipal principal = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("user", principal);
        return "admin/blog/list-tags";
    }

    @GetMapping("admin/comments")
    public String getComments(@RequestParam(required = false , defaultValue = "1") int page ,Model model){
        int size = 5;
        Page<Comment> pageComments = commentService.getComments(page , size);
        List<Comment> comments = pageComments.getContent();
        List<Post> posts = postService.getPosts();
        model.addAttribute("comments", comments);
        model.addAttribute("posts", posts);
        model.addAttribute("currentPage" , page);
        model.addAttribute("totalPages", pageComments.getTotalPages());
        model.addAttribute("totalItems", pageComments.getTotalElements());
        UserPrincipal principal = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("user", principal);
        return "admin/blog/list-comments";
    }

    @GetMapping("admin/categories")
    public String getCategories(@RequestParam(required = false , defaultValue = "1") int page ,Model model){
        int size = 5;
        Page<Category> pageCategories = categoryService.getCategories(page , size);
        List<Category> categories = pageCategories.getContent();
        model.addAttribute("categories", categories);
        model.addAttribute("currentPage" , page);
        model.addAttribute("totalPages", pageCategories.getTotalPages());
        model.addAttribute("totalItems", pageCategories.getTotalElements());
        UserPrincipal principal = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("user", principal);
        return "admin/blog/list-categories";
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
        UserPrincipal principal = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("user", principal);
        return "admin/blog/list-posts";
    }



    @PostMapping("admin/addCategory")
    public String newCategory(Category category, @RequestParam(required = false) String catId ){
        if(catId == null){
            categoryService.newCategory(category);
        }else{
            categoryService.updateCategory(Long.parseLong(catId),category);
        }
        return "redirect:categories";
    }

    @PostMapping("admin/addPost")
    public String newPost(@Valid Post postForm, @RequestParam(required = false) Collection<String> categoryIdList , @RequestParam(required = false) Collection<String> tagIdList , @RequestParam(required = false) String postId , BindingResult bindingResult){
        UserPrincipal principal = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        if(bindingResult.hasErrors()){
            return "admin/blog/new-post";
        }
        User connectedUser = userService.findUserByEmail(principal.getEmail());
        postForm.setAuthor( connectedUser );
        Collection<Category> categories = new ArrayList<>();
        Collection<Tag> tags = new ArrayList<>();
        //post.setTitle( title );
        categoryIdList.forEach(
                (categoryId) -> categories.add(categoryService.findById(Long.parseLong(categoryId)))
        );
        tagIdList.forEach(
                (tagId) -> tags.add(tagService.findById(Long.parseLong(tagId)))
        );
        postForm.setCategories(categories);
        postForm.setTags(tags);
        if(postId == null){
            postService.newPost(postForm);
        }else {
            postService.updatePost(Long.parseLong(postId) , postForm);
        }

        return "redirect:posts";
    }

    @PostMapping("admin/addComment")
    public String createComment(Comment comment , @RequestParam() String postId , @RequestParam(required = false) String commentId){
        UserPrincipal principal = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        User connectedUser = userService.findUserByEmail(principal.getEmail());
        comment.setAuthor( connectedUser );
        Post post = postService.findById(Long.parseLong(postId));
        comment.setPost(post);
        if(commentId == null){
            commentService.newComment(comment);
        }else{
            commentService.updateComment(Long.parseLong(commentId) , comment);
        }
        return "redirect:comments";
    }

    @PostMapping("admin/addTag")
    public String newTag(Tag tag, @RequestParam(required = false) String tagId ){
        if(tagId == null){
            tagService.newTag(tag);
        }else{
            tagService.updateTag(Long.parseLong(tagId) , tag);
        }
        return "redirect:tags";
    }

    @GetMapping("admin/addPost")
    public String showPostForm(@RequestParam(required = false) Long id ,  Model model){
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

    @GetMapping("admin/addComment")
    public String showCommentForm(@RequestParam(required = false) Long id , Model model){
        UserPrincipal principal = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("user", principal);
        Collection<Post> posts = postService.getPosts();
        model.addAttribute("posts" , posts);
        if(id != null){
            model.addAttribute("comment" , commentService.findById(id));
        }
        return "admin/blog/new-comment";
    }

    @GetMapping("admin/showPost")
    public String showPost(@RequestParam() Long id, Model model){
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return viewPost(id , model);
    }


    @GetMapping("admin/deletePost")
    public String deletePost(@RequestParam() Long id){
        postService.deletePost(id);
        return "redirect:posts";
    }

    @GetMapping("admin/deleteCategory")
    public String deleteCategory(@RequestParam() Long id){
        categoryService.deleteCategory(id);
        return "redirect:categories";
    }

    @GetMapping("admin/deleteComment")
    public String deleteComment(@RequestParam() Long id){
        commentService.deleteComment(id);
        return "redirect:comments";
    }

    @GetMapping("admin/deleteTag")
    public String deleteTag(@RequestParam() Long id){
        commentService.deleteComment(id);
        return "redirect:tags";
    }

}
