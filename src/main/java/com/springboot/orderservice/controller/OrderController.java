package com.springboot.orderservice.controller;

import com.springboot.orderservice.model.Order;
import com.springboot.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/v1/order-details")
public class OrderController {

    @Autowired
    public OrderService orderService;

    @PostMapping("/v1/add-order")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        Order addedOrder=orderService.addOrder(order);
        return new ResponseEntity<>(addedOrder, HttpStatus.OK);
    }

    @GetMapping("/v1/get-all-orders")
    public ResponseEntity<List<Order>> getAllOrder(){
        List<Order> orderList=orderService.getAllOrders();
        return new ResponseEntity<>(orderList,HttpStatus.OK);
    }

    @GetMapping("/v1/find-by-order-id/{id}")
    public ResponseEntity<Order> findByOrderId(@PathVariable int id){
        Order order=orderService.findByOrderId(id);
        return new ResponseEntity<Order>(order,HttpStatus.OK);
    }

    @GetMapping("/v1/sorted-order-list")
    public ResponseEntity<List<Order>> sortedOrderList(){
        List<Order> orderList=orderService.sortedOrderList();
        return new ResponseEntity<>(orderList,HttpStatus.OK);
    }
}
