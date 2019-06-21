package com.abstractmedia.projects.epoxydesign.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.abstractmedia.projects.epoxydesign.features.Cart;
import com.abstractmedia.projects.epoxydesign.features.DomainInfo;
import com.abstractmedia.projects.epoxydesign.features.SessionHelper;
import com.abstractmedia.projects.epoxydesign.model.Category;
import com.abstractmedia.projects.epoxydesign.model.Subcategory;
import com.abstractmedia.projects.epoxydesign.services.CategoryRepository;
import com.abstractmedia.projects.epoxydesign.services.ProductRepositoryImpl;
import com.abstractmedia.projects.epoxydesign.services.SubcategoryRepository;
import com.abstractmedia.projects.epoxydesign.model.product.Product;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private SubcategoryRepository subcategoryRepository;
	@Autowired
	private ProductRepositoryImpl productRepositoryImpl;
	@Autowired
	private SessionHelper sessionHelper;
	@Autowired
	private Cart cart;

	/* CATEGORY PAGE */
	@GetMapping("/products/{categoryName}")
	public String getCategoryPage(Model model, @PathVariable String categoryName,
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "sb", required = false, defaultValue = "name") String sortBy,
			@RequestParam(value = "sd", required = false, defaultValue = "ASC") String direction, HttpSession session) {

		// Take category
		Optional<Category> category = categoryRepository.findByCategoryLink(categoryName);

		// if category exists
		if (category.isPresent()) {

			// take list of subcategories fromt that category
			List<Subcategory> subcategories = category.get().getSubcategories();

			// get products for given category
			Page<Product> products = productRepositoryImpl.getProductsByCategory(category.get(), page, direction,
					sortBy, 20);

			model.addAttribute("products", products);
			model.addAttribute("hasNextPage", products.hasNext());
			// plus 2 because page object is 0 indexed and one more for next page
			model.addAttribute("nextPage", products.getNumber() + 2);
			model.addAttribute("category", category.get());
			model.addAttribute("subcategories", subcategories);
			model.addAttribute("title",
					String.format("%s - %s", category.get().getTitle(), DomainInfo.getDomainName()));
			model.addAttribute("categories", sessionHelper.getCategories(session));
			model.addAttribute("sb", sortBy);
			model.addAttribute("sd", direction);
			Map<Integer, Product> sessionCart = sessionHelper.getCart(session);

			List<Product> cartItems = cart.getCartItems(sessionCart);
			model.addAttribute("cartItems", cartItems);
			model.addAttribute("cartTotal", cart.calcCartSubTotal(cartItems));

			return "category";
		}

		return "404";

	}

	/* SUBCATEGORY PAGE */
	@GetMapping("/products/{categoryName}/{subcategory}")
	public String getSubCategoryPage(Model model, @PathVariable String categoryName, @PathVariable String subcategory,
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "sb", required = false, defaultValue = "name") String sortBy,
			@RequestParam(value = "sd", required = false, defaultValue = "ASC") String direction, HttpSession session) {

		Optional<Category> category = categoryRepository.findByCategoryLink(categoryName);

		if (category.isPresent()) {

			Optional<Subcategory> optinalSubcateg = subcategoryRepository.findByLink(subcategory);

			if (optinalSubcateg.isPresent()) {

				// get products for given category
				Page<Product> products = productRepositoryImpl.getProductsBySubcategory(optinalSubcateg.get(), page,
						direction, sortBy, 20);
				// take list of subcategories fromt that category
				List<Subcategory> subcategories = category.get().getSubcategories();
				model.addAttribute("category", category.get());
				model.addAttribute("products", products);
				model.addAttribute("hasNextPage", products.hasNext());
				model.addAttribute("subcategory", optinalSubcateg.get());
				model.addAttribute("subcategories", subcategories);
				model.addAttribute("categories", sessionHelper.getCategories(session));
				model.addAttribute("sb", sortBy);
				model.addAttribute("sd", direction);
				Map<Integer, Product> sessionCart = sessionHelper.getCart(session);

				List<Product> cartItems = cart.getCartItems(sessionCart);
				model.addAttribute("cartItems", cartItems);
				model.addAttribute("cartTotal", cart.calcCartSubTotal(cartItems));
				// model.addAttribute("title",String.format("%s | %s",
				// ToTitleCase.convert(subcategory.),DomainInfo.getDomainName()));
				return "subcategory";
			} else
				return "404";
		}

		return "404";
	}

}
