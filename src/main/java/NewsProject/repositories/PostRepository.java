package NewsProject.repositories;

import NewsProject.tables.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List <Post> findByArticleLike(String article);
}
