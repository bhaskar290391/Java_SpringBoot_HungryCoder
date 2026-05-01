package com.springboot.practise.services;

import com.springboot.practise.model.Product;
import org.springframework.resilience.annotation.ConcurrencyLimit;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProductService {
    private final List<Product> products;
    public AtomicInteger attemptCount=new AtomicInteger(0);
    public AtomicInteger active=new AtomicInteger(0);

    public ProductService() {
        this.products = new ArrayList<>();
        products.add(new Product(1L,"Iphone",999.9,"IPhone","Mobiles"));
        products.add(new Product(2L,"Samsung Galaxy",899.9,"Samsung Galaxy","Mobils"));
        products.add(new Product(3L,"Iphone Airpods",599.9,"Iphone Airpods","Accessories"));
    }

    @Retryable(
            maxRetries = 4,
            delay = 100,
            multiplier = 2,
            jitter = 10,
            maxDelay = 100
    )
    @ConcurrencyLimit(2)
    public List<Product> getAllProducts() {

        //Print log for retryable
        int attempt=attemptCount.incrementAndGet();
        System.out.println("Attempt : "+ attempt);

        if(attempt <=10){
            System.out.println("Failed Attempt :"+attempt);
            throw  new RuntimeException("Simulate exception");
        }

        System.out.println("Success Attempt");
        attemptCount.set(0);
        return  new ArrayList<>(products);
    };
}
