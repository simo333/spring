package pl.simo333.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.simo333.domain.Category;
import pl.simo333.repository.CategoryDao;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category-add";
    }
    @PostMapping("/add")
    public String addCategory(Category category) {
        categoryDao.save(category);
        return "category-add";
    }
}
