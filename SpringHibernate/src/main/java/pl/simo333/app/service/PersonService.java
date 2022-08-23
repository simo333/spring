package pl.simo333.app.service;

import org.springframework.stereotype.Service;
import pl.simo333.app.dao.PersonDao;
import pl.simo333.app.domain.Person;

@Service
public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person save(Person person) {
        personDao.save(person);
        return person;
    }

    public Person findById(long id) {
        return personDao.findById(id);
    }

    public Person update(Person person) {
        personDao.update(person);
        return person;
    }

    public void delete(long id) {
        personDao.delete(id);
    }
}