package pl.simo333.app.service;

import org.springframework.stereotype.Service;
import pl.simo333.app.dao.BookDao;
import pl.simo333.app.domain.Book;
import pl.simo333.app.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private final BookDao bookDao;
    private final BookRepository bookRepository;

    public BookService(BookDao bookDao, BookRepository bookRepository) {
        this.bookDao = bookDao;
        this.bookRepository = bookRepository;
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
        return bookRepository.findAll();
    }

    public List<Book> findAllByRating(double rating) {
        return bookDao.findAllByRating(rating);
    }

    public List<Book> findAllWithPublisher() {
        return bookDao.findAllWithPublisher();
    }

    public List<Book> findAllWithPublisherId(long publisherId) {
       return bookDao.findAllWithPublisherId(publisherId);
    }

    public List<Book> findAllWithAuthorId(long authorId) {
        return bookDao.findAllWithAuthorId(authorId);
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