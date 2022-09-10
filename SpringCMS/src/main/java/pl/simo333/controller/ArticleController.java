package pl.simo333.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.simo333.domain.Article;
import pl.simo333.domain.Author;
import pl.simo333.domain.Category;
import pl.simo333.repository.ArticleDao;
import pl.simo333.repository.AuthorDao;
import pl.simo333.repository.CategoryDao;

import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
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
    @GetMapping("/get/{id}")
    public String showArticleDetails(Model model, @PathVariable Long id) {
        model.addAttribute("article", articleDao.findById(id));
        return "article/details";
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

    @ModelAttribute("authors")
    public List<Author> supplyAuthors() {
        return authorDao.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> supplyCategories() {
        return categoryDao.findAll();
    }

}
