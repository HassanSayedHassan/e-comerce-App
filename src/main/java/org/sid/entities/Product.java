package org.sid.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor  @ToString
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private double currentPrice;
	private boolean promotion;
	private boolean selected;
	private boolean available;
	private String photoName;
	@Transient
	private int quantity = 1;
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private Category category;
//	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
//	private Order order;
}
