package com.niit.shoppingcartfrontend.controller;



import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.d.CategoryDAO;
import com.niit.shoppingcart.d.ProductDAO;
import com.niit.shoppingcart.d.SupplierDAO;
import com.niit.shoppingcart.d.UserDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;


@Controller
public class HomeController {
	Logger log = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private Category category;
	
	@Autowired 
	private Supplier supplier;
	
	@Autowired 
	private Product product;
	
	@Autowired
	 User user;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired 
	private ProductDAO productDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/")
	public ModelAndView onLoad (HttpSession session)
	{
		log.debug("start of onload");
		ModelAndView mv=new ModelAndView("/index");
		session.setAttribute("category", category);
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);
		
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("supplierList", supplierDAO.list());
		log.debug("end of onload");
		
	return mv;
	} 

	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public ModelAndView login()
	{
		log.debug("start of login");
		ModelAndView mv= new ModelAndView("/index","command", new User() );
		//mv.addObject("user", user);
		mv.addObject("isUserClickedLogin", "true");
		log.debug("end oflogin");
		return mv;
	}
	
	@RequestMapping(value="/register" , method=RequestMethod.GET)
	public ModelAndView register()
	{
		log.debug("start of register");
		ModelAndView mv=new ModelAndView("/index","command",new User());
		//mv.addObject("user", user);
		mv.addObject("isUserClickedRegister","true");
		log.debug("end of register");
		return mv;
	}
	

	@RequestMapping("/aboutus")
	public String about(Model model)
	{
		model.addAttribute("userClickedAboutus","True");
		return "index";
	}
	@RequestMapping("/contact")
	public String contact(Model model)
	{
		model.addAttribute("userClickedContact","True");
		return "index";
	}
	
	@RequestMapping(value="/Category", method=RequestMethod.GET)
	public ModelAndView category()
	{
		log.debug("start of Category");
		ModelAndView mv=new ModelAndView("/index","command",new Category());
		mv.addObject("adminClickedAddCategory","true");
		log.debug("end of Category");
		return mv;
	}
	
	@RequestMapping(value="/supplier", method=RequestMethod.GET)
	public ModelAndView supplier()
	{
		log.debug("start of supplier");
		ModelAndView mv=new ModelAndView( "/index","command",new Supplier());
		mv.addObject("adminClickedAddSupplier","true");
		log.debug("end of supplier");
		return mv;
	}
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public ModelAndView product()
	{
		log.debug("start of product");
		ModelAndView mv=new ModelAndView( "/index","command",new Product());
		mv.addObject("adminClickedAddProduct","true");
		log.debug("end of product");
		return mv;
	}
	
	
	
}
	