package pl.simo333.app.service;

import org.springframework.stereotype.Service;
import pl.simo333.app.dao.PersonDetailsDao;
import pl.simo333.app.domain.PersonDetails;

@Service
public class PersonDetailsService {

    private final PersonDetailsDao personDetailsDao;

    public PersonDetailsService(PersonDetailsDao personDetailsDao) {
        this.personDetailsDao = personDetailsDao;
    }

    public PersonDetails save(PersonDetails personDetails) {
        personDetailsDao.save(personDetails);
        return personDetails;
    }

    public PersonDetails findById(long id) {
        return personDetailsDao.findById(id);
    }

    public PersonDetails update(PersonDetails personDetails) {
        personDetailsDao.update(personDetails);
        return personDetails;
    }

    public void delete(long id) {
        personDetailsDao.delete(id);
    }
}