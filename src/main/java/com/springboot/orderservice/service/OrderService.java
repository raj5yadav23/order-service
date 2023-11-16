package com.springboot.orderservice.service;

import com.springboot.orderservice.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    public List<Order> orderList=new ArrayList<Order>();

    public Order addOrder(Order order){

        orderList.add(order);
        return order;

    }

    public List<Order> getAllOrders(){
        return orderList;
    }

    public Order findByOrderId(int order_id){
        return orderList.stream().filter(obj-> obj.getOrder_id()==order_id)
                .collect(Collectors.toList()).get(0);
    }

    public List<Order> sortedOrderList(){
        return orderList.stream().
                sorted(Comparator.comparing(Order::getOrder_id)).
                collect(Collectors.toList());
    }
}
