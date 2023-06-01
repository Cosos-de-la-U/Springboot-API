package com.example.proyectospring.controller;

import com.example.proyectospring.model.Order;
import com.example.proyectospring.model.Product;
import com.example.proyectospring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping
    public ArrayList<Order> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Order saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id){
        try {
            Order data =  orderService.getOrderById(id).get();
            boolean ok = orderService.deleteOrder(id);
            if(ok) return ResponseEntity.ok(String.format("%s was removed!", data.getOrderId()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("%s was NOT removed!, something happened!", data.getOrderId()));
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Something wrong happened!"));
        }
    }
}
