package pl.simo333.app.service;

import org.springframework.stereotype.Service;
import pl.simo333.app.dao.PublisherDao;
import pl.simo333.app.domain.Publisher;

import java.util.List;

@Service
public class PublisherService {

    private final PublisherDao publisherDao;

    public PublisherService(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    public Publisher savePublisher(Publisher publisher) {
        if (publisher.getId() != null) {
            publisherDao.update(publisher);
        } else {
            publisherDao.savePublisher(publisher);
        }
        return publisher;
    }

    public List<Publisher> findAll() {
        return publisherDao.findAll();
    }

    public Publisher findById(long id) {
        return publisherDao.findById(id);
    }

    public Publisher update(Publisher publisher) {
        publisherDao.update(publisher);
        return publisher;
    }

    public void delete(long id) {
        Publisher publisher = findById(id);
        publisherDao.delete(publisher);
    }
}