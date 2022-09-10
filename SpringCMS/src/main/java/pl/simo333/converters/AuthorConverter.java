package pl.simo333.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.simo333.domain.Author;
import pl.simo333.repository.AuthorDao;

public class AuthorConverter implements Converter<String, Author> {

    private AuthorDao authorDao;

    @Autowired
    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author convert(String id) {
        if(!"".equals(id)) {
            return authorDao.findById(Long.parseLong(id));
        }
        return null;
    }
}
