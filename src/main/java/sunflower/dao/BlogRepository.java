package sunflower.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sunflower.entity.TextBlog;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<TextBlog, String> {

    Optional<TextBlog> findTextBlogByTitle(String title);

    List<TextBlog> findAllByAuthorOrderByCreatedTimeDesc(String author);
}
