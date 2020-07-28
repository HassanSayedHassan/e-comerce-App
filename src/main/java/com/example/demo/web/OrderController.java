package com.example.demo.web;


import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.OrderItemRepository;
import com.example.demo.dao.OrderRepository;
import com.example.demo.dao.ProductRepository;
import com.example.demo.entities.Client;
import com.example.demo.entities.Order;
import com.example.demo.entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class OrderController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    
    @PatchMapping("/addOrder")
    public Order saveOrder(@RequestBody OrderForm order){
        System.out.println("*********************");
        Order order_A = new Order();
        Client client = new Client();
        client= order.getClient();

        clientRepository.save(client);
        order_A.setClient(order.getClient());
        order_A.setDate(new Date());
        order_A.setTotalAmount((double) order.getTotalAmount());
        Collection<com.example.demo.entities.OrderItem> orderItems = new HashSet<OrderItem>();
        Caddy caddy = order.getCaddy();
        Map<Integer, ProductItem> items = caddy.getItems();
        for (Map.Entry<Integer, ProductItem> entry : items.entrySet()) {
        	OrderItem orderItem = new OrderItem();
        	orderItem.setId((long) entry.getKey());
        	//orderItem.setOrder(order_A);
        	orderItem.setPrice(entry.getValue().price);
        	orderItem.setProduct(entry.getValue().getProduct());
        	orderItem.setQuantity(entry.getValue().getQuantity());
        	orderItems.add(orderItem);
        	orderItemRepository.save(orderItem);
        }
        order_A.setOrderItems(orderItems);
        orderRepository.save(order_A);
       
        return order_A;
    }

}
