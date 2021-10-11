package sunflower.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sunflower.dao.BlogRepository;
import sunflower.entity.TextBlog;

import java.util.List;
import java.util.UUID;

@Service
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public TextBlog add(TextBlog blog) {
        blog.setId(UUID.randomUUID().toString());
        return blogRepository.save(blog);
    }

    @Override
    @Transactional
    public boolean delete(String name) {
        try {
            TextBlog blog = blogRepository.findTextBlogByTitle(name).orElseThrow(() -> new RuntimeException("illegal title"));
            blog.setDeleted(true);
            blogRepository.save(blog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public TextBlog update(TextBlog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public TextBlog query(String name) {
        return blogRepository.findTextBlogByTitle(name).orElseThrow(() -> new RuntimeException("dont exist title"));
    }

    @Override
    public List<TextBlog> queryAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<TextBlog> queryByAuthor(String author) {
        return blogRepository.findAllByAuthorOrderByCreatedTimeDesc(author);
    }
}
