package com.example.proyectospring.repository;

import com.example.proyectospring.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
