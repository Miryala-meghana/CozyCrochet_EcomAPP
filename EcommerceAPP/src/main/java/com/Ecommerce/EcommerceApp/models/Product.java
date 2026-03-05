package com.Ecommerce.EcommerceApp.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image_url;
    private Double price;

    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private Category category;

}
