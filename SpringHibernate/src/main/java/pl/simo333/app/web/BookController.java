package pl.simo333.app.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.simo333.app.domain.Author;
import pl.simo333.app.domain.Book;
import pl.simo333.app.domain.Publisher;
import pl.simo333.app.service.AuthorService;
import pl.simo333.app.service.BookService;
import pl.simo333.app.service.PublisherService;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;
    private Logger logger = LoggerFactory.getLogger(BookController.class);

    public BookController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @RequestMapping("/add")
    public String addBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Publisher from controller");
        publisherService.savePublisher(publisher);

        Author author1 = authorService.findById(1);
        Author author2 = authorService.findById(2);

        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setPublisher(publisher);
        book.addAuthor(author1);
        book.addAuthor(author2);
        book = bookService.saveBook(book);
        return "Id dodanej książki to: " + book.getId();
    }

    @RequestMapping("/get/{id}")
    public String getBook(@PathVariable long id) {
        Book book = bookService.findById(id);
        return book.toString();
    }

    @RequestMapping("/all")
    public void getAllBooks() {
        bookService.findAll().forEach(b -> logger.info(b.toString()));
    }

     @RequestMapping("/all/{rating}")
    public void findAllByRating(@PathVariable double rating) {
        bookService.findAllByRating(rating).forEach(b -> logger.info(b.toString()));
    }

    @RequestMapping("/with-publisher")
    public void findAllWithPublisher() {
        bookService.findAllWithPublisher().forEach(System.out::println);
    }

    @RequestMapping("/with-publisher/{id}")
    public void findAllWithPublisherId(@PathVariable Long id) {
        bookService.findAllWithPublisherId(id).forEach(System.out::println);
    }

    @RequestMapping("/update/{id}/{title}")
    public String updateBook(@PathVariable long id, @PathVariable String title) {
        Book book = bookService.updateTitle(id, title);
        return book.toString();
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        bookService.delete(id);
        return "deleted";
    }
}