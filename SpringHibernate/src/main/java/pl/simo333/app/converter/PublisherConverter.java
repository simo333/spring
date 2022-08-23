package pl.simo333.app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.simo333.app.domain.Publisher;
import pl.simo333.app.service.PublisherService;

public class PublisherConverter implements Converter<String, Publisher> {

    private PublisherService service;

    @Autowired
    public void setService(PublisherService service) {
        this.service = service;
    }

    @Override
    public Publisher convert(String id) {
        return service.findById(Long.parseLong(id));
    }
}
