package com.abstractmedia.projects.epoxydesign.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abstractmedia.projects.epoxydesign.model.Subcategory;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {

	Optional<Subcategory> findByLink(String link);
	
}
