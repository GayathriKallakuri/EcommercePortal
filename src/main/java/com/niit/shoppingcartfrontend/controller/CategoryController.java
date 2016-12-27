package com.niit.shoppingcartfrontend.controller;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.d.CategoryDAO;
import com.niit.shoppingcart.d.ProductDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

@Controller
public class CategoryController {
	Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listCategories(Model model) {
		log.debug("Start of method to list the categories");
		List<Category> cList = categoryDAO.list();
		List<Product> productList = productDAO.list();
		List<List> categoryList = new ArrayList(new ArrayList<Product>(10));
		String[] categoryNameList = new String[categoryList.size()];
		for (int i = 0; i < categoryList.size(); i++) {
			categoryNameList[i] = categoryDAO.get(categoryDAO.get(i + 1).getId())
					.getName();
			List<Product> productsByCategoryId = productDAO.productByCategory(i + 1);
			categoryList.add(productsByCategoryId);
			System.out.println("categoryNameList " + categoryNameList[i]);

		}
		model.addAttribute("product", product);
		model.addAttribute("category", category);
		model.addAttribute("ProductList", productList);
		model.addAttribute("CategoryList", cList);
		model.addAttribute("isCategoryClicked", "true");
		model.addAttribute("isProductClicked", "true");
		model.addAttribute("product",productDAO);
		log.debug("End of method to list the categories");
		return "/index";
	}

	@RequestMapping(value = "addcategory", method = RequestMethod.POST)
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
		model.addAttribute("adminClickedCategory", "true");
		log.debug("End of method add category");
		return "redirect:./Category";
	}
	
	@RequestMapping(value="deletecategory/{id}" ,  method = RequestMethod.GET)
	public ModelAndView deleteCategory(@PathVariable("id") int id){
		log.debug("start of method delete category");
		categoryDAO.delete(id);
		ModelAndView mv = new ModelAndView("redirect:/Category");
		List<Category> category = categoryDAO.list();
		mv.addObject("Categoryitems", category);
		log.debug("End of method delete category");
		return mv; 
	}
	
	@RequestMapping(value="updatecategory/{id}" , method = RequestMethod.GET)
	public ModelAndView updateCategory(@ModelAttribute("category") Category category){
		log.debug("start of method update category");
		ModelAndView mv= new ModelAndView("redirect:/Category");
		categoryDAO.update(category);
		log.debug("End of method update category");
		return mv;
	}
	
	@RequestMapping(value="Category/editcategory/{id}" , method = RequestMethod.GET)
	public ModelAndView editCategory(@PathVariable("id") int id){
		log.debug("start of method edit category");
		ModelAndView mv=new ModelAndView("/index","command",categoryDAO.get(id));
		mv.addObject("adminClickedAddCategory","true");
		//List<Category> category = categoryDAO.list();
		//mv.addObject("Categoryitems", category);
		log.debug("End of method edit category");
		return mv;
	}
	
}
