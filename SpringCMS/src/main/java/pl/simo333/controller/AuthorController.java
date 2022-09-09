package pl.simo333.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.simo333.domain.Author;
import pl.simo333.repository.AuthorDao;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping
    public String showAuthors(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "author/all";
    }

    @GetMapping("/add")
    public String addAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "author/add";
    }

    @PostMapping("/add")
    public String addAuthor(Author author) {
        authorDao.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String editAuthorForm(Model model, @PathVariable Long id) {
        model.addAttribute("author", authorDao.findById(id));
        return "author/edit";
    }

    @PostMapping("/edit")
    public String editAuthor(Author author) {
        authorDao.update(author);
        return "redirect:/authors";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorDao.delete(authorDao.findById(id));
        return "redirect:/authors";
    }

}
