package pl.simo333.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.simo333.domain.Category;
import pl.simo333.repository.CategoryDao;

import javax.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping
    public String showCategories(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
        return "category/all";
    }

    @GetMapping("/add")
    public String addCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping("/add")
    public String addCategory(@Valid Category category, BindingResult result) {
        if(result.hasErrors()) {
            return "category/add";
        }
        categoryDao.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String editCategoryForm(Model model, @PathVariable Long id) {
        model.addAttribute("category", categoryDao.findById(id));
        return "category/edit";
    }

    @PostMapping("/edit")
    public String editCategory(@Valid Category category, BindingResult result) {
        if(result.hasErrors()) {
            return "category/edit";
        }
        categoryDao.update(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryDao.delete(categoryDao.findById(id));
        return "redirect:/categories";
    }

}
