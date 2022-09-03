package pl.simo333.app.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.simo333.app.domain.Book;

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

    @GetMapping
    @ResponseBody
    public String validate() {
        Book book = new Book();
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        if(violations.isEmpty()) {
            return "valid";
        }
        violations.forEach(v -> logger.info("{} {}", v.getPropertyPath(), v.getMessage()));
        return "invalid";
    }
}
