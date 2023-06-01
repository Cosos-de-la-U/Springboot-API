package com.example.proyectospring.controller;

import com.example.proyectospring.model.Product;
import com.example.proyectospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping
    public ArrayList<Product> getProducts(){
        return (ArrayList<Product>) productService.getProducts();
    }
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }
    @PostMapping
    public Product postProduct(@RequestBody Product product){
        return productService.postProduct(product);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        try {
            Product data =  productService.getProductById(id).get();
            boolean ok = productService.deleteProduct(id);
            if(ok) return ResponseEntity.ok(String.format("%s was removed!", data.getName()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("%s was NOT removed!, something happened!", data.getName()));
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Something wrong happened!"));
        }
    }
}
