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

	public Client getClient( ) {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Caddy getCaddy( ) {
		return caddy;
	}

	public void setCaddy(Caddy caddy) {
		this.caddy = caddy;
	}

	public float getTotalAmount( ) {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
}

@Data
class Caddy {
	public String name;
	public Map<Integer, ProductItem> items;
	public Client client;

	public String getName( ) {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Integer, ProductItem> getItems( ) {
		return items;
	}

	public void setItems(Map<Integer, ProductItem> items) {
		this.items = items;
	}

	public Client getClient( ) {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}

@Data
class ProductItem {
	public Product product;
	public Integer quantity;
	public Integer price;

	public Product getProduct( ) {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity( ) {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice( ) {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}