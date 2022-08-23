package pl.simo333.app.service;

import org.springframework.stereotype.Service;
import pl.simo333.app.dao.AuthorDao;
import pl.simo333.app.domain.Author;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorDao authorDao;

    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public Author saveAuthor(Author author) {
        authorDao.saveAuthor(author);
        return author;
    }

    public Author findById(long id) {
        return authorDao.findById(id);
    }

    public List<Author> findAll() {
        return authorDao.findAll();
    }

    public Author update(Author author) {
        authorDao.update(author);
        return author;
    }

    public void delete(long id) {
        authorDao.delete(id);
    }
}