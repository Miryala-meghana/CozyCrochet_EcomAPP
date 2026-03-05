package com.Ecommerce.EcommerceApp.controller;

import com.Ecommerce.EcommerceApp.models.Category;
import com.Ecommerce.EcommerceApp.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<Category> getAllCategories()
    {
        return categoryService.getAllCategories();
    }

}
