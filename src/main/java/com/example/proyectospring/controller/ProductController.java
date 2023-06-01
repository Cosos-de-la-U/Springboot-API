package com.example.proyectospring.controller;

import com.example.proyectospring.model.Product;
import com.example.proyectospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ArrayList<Product> getProducts(){
        return (ArrayList<Product>) productService.getProducts();
    }

    @PostMapping
    public Product postProduct(@RequestBody Product product){
        return productService.postProduct(product);
    }
}
