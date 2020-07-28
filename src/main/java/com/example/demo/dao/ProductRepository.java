package com.example.demo.dao;


import com.example.demo.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
	@RestResource(path = "/selectedProducts")
	public Page<Product> findBySelectedIsTrue(Pageable pageable);

	@RestResource(path = "/productsByKeyword")
	public Page<Product> findByNameContains(String mc, Pageable pageable);
	
	@RestResource(path = "/promoProducts")
	public Page<Product> findByPromotionIsTrue(Pageable pageable);
	
	@RestResource(path = "/dispoProducts")
	public Page<Product> findByAvailableIsTrue(Pageable pageable);
	
	@RestResource(path = "/dispoPromoProducts")
	public Page<Product> findByAvailableIsTrueAndPromotionIsTrue(Pageable pageable);
	
	@RestResource(path = "/pcat" , rel = "id")
	public Page<Product> findAllProductByCategoryId(@Param("id")Long id, Pageable pageable);
	
	@RestResource(path = "/pcatDispoProducts" , rel = "id")
	public Page<Product> findAllProductByCategoryIdAndAvailableIsTrue(@Param("id")Long id, Pageable pageable);
	
	@RestResource(path = "/pcatPromoProducts" , rel = "id")
	public Page<Product> findAllProductByCategoryIdAndPromotionIsTrue(@Param("id")Long id, Pageable pageable);
	
	@RestResource(path = "/pcatPromoDispoProducts" , rel = "id")
	public Page<Product> findAllProductByCategoryIdAndPromotionIsTrueAndSelectedIsTrue(@Param("id")Long id, Pageable pageable);
	
	
}
