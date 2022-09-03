package pl.simo333.app.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.simo333.app.domain.Author;
import pl.simo333.app.domain.Book;
import pl.simo333.app.domain.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/validate")
public class ValidationController {

    private static final Logger logger = LoggerFactory.getLogger(ValidationController.class);
    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/book")
    public String validateBook(Model model) {
        Book book = new Book();
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        if (violations.isEmpty()) {
            model.addAttribute("violations", "Brak błędów");
        }
        violations.forEach(v -> logger.info("{} {}", v.getPropertyPath(), v.getMessage()));
        model.addAttribute("violations", violations);
        return "validator";
    }

    @GetMapping("/author")
    public String validateAuthor(Model model) {
        Author author = new Author();
        Set<ConstraintViolation<Author>> violations = validator.validate(author);
        if (violations.isEmpty()) {
            model.addAttribute("violations", "Brak błędów");
        }
        violations.forEach(v -> logger.info("{} {}", v.getPropertyPath(), v.getMessage()));
        model.addAttribute("violations", violations);
        return "validator";
    }

    @GetMapping("/publisher")
    public String validatePublisher(Model model) {
        Publisher publisher = new Publisher();
        Set<ConstraintViolation<Publisher>> violations = validator.validate(publisher);
        if (violations.isEmpty()) {
            model.addAttribute("violations", "Brak błędów");
        }
        violations.forEach(v -> logger.info("{} {}", v.getPropertyPath(), v.getMessage()));
        model.addAttribute("violations", violations);
        return "validator";
    }
}
