package com.aofred.tweeter.controller;

import com.aofred.tweeter.model.Post;
import com.aofred.tweeter.service.PostService;
import com.aofred.tweeter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("/feed")
    public String getFeed(Model model) {
        
        if (!model.containsAttribute("post")) {
            model.addAttribute("post", new Post());
        }
        Pageable pageable = PageRequest.of(0, 25, Sort.by("postDate").descending());
        List<Post> posts = postService.getPostsByUsers(userService.getUserAndFollowing(), pageable);
        model.addAttribute("posts", posts);
        model.addAttribute("loggedUser", userService.getLoggedInUser());
        return "feed";
    }

    @PostMapping("/feed")
    public String addPost(@Valid @ModelAttribute Post post, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            System.out.println("Errors in fields");
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.post", bindingResult);
            redirectAttributes.addFlashAttribute("post", post);
            return "redirect:/feed";
        }

        LocalDateTime date = LocalDateTime.now();
        post.setPostDate(date);
        post.setAuthor(userService.getLoggedInUser());
        postService.savePost(post);

        return "redirect:/feed";
    }
}
