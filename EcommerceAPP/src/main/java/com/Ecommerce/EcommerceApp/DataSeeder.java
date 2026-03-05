package com.Ecommerce.EcommerceApp;


import com.Ecommerce.EcommerceApp.models.Category;
import com.Ecommerce.EcommerceApp.models.Product;
import com.Ecommerce.EcommerceApp.repository.CategoryRepository;
import com.Ecommerce.EcommerceApp.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private  CategoryRepository categoryRepository;
    private  ProductRepository productRepository;

    public DataSeeder(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
     //we will start the code from here
        //to clear the data in db
        productRepository.deleteAll();
        categoryRepository.deleteAll();


        //create category
        Category Electronics=new Category();
        Electronics.setName("Electronics");

        Category clothing=new Category();
        clothing.setName("Clothing");

        Category home=new Category();
        home.setName("home and kitchen");

        //to save all categories at a time, we use arrays
        categoryRepository.saveAll(Arrays.asList(Electronics,home,clothing));

        //create product in category
        Product watch=new Product();
        watch.setName("Noise Smart Watch");
        watch.setDescription("latest model noise smart watch with amazing features");
        watch.setCategory(Electronics);
        watch.setPrice(1999.00);
        watch.setImage_url("https://placehold.co/600x400");

        Product mouse=new Product();
        mouse.setName("protonics wireless mouse");
        mouse.setDescription("wireless mouse with dual functionality");
        mouse.setCategory(Electronics);
        mouse.setPrice(499.00);
        mouse.setImage_url("https://placehold.co/600x400");

        Product towel=new Product();
        towel.setName("cotton towel");
        towel.setDescription("super smooth cotton towel for kids");
        towel.setCategory(clothing);
        towel.setPrice(399.00);
        towel.setImage_url("https://placehold.co/600x400");

        Product hoodie=new Product();
        hoodie.setName("cotton hoodie");
        hoodie.setDescription("super smooth cotton hoodie for women");
        hoodie.setCategory(clothing);
        hoodie.setPrice(399.00);
        hoodie.setImage_url("https://placehold.co/600x400");

        Product kettle=new Product();
        kettle.setName("superfast heat kettle");
        kettle.setDescription("kettle with the best heat control features");
        kettle.setCategory(home);
        kettle.setPrice(1399.00);
//        kettle.setImage_url("https://www.bing.com/images/search?view=detailV2&ccid=IdIl1sRd&id=62871DB9981AAE8444457627C3F5A4C7C614B2C4&thid=OIP.IdIl1sRdQD0FvYlfKz710wHaHv&mediaurl=https%3a%2f%2fpngimg.com%2fuploads%2fkettle%2fkettle_PNG8703.png&exph=1319&expw=1261&q=kettle+img&FORM=IRPRST&ck=4C299EED98C695214EDFFA8FCB64F880&selectedIndex=1&itb=1");
        kettle.setImage_url("https://placehold.co/600x400");
        productRepository.saveAll(Arrays.asList(watch,towel,kettle,hoodie,mouse));
    }
}
