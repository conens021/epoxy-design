package com.abstractmedia.projects.epoxydesign.services;

import java.util.Optional;

import com.abstractmedia.projects.epoxydesign.model.Category;
import com.abstractmedia.projects.epoxydesign.model.Subcategory;
import com.abstractmedia.projects.epoxydesign.model.product.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

@Service
public class ProductRepositoryImpl{


    @Autowired
    private ProductRepository productRepository;


    public Page<Product> findAllProducts(String page,String direction,String sortBy,Integer perPage){

        return productRepository.findAll(PageRequest.of(
            Integer.valueOf(page) -1 , perPage,
            direction.equalsIgnoreCase("asc")? Direction.ASC : Direction.DESC,
            sortBy ));

    }


    public Page<Product> getProductsByCategory(Category category,String page,String direction,String sortBy,Integer perPage){
        return productRepository.findByprodCategory(category, PageRequest.of(
                                            Integer.valueOf(page) -1 , perPage,
                                            direction.equalsIgnoreCase("asc")? Direction.ASC : Direction.DESC,
                                            sortBy ));
    }


    public Page<Product> getReleated(Category category,String page,String direction,String sortBy,Integer perPage,Integer id){
        return productRepository.findByprodCategoryAndIdNot(category, id,PageRequest.of(
                                            Integer.valueOf(page) -1 , perPage,
                                            direction.equalsIgnoreCase("asc")? Direction.ASC : Direction.DESC,
                                            sortBy ));
    }

    public Page<Product> getProductsBySubcategory(Subcategory subcategory,String page,String direction,String sortBy,Integer perPage){
        return productRepository.findBySubcategory(subcategory, PageRequest.of(
                                            Integer.valueOf(page) -1 , perPage,
                                            direction.equalsIgnoreCase("asc")? Direction.ASC : Direction.DESC,
                                            sortBy ));
    }



    public Product getById(Integer id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        }
        return new Product();
    }
    
    
    public Page<Product>getByName(String name,String page,String direction,String sortBy,Integer perPage){
    	 return productRepository.findByNameLike(name, PageRequest.of(
                 Integer.valueOf(page) -1 , perPage,
                 direction.equalsIgnoreCase("asc")? Direction.ASC : Direction.DESC,
                 sortBy ));
    }

}