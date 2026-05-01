package com.springboot.practise.Controller;

import com.springboot.practise.dto.ProductResponseV1;
import com.springboot.practise.dto.ProductResponseV2;
import com.springboot.practise.model.Product;
import com.springboot.practise.model.ProductV2;
import com.springboot.practise.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping(version = "1")
    public List<ProductResponseV1> getAllProductResposneV1(){

        try{
            return  service.getAllProducts().stream().map(this::getProductResponseV1).collect(Collectors.toList());
        } catch (Exception e) {
           return  fallBackException((RuntimeException) e);
        }

    }

    private List<ProductResponseV1> fallBackException(RuntimeException e) {
        System.out.println("This Method will triggered the exception !!!");
        return Collections.emptyList();
    }

    @GetMapping(version = "2")
    public ProductResponseV2 getAllProductResposneV2() throws InterruptedException {
        List<Product> allProducts = service.getAllProducts();
        return this.getProductResponseV2(allProducts);

    }

    private ProductResponseV1 getProductResponseV1(Product product) {
        return  new ProductResponseV1(product.id(), product.name(), product.price());
    }

    private ProductResponseV2 getProductResponseV2(List<Product> product) {

        List<ProductV2> collect = product.stream().map(p -> new ProductV2(p.id(), p.name(), p.price(), p.description(), p.category())).collect(Collectors.toList());
        return  new ProductResponseV2(collect,product.size());
    }
}
