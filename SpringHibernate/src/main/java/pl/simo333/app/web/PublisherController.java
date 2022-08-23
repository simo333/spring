package pl.simo333.app.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.simo333.app.domain.Publisher;
import pl.simo333.app.service.PublisherService;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @RequestMapping("/add")
    public String addPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Publisher");
        publisherService.savePublisher(publisher);
        return "Id dodanego publishera to: " + publisher.getId();
    }

    @RequestMapping("/get/{id}")
    public String getPublisher(@PathVariable long id) {
        Publisher author = publisherService.findById(id);
        return author.toString();
    }

    @RequestMapping("/update/{id}/{name}")
    public String updatePublisher(@PathVariable long id, @PathVariable String name) {
        Publisher publisher = publisherService.findById(id);
        publisher.setName(name);
        publisherService.update(publisher);
        return publisher.toString();
    }

    @RequestMapping("/delete/{id}")
    public String deletePublisher(@PathVariable long id) {
        publisherService.delete(id);
        return "deleted";
    }
}