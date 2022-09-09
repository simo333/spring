package pl.simo333.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.simo333.domain.Article;
import pl.simo333.repository.ArticleDao;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleDao articleDao;

    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping
    public String showArticles(Model model) {
        model.addAttribute("articles", articleDao.findAll());
        return "article/all";
    }

    @GetMapping("/add")
    public String addArticleForm(Model model) {
        model.addAttribute("article", new Article());
        return "article/add";
    }

    @PostMapping("/add")
    public String addArticle(Article article) {
        articleDao.save(article);
        return "redirect:/articles";
    }

    @GetMapping("/edit/{id}")
    public String editArticleForm(Model model, @PathVariable Long id) {
        model.addAttribute("article", articleDao.findById(id));
        return "article/edit";
    }

    @PostMapping("/edit")
    public String editArticle(Article article) {
        articleDao.update(article);
        return "redirect:/articles";
    }

    @GetMapping("delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleDao.delete(articleDao.findById(id));
        return "redirect:/articles";
    }


}
