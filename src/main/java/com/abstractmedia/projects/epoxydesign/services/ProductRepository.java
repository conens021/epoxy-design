package com.abstractmedia.projects.epoxydesign.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.abstractmedia.projects.epoxydesign.model.Subcategory;
import com.abstractmedia.projects.epoxydesign.model.Category;
import com.abstractmedia.projects.epoxydesign.model.product.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	

	Page<Product> findBySubcategory(Subcategory subcategory,Pageable pageable);
	Page<Product> findByprodCategory(Category category,Pageable pageable);


	Page<Product> findByprodCategoryAndIdNot(Category category,Integer id,Pageable pageable);

}
