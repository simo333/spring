package pl.simo333.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.simo333.app.domain.Author;
import pl.simo333.app.domain.Book;
import pl.simo333.app.domain.Publisher;
import pl.simo333.app.service.AuthorService;
import pl.simo333.app.service.BookService;
import pl.simo333.app.service.PublisherService;

import java.util.List;

@Controller
@RequestMapping("/publisherForm")
public class PublisherFormController {

    private final BookService bookService;
    private final PublisherService publisherService;


    public PublisherFormController(BookService bookService, PublisherService publisherService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
    }

    @GetMapping("/form")
    public String displayForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "form/publisher";
    }
    @GetMapping("/edit/{id}")
    public String displayForm(Model model, @PathVariable Long id) {
        model.addAttribute("publisher", publisherService.findById(id));
        return "form/publisher";
    }

    @PostMapping("/form")
    public String handleForm(Publisher publisher) {
        publisherService.savePublisher(publisher);
        return "redirect:/publisherForm/list";
    }

    @GetMapping("/list")
    public String listPublishers(Model model) {
        model.addAttribute("publishers", publisherService.findAll());
        return "list/publisher";
    }
//TODO delete when book is enrolled
    @GetMapping("/delete/{id}")
    public String deletePublisher(@PathVariable Long id) {
        publisherService.delete(id);
        return "redirect:/publisherForm/list";
    }

    @ModelAttribute("allBooks")
    public List<Book> books() {
        return bookService.findAll();
    }

}
