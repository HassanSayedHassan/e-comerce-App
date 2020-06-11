package org.sid.web;

import java.util.Map;

import org.sid.entities.Client;
import org.sid.entities.Product;

import lombok.Data;

@Data
public class OrderForm {
	private Client client;
	private Caddy caddy;
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