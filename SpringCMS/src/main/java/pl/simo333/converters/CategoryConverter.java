package pl.simo333.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.simo333.domain.Author;
import pl.simo333.domain.Category;
import pl.simo333.repository.AuthorDao;
import pl.simo333.repository.CategoryDao;

public class CategoryConverter implements Converter<String, Category> {

    private CategoryDao categoryDao;

    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category convert(String id) {
        return categoryDao.findById(Long.parseLong(id));
    }
}
