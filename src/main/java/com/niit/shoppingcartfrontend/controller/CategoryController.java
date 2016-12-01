package com.niit.shoppingcartfrontend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.d.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Controller
public class CategoryController {
	Logger log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listCategories(Model model) {
		log.debug("Start of method to list the categories");
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("isAdminClickedCategories", "true");
		log.debug("End of method to list the categories");
		return "/index";
	}

	@RequestMapping(value = "/addcategory", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category, Model model) {
		log.debug("Start of method add category");
		log.debug("id:" + category.getId());
		if (categoryDAO.addOrUpdate(category) == true) {
			model.addAttribute("messgae", "Successfully created or updated the category");
		} else {
			model.addAttribute("message", "not able to add/update the category");
		}
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("isAdminClickedCategories", "true");
		log.debug("End of method add category");
		return "/index";
	}
	
	@RequestMapping("deletecategory/{id}" )
	public String deleteCategory(@PathVariable("id") String id, Model model)throws Exception{
		log.debug("start of method delete category");
		boolean flag=categoryDAO.delete(id);
		String msg="Successfully deleted";
		if(flag!=true)
			msg="Failure of delete";
		model.addAttribute("msg",msg);
		
		log.debug("End of method delete category");
		return "forward:/";
	}
	
	@RequestMapping("updatecategory/{id}" )
	public String updateCategory(@PathVariable("id") String id, Model model)throws Exception{
		log.debug("start of method delete category");
		category=categoryDAO.get(id);
		model.addAttribute("category", category);
		log.debug("End of method update category");
		return "forward:/";
	}
	
}
