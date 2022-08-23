package pl.simo333.app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.simo333.app.domain.Author;
import pl.simo333.app.service.AuthorService;

public class AuthorConverter implements Converter<String, Author> {

    private AuthorService service;

    @Autowired
    public void setService(AuthorService service) {
        this.service = service;
    }

    @Override
    public Author convert(String id) {
        return service.findById(Long.parseLong(id));
    }
}
