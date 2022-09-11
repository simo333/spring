package pl.simo333.repository;

import org.hibernate.Hibernate;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import pl.simo333.domain.Author;
import pl.simo333.domain.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

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

    public void delete(Long id) {
        Category attached = findById(id);
        if (attached.getArticles().isEmpty()) {
            entityManager.remove(entityManager.contains(attached) ?
                    attached : entityManager.merge(attached));
        }
        throw new IllegalStateException("Cannot remove due to articles attached.");
    }
}
