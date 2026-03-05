package com.Ecommerce.EcommerceApp.service;

import com.Ecommerce.EcommerceApp.models.Product;
import com.Ecommerce.EcommerceApp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
}
