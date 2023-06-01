package com.example.proyectospring.service;

import com.example.proyectospring.model.Product;
import com.example.proyectospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ArrayList<Product> getProducts(){
        return (ArrayList<Product>) productRepository.findAll();
    }

    public Product postProduct(Product product){
        return productRepository.save(product);
    }
}
