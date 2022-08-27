package pl.simo333.app.dao;

import org.springframework.stereotype.Repository;
import pl.simo333.app.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public List<Book> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    public List<Book> findAllByRating(double rating) {
        return entityManager.createQuery("SELECT b FROM Book b WHERE b.rating > :rating", Book.class)
                .setParameter("rating", rating)
                .getResultList();
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

    public List<Book> findAllWithPublisher() {
        return entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher IS NOT NULL", Book.class)
                .getResultList();
    }

    public List<Book> findAllWithPublisherId(long publisherId) {
        return entityManager.createQuery("SELECT b FROM Book b where b.publisher.id = :publisherId", Book.class)
                .setParameter("publisherId", publisherId)
                .getResultList();
    }

    public List<Book> findAllWithAuthorId(long authorId) {
        return entityManager.createQuery("SELECT b FROM Book b JOIN b.authors a WHERE a.id = :authorId", Book.class)
                .setParameter("authorId", authorId)
                .getResultList();
    }
}