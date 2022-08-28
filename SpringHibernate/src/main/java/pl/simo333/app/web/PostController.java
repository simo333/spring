package pl.simo333.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.simo333.app.dao.PostDao;
import pl.simo333.app.domain.Post;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostDao postDao;

    public PostController(PostDao postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/test")
    public void testSave() {
        Post post = postDao.testSave();
        System.out.println(post);
    }
}
