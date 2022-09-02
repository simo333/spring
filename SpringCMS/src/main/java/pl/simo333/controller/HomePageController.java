package pl.simo333.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.simo333.domain.Article;
import pl.simo333.repository.ArticleDao;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomePageController {

    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping
    public String home(Model model) {
        List<Article> articles = articleDao.findFiveLastAdded();
        model.addAttribute("articles", articles);
        return "home";
    }


}
