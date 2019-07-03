package com.abstractmedia.projects.epoxydesign.services.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abstractmedia.projects.epoxydesign.model.Subcategory;
import com.abstractmedia.projects.epoxydesign.model.Category;
import com.abstractmedia.projects.epoxydesign.model.product.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	

	Page<Product> findBySubcategory(Subcategory subcategory,Pageable pageable);
	Page<Product> findByprodCategory(Category category,Pageable pageable);


	Page<Product> findByprodCategoryAndIdNot(Category category,Integer id,Pageable pageable);
	
	@Query("Select p from Product p where p.name like %:name%")
	Page<Product> findByNameLike(String name,Pageable pageable);

}
