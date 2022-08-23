package pl.simo333.app.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.simo333.app.domain.Author;
import pl.simo333.app.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/add")
    public String addAuthor() {
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        authorService.saveAuthor(author);
        return "Id dodanego autora to: " + author.getId();
    }

    @RequestMapping("/get/{id}")
    public String getAuthor(@PathVariable long id) {
        Author author = authorService.findById(id);
        return author.toString();
    }

    @RequestMapping("/update/{id}/{firstName}/{lastName}")
    public String updateAuthor(@PathVariable long id, @PathVariable String firstName, @PathVariable String lastName) {
        Author author = authorService.findById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorService.update(author);
        return author.toString();
    }

    @RequestMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable long id) {
        authorService.delete(id);
        return "deleted";
    }
}