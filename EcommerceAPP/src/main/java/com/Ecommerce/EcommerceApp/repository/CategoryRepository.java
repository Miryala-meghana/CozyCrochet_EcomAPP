package com.Ecommerce.EcommerceApp.repository;

import com.Ecommerce.EcommerceApp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
