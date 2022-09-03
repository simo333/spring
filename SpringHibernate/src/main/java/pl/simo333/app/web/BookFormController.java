package pl.simo333.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.simo333.app.domain.Author;
import pl.simo333.app.domain.Book;
import pl.simo333.app.domain.Publisher;
import pl.simo333.app.service.AuthorService;
import pl.simo333.app.service.BookService;
import pl.simo333.app.service.PublisherService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/bookForm")
public class BookFormController {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;


    public BookFormController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @GetMapping("/form")
    public String displayForm(Model model) {
        model.addAttribute("book", new Book());
        return "form/book";
    }
    @GetMapping("/edit/{id}")
    public String displayForm(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookService.findById(id));
        return "form/book";
    }

    @PostMapping("/form")
    public String handleForm(@Valid Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "form/book";
        }
        bookService.saveBook(book);
        return "redirect:/bookForm/list";
    }

    @GetMapping("/list")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "list/book";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/bookForm/list";
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherService.findAll();
    }

    @ModelAttribute("allAuthors")
    public List<Author> authors() {
        return authorService.findAll();
    }

}
