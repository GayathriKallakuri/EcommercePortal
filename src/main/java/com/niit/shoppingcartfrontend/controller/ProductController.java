package com.niit.shoppingcartfrontend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.d.ProductDAO;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

@Controller

public class ProductController {
	Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private Product product;

	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listProducts(Model model) {
		log.debug("Start of method to list the products");
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("isAdminClickedProducts", "true");
		log.debug("End of method to list the products");
		return "/index";
	}*/

	@RequestMapping(value = "Product/addproduct" ,  method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, Model model) {
		log.debug("Start of method add product");
		log.debug("id:" + product.getId());
		if (productDAO.addOrUpdate(product) == true) {
			model.addAttribute("messgae", "Successfully created or updated the product");
		} else {
			model.addAttribute("message", "not able to add/update the product");
		}
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("adminClickedProduct", "true");
		log.debug("End of method add product");
		return "redirect:./";
	}
	
	@RequestMapping(value="deleteproduct/{id}" ,  method = RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable("id") int id){
		log.debug("start of method delete product");
		productDAO.delete(id);
		ModelAndView mv = new ModelAndView("redirect:/product");
		List<Product> product = productDAO.list();
		mv.addObject("Productlist", product);
		log.debug("End of method delete product");
		return mv; 
	}
	
	@RequestMapping("updateproduct/{id}" )
	public String updateProduct(@PathVariable("id") int id, Model model)throws Exception{
		log.debug("start of method delete product");
		product=productDAO.get(id);
		model.addAttribute("category", product);
		log.debug("End of method update product");
		return "forward:/";
	}

	@RequestMapping(value="editproduct/{id}" , method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable("id") int id){
		log.debug("start of method edit product");
		ModelAndView mv=new ModelAndView("/index","command",productDAO.get(id));
		mv.addObject("adminClickedAddProduct","true"); 
		log.debug("End of method edit product");
		return mv;
	}
}
