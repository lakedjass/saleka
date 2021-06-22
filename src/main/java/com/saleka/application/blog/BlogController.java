package com.saleka.application.blog;

import com.saleka.application.admin.AdminController;
import com.saleka.application.blog.post.Post;
import com.saleka.application.blog.post.PostService;
import com.saleka.application.security.User;
import com.saleka.application.security.UserPrincipal;
import com.saleka.application.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "admin")
public class BlogController {
    private final PostService postService;
    private final UserService userService;

    @Autowired
    public BlogController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/posts")
    public String getPosts(Model model){
        List<Post> posts = postService.getPosts();
        model.addAttribute("posts", posts);
        return "admin/blog/list-posts";
    }

    @PostMapping("/addPost")
    public String newPost(Post post){
        UserPrincipal principal = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        User connectedUser = userService.findUserByEmail(principal.getEmail());
        post.setAuthor( connectedUser );
        postService.newPost(post);
        return "redirect:/admin/posts";
    }

    @GetMapping("/addPost")
    public String showPostForm(){
        return "admin/blog/new-post";
    }

    @GetMapping("/showPost/{id}")
    public String showPost(@PathVariable(name = "id") Long id, Model model){
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "admin/blog/show-post";
    }

    @GetMapping("/editPost/{id}")
    public String editPostForm(@PathVariable(name = "id") Long id, Model model){
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "admin/blog/edit-post";
    }

    @PostMapping("/editPost/{id}")
    public String editPost(@PathVariable(name = "id") Long id  , Post post){
        postService.updatePost(id, post);
        return "redirect:/admin/posts";
    }

    @GetMapping("/deletePost/{id}")
    public String deletePost(@PathVariable(name = "id") Long id){
        postService.deletePost(id);
        return "redirect:/admin/posts";
    }




}
