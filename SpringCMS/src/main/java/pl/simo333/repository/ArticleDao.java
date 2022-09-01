package pl.simo333.repository;

import org.springframework.stereotype.Repository;
import pl.simo333.domain.Article;
import pl.simo333.domain.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Article article) {
        entityManager.persist(article);
    }

    public Article findById(long id) {
        return entityManager.find(Article.class, id);
    }

    public List<Article> findAll() {
        return entityManager.createQuery("SELECT a FROM Article a", Article.class).getResultList();
    }

    public void update(Article article) {
        entityManager.merge(article);
    }

    public void delete(Article article) {
        entityManager.remove(entityManager.contains(article) ?
                article : entityManager.merge(article));
    }
}
