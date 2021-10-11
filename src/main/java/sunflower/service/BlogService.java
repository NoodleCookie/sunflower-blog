package sunflower.service;

import sunflower.entity.TextBlog;

import java.util.List;

public interface BlogService {

    TextBlog add(TextBlog blog);

    boolean delete(String name);

    TextBlog update(TextBlog blog);

    TextBlog query(String name);

    List<TextBlog> queryAll();

    List<TextBlog> queryByAuthor(String author);
}
