package NewsProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService {
    private PostRepository postRepository;

    @Autowired
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

//    public Blog getBlogById(Integer id) {
//        return blogRepository.findById(id).get();
//    }

    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }

    public void save(Post post) {
        postRepository.save(post);
    }
}
