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

import com.niit.shoppingcart.d.ProductDAO;
import com.niit.shoppingcart.model.Product;

@Controller
public class ProductController {
	Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private Product product;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listProducts(Model model) {
		log.debug("Start of method to list the products");
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("isAdminClickedProducts", "true");
		log.debug("End of method to list the products");
		return "/index";
	}

	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("product") Product product, Model model) {
		log.debug("Start of method add product");
		log.debug("id:" + product.getId());
		if (productDAO.addOrUpdate(product) == true) {
			model.addAttribute("messgae", "Successfully created or updated the product");
		} else {
			model.addAttribute("message", "not able to add/update the product");
		}
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("isAdminClickedProducts", "true");
		log.debug("End of method add product");
		return "/index";
	}
	
	@RequestMapping("deleteproduct/{id}" )
	public String deleteProduct(@PathVariable("id") String id, Model model)throws Exception{
		log.debug("start of method delete category");
		boolean flag=productDAO.delete(id);
		String msg="Successfully deleted";
		if(flag!=true)
			msg="Failure of delete";
		model.addAttribute("msg",msg);
		
		log.debug("End of method delete product");
		return "forward:/";
	}
	
	@RequestMapping("updateproduct/{id}" )
	public String updateProduct(@PathVariable("id") String id, Model model)throws Exception{
		log.debug("start of method delete product");
		product=productDAO.get(id);
		model.addAttribute("category", product);
		log.debug("End of method update product");
		return "forward:/";
	}
	
}
