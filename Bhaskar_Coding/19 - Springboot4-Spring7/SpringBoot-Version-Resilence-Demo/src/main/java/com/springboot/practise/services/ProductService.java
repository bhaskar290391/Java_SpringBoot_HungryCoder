package com.springboot.practise.services;

import com.springboot.practise.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();
        products.add(new Product(1L,"Iphone",999.9,"IPhone","Mobiles"));
        products.add(new Product(2L,"Samsung Galaxy",899.9,"Samsung Galaxy","Mobils"));
        products.add(new Product(3L,"Iphone Airpods",599.9,"Iphone Airpods","Accessories"));
    }

    public List<Product> getAllProducts() {
        return  new ArrayList<>(products);
    };
}
