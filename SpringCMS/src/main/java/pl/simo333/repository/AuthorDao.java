package pl.simo333.repository;

import org.springframework.stereotype.Repository;
import pl.simo333.domain.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Author author) {
        entityManager.persist(author);
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    public List<Author> findAll() {
        return entityManager.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public void delete(Author author) {
        Author attached = entityManager.merge(author);
        attached.getArticles().forEach(article -> article.setAuthor(null));

        entityManager.remove(entityManager.contains(author) ?
                author : entityManager.merge(author));
    }
}
