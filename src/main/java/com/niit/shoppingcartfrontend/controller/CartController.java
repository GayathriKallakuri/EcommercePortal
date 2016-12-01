package com.niit.shoppingcartfrontend.controller;

import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.d.CartDAO;
import com.niit.shoppingcart.d.ProductDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Product;

@Controller
public class CartController {
Logger log = LoggerFactory.getLogger(CartController.class);

@Autowired
private CartDAO cartDAO;

@Autowired
private Cart cart;

@Autowired
private ProductDAO productDAO;

@RequestMapping(value="/", method=RequestMethod.GET)
public String Cart(Model model,HttpSession session)
{
	log.debug("Start of method cart");
	model.addAttribute("cart",new Cart());
	String loggedInUserId=(String)session.getAttribute("loggedInUserId");
	if(loggedInUserId==null)
	{
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		loggedInUserId=auth.getName();	
	}
	int cartSize=cartDAO.list(loggedInUserId).size();
	if(cartSize==0){
		model.addAttribute("error","No products in cart");
	}
	else{
		model.addAttribute("cartList","cartDAO.list(loggedInUserId)");
		model.addAttribute("totalAmount",cartDAO.getTotalAmount(loggedInUserId));
		model.addAttribute("displayCart","true");
	}
	log.debug("End of method cart");
	return "/index";
	
}

@RequestMapping(value="/add/{id}",method=RequestMethod.GET)
public ModelAndView addToCart(@PathVariable("id") String id,HttpSession session)
{
	log.debug("Start of method add to cart");
	Product product = productDAO.get(id);
	cart.setPrice(product.getPrice());
	cart.setProductName(product.getName());
	String loggedInUserId=(String) session.getAttribute("loggedInUserId");
	if(loggedInUserId==null)
	{
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		loggedInUserId = auth.getName();
	}
	cart.setUserId(loggedInUserId);
	cart.setStatus("N");
	cart.setId(ThreadLocalRandom.current().nextLong(100,1000000+1));
	cartDAO.save(cart);
	ModelAndView mv=new ModelAndView("redirect:/index");
	mv.addObject("successmessage", "successfully added to the cart");
	log.debug("end of method add to cart");
	return mv;
	}

@RequestMapping("/delete/{id}")
public String deleteCart(@PathVariable("id") String id,ModelMap model) throws Exception{
log.debug("Start of method delete cart");
try{
	cartDAO.delete(id);
	model.addAttribute("message", "removed successfully");
}
catch(Exception e)
{
	model.addAttribute("message", e.getMessage());
    e.printStackTrace();
	}
log.debug("End of method delete cart");
return "redirect:/index";
}

}

