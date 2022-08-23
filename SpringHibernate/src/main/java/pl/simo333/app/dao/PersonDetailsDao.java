package pl.simo333.app.dao;

import org.springframework.stereotype.Repository;
import pl.simo333.app.domain.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDetailsDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(PersonDetails personDetails) {
        entityManager.persist(personDetails);
    }

    public PersonDetails findById(long id) {
        return entityManager.find(PersonDetails.class, id);
    }

    public void update(PersonDetails personDetails) {
        entityManager.merge(personDetails);
    }

    public void delete(long id) {
        entityManager.remove(entityManager.contains(id) ?
                id : entityManager.merge(id));
    }
}