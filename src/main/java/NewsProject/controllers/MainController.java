package NewsProject.controllers;

import NewsProject.tables.Post;
import NewsProject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    private PostService postService;
    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/list")
    public String listPost(Model model) {
        List<Post> listAllPost = postService.getAllPost();
        model.addAttribute("posts", listAllPost);
        return "list";
    }

    @GetMapping("/posts")
    public String searchPartPost(Model model, @RequestParam(defaultValue = "") String article) {
        model.addAttribute("posts", postService.findByArticle(article));
        return "list";
    }

    @GetMapping("/listadmin")
    public String adminPostPage(Model model) {
        List<Post> listAllPost = postService.getAllPost();
        model.addAttribute("posts", listAllPost);
        return "list-admin-page";
    }

    @GetMapping("/post")
    public String postPage(Model model) {
        model.addAttribute("post", new Post());
        return "add-post";
    }

    @PostMapping("/post/submit")
    public String savePost(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/list";
    }

    @GetMapping("/listadmin/delete/{id}")
    public String deletePost(@PathVariable("id") Integer id) {
        postService.deletePost(id);
        return "redirect:/listadmin";
    }


}
