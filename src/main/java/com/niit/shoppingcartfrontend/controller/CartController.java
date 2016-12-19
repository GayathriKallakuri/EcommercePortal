package com.niit.shoppingcartfrontend.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.d.CartDAO;
import com.niit.shoppingcart.d.ProductDAO;
import com.niit.shoppingcart.d.UserDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.User;

@Controller
public class CartController {
Logger log = LoggerFactory.getLogger(CartController.class);

@Autowired
private CartDAO cartDAO;

@Autowired
private Cart cart;

@Autowired
private Product product;

@Autowired
private ProductDAO productDAO;

@Autowired
private User user;

@Autowired
private UserDAO userDAO;

@Autowired
private HttpSession session;


@RequestMapping(value="/cart")

	public ModelAndView cart()
	{
		log.debug("start of Cart");
		ModelAndView mv=new ModelAndView("/index","command",new Cart());
		mv.addObject("loggedInUser","true");
		cartDAO.list();
		mv.addObject("Cartitems", cartDAO.list());
     	log.debug("end of Cart");
		return mv;
	}
	

@RequestMapping(value="/addtocart/{id}",method=RequestMethod.GET)
public ModelAndView addToCart(@PathVariable("id") int id,@ModelAttribute Cart cart,
		@ModelAttribute Product product)
{
	log.debug("Start of method add to cart");
	product=productDAO.get(id);
	System.out.println(id);
	cart.setCartDate(new Date());
	cart.setProductName(product.getName());
	cart.setUserId(userDAO.getUser());
	System.out.println(id);
	cart.setPrice(product.getPrice());
	cart.setQuantity(1);
	cart.setStatus('N');
	
	cartDAO.save(cart);
	
	List<Cart> cartList = cartDAO.list();
	int cartItemSize = cartList.size();
	
	session.setAttribute("cartItemSize", cartItemSize);
	System.out.println("CARTSIZE" + cartList.size());
	
	ModelAndView modelAndView = new ModelAndView("redirect:/productDetails/{id}");
	modelAndView.addObject("product", product);
	modelAndView.addObject("cartList", cartList);
	return modelAndView;
	
}

@RequestMapping(value="deletecart/{id}" ,  method = RequestMethod.GET)
public ModelAndView deleteCart(@PathVariable("id") int id){
	log.debug("start of method delete cart");
	cartDAO.delete(id);
	ModelAndView mv = new ModelAndView("redirect:/cart");
	List<Cart> cart = cartDAO.list();
	mv.addObject("Cartitems", cart);
	log.debug("End of method delete cart");
	return mv; 
}

@RequestMapping(value="editcart/{id}",method = RequestMethod.GET)
public ModelAndView updateCart(HttpServletRequest request,@PathVariable("id") int id){
	log.debug("Start of method edit cart");
	ModelAndView mv = new ModelAndView("redirect:/cart");
	Cart cartItem=cartDAO.get(id);
	System.out.println(id);
	int q=Integer.parseInt(request.getParameter("q"));
	cartItem.setQuantity(q);
	cartDAO.save(cartItem);
	log.debug("End of method edit cart");
	return mv;
}
}


