package pl.simo333.app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.simo333.app.domain.Book;
import pl.simo333.app.service.BookService;

public class BookConverter implements Converter<String, Book> {

    private BookService service;

    @Autowired
    public void setService(BookService service) {
        this.service = service;
    }

    @Override
    public Book convert(String id) {
        return service.findById(Long.parseLong(id));
    }
}
