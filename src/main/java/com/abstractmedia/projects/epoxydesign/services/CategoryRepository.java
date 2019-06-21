package com.abstractmedia.projects.epoxydesign.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abstractmedia.projects.epoxydesign.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Optional<Category> findByCategoryLink(String categoryLink);
	
}
