package com.springboot.practise.Controller;

import com.springboot.practise.dto.ProductResponseV1;
import com.springboot.practise.model.Product;
import com.springboot.practise.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/v1")
    public List<ProductResponseV1> getAllProductResposneV1(){
        return  service.getAllProducts().stream().map(this::getProductResponseV1).collect(Collectors.toList());
    }

    private ProductResponseV1 getProductResponseV1(Product product) {
        return  new ProductResponseV1(product.id(), product.name(), product.price());
    }
}
