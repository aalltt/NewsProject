package NewsProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    private PostService postService;

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/list")
    public String listPost(Model model) {
        List<Post> listAllPost = postService.getAllPost();
        model.addAttribute("posts", listAllPost);
        return "list";
    }

    @GetMapping("/listadmin")
    public String adminPostPage(Model model) {
        List<Post> listAllPost = postService.getAllPost();
        model.addAttribute("posts", listAllPost);
        return "listadminpage";
    }

    @GetMapping("/post")
    public String postPage(Model model) {
        model.addAttribute("post", new Post());
        return "post";
    }

    @PostMapping("/post/submit")
    public String savePost(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/list";
    }

    @GetMapping("/login")
    public String login(){
            return "login";
    }

    @GetMapping("/listadmin/delete/{id}")
    public String deletePost(@PathVariable("id") Integer id) {
        postService.deletePost(id);
        return "redirect:/listadmin";
    }
}
