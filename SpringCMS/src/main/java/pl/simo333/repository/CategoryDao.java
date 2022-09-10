package pl.simo333.repository;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import pl.simo333.domain.Author;
import pl.simo333.domain.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Category category) {
        entityManager.persist(category);
    }

    public Category findById(long id) {
        return entityManager.find(Category.class, id);
    }

    public List<Category> findAll() {
        return entityManager.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public void delete(Category category) {
        Category attached = entityManager
                .createQuery("SELECT c FROM Category c JOIN FETCH c.articles WHERE c.id = ?1", Category.class)
                .setParameter(1, category.getId())
                .getSingleResult();
        attached.getArticles().forEach(article -> article.removeCategory(category));

        entityManager.remove(entityManager.contains(attached) ?
                attached : entityManager.merge(attached));
    }
}
