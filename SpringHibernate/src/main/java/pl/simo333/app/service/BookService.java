package pl.simo333.app.service;

import org.springframework.stereotype.Service;
import pl.simo333.app.dao.BookDao;
import pl.simo333.app.domain.Book;

import java.util.List;

@Service
public class BookService {

    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public Book saveBook(Book book) {
        if(book.getId() != null) {
            bookDao.update(book);
        } else {
            bookDao.saveBook(book);
        }
        return book;
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }

    public List<Book> findAllByRating(double rating) {
        return bookDao.findAllByRating(rating);
    }

    public Book findById(long id) {
        return bookDao.findById(id);
    }

    public Book update(Book book) {
        bookDao.update(book);
        return book;
    }

    public Book updateTitle(long id, String title) {
        Book book = findById(id);
        book.setTitle(title);
        bookDao.saveBook(book);
        return book;
    }

    public void delete(long id) {
        Book book = findById(id);
        bookDao.delete(book);
    }
}