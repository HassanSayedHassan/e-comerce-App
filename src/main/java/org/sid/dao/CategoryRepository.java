package org.sid.dao;

import org.sid.entities.Category;
import org.sid.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
@CrossOrigin("*")
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long>{
//	@RestResource(path = "id",rel = "id")
////	
//	@Query("select p from Product p, Category c WHERE c.id =:id")
//	public Page<Product> findProductsByCategoryId( @Param("id")Long id, Pageable pageable);
////	
//	//List<Product> findByCategoriesId(long id, Pageable pageable);

}
