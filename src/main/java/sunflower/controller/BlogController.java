package sunflower.controller;

import com.netflix.zuul.context.RequestContext;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import sunflower.entity.TextBlog;
import sunflower.service.BlogService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class BlogController {

    BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/blog")
    public TextBlog add(@RequestBody TextBlog blog) {
        return blogService.add(blog);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/blog/{title}")
    public boolean delete(@PathVariable("title") String title) {
        return blogService.delete(title);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/blog")
    public TextBlog query(@RequestParam("title") String title) {
        return blogService.query(title);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/blog/{author}")
    public List<TextBlog> queryByAuthor(@PathVariable("author") String author) {
        return blogService.queryByAuthor(author);
    }

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/blog")
//    public List<TextBlog> queryAll() {
//        return blogService.queryAll();
//    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/blog")
    public TextBlog patch(@RequestBody TextBlog blog) {
        return blogService.update(blog);
    }
}
