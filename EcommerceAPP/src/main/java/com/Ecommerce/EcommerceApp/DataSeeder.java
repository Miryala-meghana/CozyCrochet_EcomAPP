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
        Category KeyChains=new Category();
        KeyChains.setName("KeyChains");

        Category Dolls=new Category();
        Dolls.setName("Dolls");

        Category BabyFrocks=new Category();
        BabyFrocks.setName("BabyFrocks");

        Category Bouquets=new Category();
        Bouquets.setName("Bouquets");

        Category Socks=new Category();
        Socks.setName("Socks");

        //to save all categories at a time, we use arrays
        categoryRepository.saveAll(Arrays.asList(Dolls,BabyFrocks,KeyChains,Bouquets,Socks));

        //create product in category
        Product babyRuffles=new Product();
        babyRuffles.setName("baby ruffles");
        babyRuffles.setDescription("cute baby ruffles made with love");
        babyRuffles.setCategory(Socks);
        babyRuffles.setPrice(1999.00);
        babyRuffles.setImage_url("http://localhost:8080/images/babyruffles.jpg");
        productRepository.save(babyRuffles);

        Product blue=new Product();
        blue.setName("blue&pink socks");
        blue.setDescription("beautiful blue pink socks");
        blue.setCategory(Socks);
        blue.setPrice(299.00);
        blue.setImage_url("http://localhost:8080/images/bluepinksocks.jpg");
        productRepository.save(blue);

        //BOUQUETS

        Product bluerosebou=new Product();
        bluerosebou.setName("Blue bouquet");
        bluerosebou.setDescription("Bold blue rose");
        bluerosebou.setCategory(Bouquets);
        bluerosebou.setPrice(899.00);
        bluerosebou.setImage_url("http://localhost:8080/images/bluerosebou.jpg");
        productRepository.save(bluerosebou);


        Product heartbouquet=new Product();
        heartbouquet.setName("heartbouquet");
        heartbouquet.setDescription("heartfelt bouquet");
        heartbouquet.setCategory(Bouquets);
        heartbouquet.setPrice(399.00);
        heartbouquet.setImage_url("http://localhost:8080/images/heartbouquet.jpg");
        productRepository.save(heartbouquet);

        Product minibouquet=new Product();
        minibouquet.setName("minibouquet");
        minibouquet.setDescription("mini flower bouquet");
        minibouquet.setCategory(Bouquets);
        minibouquet.setPrice(569.00);
        minibouquet.setImage_url("http://localhost:8080/images/minibouquet.jpg");
        productRepository.save(minibouquet);

        Product rosebouquet=new Product();
        rosebouquet.setName("rose bouquet");
        rosebouquet.setDescription("rose flower bouquet");
        rosebouquet.setCategory(Bouquets);
        rosebouquet.setPrice(559.00);
        rosebouquet.setImage_url("http://localhost:8080/images/rosebouquet.jpg");
        productRepository.save(rosebouquet);

        //DOLLS
        Product cottagedoll=new Product();
        cottagedoll.setName("cottage doll");
        cottagedoll.setDescription("pretty doll");
        cottagedoll.setCategory(Dolls);
        cottagedoll.setPrice(599.00);
        cottagedoll.setImage_url("http://localhost:8080/images/cottagedoll.jpg");
        productRepository.save(cottagedoll);

        Product krishnaDoll=new Product();
        krishnaDoll.setName("krishnaDoll");
        krishnaDoll.setDescription("pretty Krishna doll");
        krishnaDoll.setCategory(Dolls);
        krishnaDoll.setPrice(999.00);
        krishnaDoll.setImage_url("http://localhost:8080/images/krishnaDoll.jpeg");
        productRepository.save(krishnaDoll);

        Product pandaDoll=new Product();
        pandaDoll.setName("pandaDoll");
        pandaDoll.setDescription("pretty panda");
        pandaDoll.setCategory(Dolls);
        pandaDoll.setPrice(499.00);
        pandaDoll.setImage_url("http://localhost:8080/images/pandaDoll.jpeg");
        productRepository.save(pandaDoll);

        Product deviDoll =new Product();
        deviDoll.setName("deviDoll");
        deviDoll.setDescription("devotional devi");
        deviDoll.setCategory(Dolls);
        deviDoll.setPrice(499.00);
        deviDoll.setImage_url("http://localhost:8080/images/deviDoll.jpeg");
        productRepository.save(deviDoll);

        //KEYCHAINS

        Product evileyekey=new Product();
        evileyekey.setName("evileye key");
        evileyekey.setDescription("protects you from the NASAR");
        evileyekey.setCategory(KeyChains);
        evileyekey.setPrice(399.00);
        evileyekey.setImage_url("http://localhost:8080/images/evileyekey.jpg");
        productRepository.save(evileyekey);

        Product flowerkey=new Product();
        flowerkey.setName("flower keychain");
        flowerkey.setDescription("cute Flowers keyChain");
        flowerkey.setCategory(KeyChains);
        flowerkey.setPrice(199.00);
        flowerkey.setImage_url("http://localhost:8080/images/flowerkey.jpg");
        productRepository.save(flowerkey);

        Product heartkey=new Product();
        heartkey.setName("heart keychain");
        heartkey.setDescription("cute heart keyChain");
        heartkey.setCategory(KeyChains);
        heartkey.setPrice(199.00);
        heartkey.setImage_url("http://localhost:8080/images/heartkey.jpg");
        productRepository.save(heartkey);

        //BabyFrocks
        Product pinkfrock=new Product();
        pinkfrock.setName("pink frock");
        pinkfrock.setDescription("pretty pink frock");
        pinkfrock.setCategory(BabyFrocks);
        pinkfrock.setPrice(599.00);
        pinkfrock.setImage_url("http://localhost:8080/images/pinkfrock.jpg");
        productRepository.save(pinkfrock);

        Product purpelfrock=new Product();
        purpelfrock.setName("purple frock");
        purpelfrock.setDescription("pretty purple frock");
        purpelfrock.setCategory(BabyFrocks);
        purpelfrock.setPrice(499.00);
        purpelfrock.setImage_url("http://localhost:8080/images/purpelfrock.jpg");
        productRepository.save(purpelfrock);

        Product yellowfrock=new Product();
        yellowfrock.setName("yellow frock");
        yellowfrock.setDescription("pretty frock");
        yellowfrock.setCategory(BabyFrocks);
        yellowfrock.setPrice(399.00);
        yellowfrock.setImage_url("http://localhost:8080/images/yellowfrock.jpg");
        productRepository.save(yellowfrock);

    }
}
