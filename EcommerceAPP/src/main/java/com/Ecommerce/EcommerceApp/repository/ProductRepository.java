package com.Ecommerce.EcommerceApp.repository;

import com.Ecommerce.EcommerceApp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByCategoryId(Long categoryId);

}
