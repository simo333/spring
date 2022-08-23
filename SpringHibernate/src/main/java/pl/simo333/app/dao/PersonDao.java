package pl.simo333.app.dao;

import org.springframework.stereotype.Repository;
import pl.simo333.app.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Person person) {
        entityManager.persist(person);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void update(Person person) {
        entityManager.merge(person);
    }

    public void delete(long id) {
        entityManager.remove(entityManager.contains(id) ?
                id : entityManager.merge(id));
    }
}