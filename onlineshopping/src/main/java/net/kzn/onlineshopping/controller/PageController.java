package net.kzn.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView view = new ModelAndView("page");
		view.addObject("title", "Home");
		view.addObject("userClickHome", "true");
		view.addObject("categories",categoryDAO.list());
		return view;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {

		ModelAndView view = new ModelAndView("page");
		view.addObject("title", "About Us");
		view.addObject("userClickAbout", "true");
		return view;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {

		ModelAndView view = new ModelAndView("page");
		view.addObject("title", "Contact Us");
		view.addObject("userClickContact", "true");
		return view;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) { 

		ModelAndView view = new ModelAndView("page");
		
		Category category =null;
		category=categoryDAO.get(id);
		view.addObject("title", category.getName());
		view.addObject("userClickCategoryProducts", "true");
		view.addObject("category",category);
		view.addObject("categories",categoryDAO.list());
		
		return view;
	}
	
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() { 

		ModelAndView view = new ModelAndView("page");
		view.addObject("title", "All Products");
		view.addObject("userClickAllProducts", "true");
		view.addObject("categories",categoryDAO.list());
		return view;
	}
}
