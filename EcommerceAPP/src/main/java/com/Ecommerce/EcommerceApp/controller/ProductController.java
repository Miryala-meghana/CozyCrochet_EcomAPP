package com.Ecommerce.EcommerceApp.controller;

import com.Ecommerce.EcommerceApp.models.Product;
import com.Ecommerce.EcommerceApp.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
   private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
   @GetMapping()
    public List<Product> getAllProducts()
   {
       return productService.getAllProducts();
   }

   @GetMapping("/category/{categoryId}")
   public List<Product> getALlProductsByCategory(@PathVariable Long categoryId)
   {
       return productService.getAllProductsByCategory(categoryId);
   }
}
