package com.niit.shoppingcartfrontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.d.CartDAO;
import com.niit.shoppingcart.d.CategoryDAO;
import com.niit.shoppingcart.d.ProductDAO;
import com.niit.shoppingcart.d.SupplierDAO;
import com.niit.shoppingcart.d.UserDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;


@Controller
public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	 private UserDAO userDAO;

	@Autowired
	private User user;

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private Cart cart;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private Product product;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/validate", method = RequestMethod.POST)

	public ModelAndView login(@RequestParam(value = "username") String id,
			@RequestParam(value = "Password") String password, HttpSession session) {
		log.debug("Start of login method");

		ModelAndView mv = new ModelAndView("/index");
		user = userDAO.isValidUser(id, password);

		if (user != null) {
			log.debug("Valid credentials");
			user = userDAO.get(id);
			session.setAttribute("loggedInUser", user.getName());
			session.setAttribute("loggedInUserID", user.getId());

			session.setAttribute("user", user);

			if (user.getRole().equals("ROLE_ADMIN")) {
				log.debug("Logged in as admin");

				mv.addObject("isAdmin", "true");

				session.setAttribute("supplier", supplier);
				session.setAttribute("supplierList", supplierDAO.list());

				session.setAttribute("category", category);
				session.setAttribute("categoryList", categoryDAO.list());
			} else {
				log.debug("Logged in as user");

				mv.addObject("isAdmin", "false");
				cart = cartDAO.get(id);
				mv.addObject("cart", cart);
				List<Cart> cartList = cartDAO.list(id);
				mv.addObject("cartList", cartList);
				mv.addObject("cartSize", cartList.size());

			}
		} else {
			log.debug("Invalid credentials");

			mv.addObject("invalidCredentials", "true");
			mv.addObject("errorMessage", "invalidCredentials");

		}
		log.debug("end of login");
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		log.debug("start of logout method");
		ModelAndView mv = new ModelAndView("/index");
		session.invalidate();
		session = request.getSession(true);
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());

		mv.addObject("logoutMesssage", "Succesfully logged out");
		mv.addObject("loggedOut", "true");
		log.debug("end of log method");

		return mv;
	}

	/*@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute User user) {
		log.debug("Start of register method");
		ModelAndView mv = new ModelAndView("/index");
		if (userDAO.get(user.getId()) == null) {
			user.setRole("ROLE_USER");
			userDAO.saveOrUpdate(user);
			log.debug("Succesfully registered");
			mv.addObject("successMessage", "Successfully registered");
		} else {
			log.debug("User exists with this id");
			mv.addObject("errorMessage", "User exists with this id");
		}
		log.debug("End of register method");
		return mv;
	}*/
}