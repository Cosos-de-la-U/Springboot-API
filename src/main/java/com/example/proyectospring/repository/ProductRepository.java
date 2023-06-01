package com.example.proyectospring.repository;

import com.example.proyectospring.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
