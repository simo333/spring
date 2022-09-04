package pl.simo333.app.web;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.simo333.app.domain.Author;
import pl.simo333.app.domain.Book;
import pl.simo333.app.repository.AuthorRepository;
import pl.simo333.app.service.AuthorService;
import pl.simo333.app.service.BookService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/authorForm")
public class AuthorFormController {

    private final AuthorService authorService;
    private final BookService bookService;
    private final AuthorRepository authorRepository;

    public AuthorFormController(AuthorService authorService, BookService bookService, AuthorRepository authorRepository) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/form")
    public String displayForm(Model model) {
        model.addAttribute("author", new Author());
        return "form/author";
    }


    @GetMapping("/list")
    public String listAuthors(@RequestParam(name = "lastName", required = false) String lastName,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "20") int pageSize,
                            Model model) {
        if(lastName != null) {

            model.addAttribute("authors",
                    authorRepository.findAllByLastName(lastName, Pageable.ofSize(pageSize)).getContent());
        } else {
            model.addAttribute("authors", authorService.findAll());
        }
        return "list/author";
    }

    @GetMapping("/edit/{id}")
    public String displayForm(Model model, @PathVariable Long id) {
        model.addAttribute("author", authorService.findById(id));
        return "form/author";
    }

    @PostMapping("/form")
    public String handleForm(@Valid Author author, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "form/author";
        }
        authorService.saveAuthor(author);
        return "redirect:/authorForm/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        authorService.delete(id);
        return "redirect:/authorForm/list";
    }


    @ModelAttribute("allBooks")
    public List<Book> books() {
        return bookService.findAll();
    }
}
