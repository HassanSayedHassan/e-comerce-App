package org.sid.dao;

import java.util.List;

import org.sid.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
@RepositoryRestResource
public interface ProductRepository  extends JpaRepository<Product, Long>{
 @RestResource(path = "/selectedProducts")
 public List<Product> findBySelectedIsTrue();
 @RestResource(path = "/productsByKeyword")
 public List<Product> findByNameContains(String mc);
}
