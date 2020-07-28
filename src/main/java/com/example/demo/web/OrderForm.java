package com.example.demo.web;

import com.example.demo.entities.Client;
import com.example.demo.entities.Product;
import lombok.Data;

import java.util.Map;

@Data
public class OrderForm {
	private Client client;
	private com.example.demo.web.Caddy caddy;
	private float totalAmount;
}

@Data
class Caddy {
	public String name;
	public Map<Integer, ProductItem> items;
	public Client client;
}

@Data
class ProductItem {
	public Product product;
	public Integer quantity;
	public Integer price;
}