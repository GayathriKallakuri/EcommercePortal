/*package com.niit.shoppingcartfrontend.webflow;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shoppingcart.d.CartDAO;
import com.niit.shoppingcart.d.OrderDAO;
import com.niit.shoppingcart.model.BillingAddress;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Order;
import com.niit.shoppingcart.model.PaymentMethod;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.ShippingAddress;
import com.niit.shoppingcart.model.User;

public class OrderWebFlow {
	private static Logger log=LoggerFactory.getLogger(OrderWebFlow.class);
	@Autowired
	private ShippingAddress shippingAddress;
	
	@Autowired
	private BillingAddress billingAddress;
	
	@Autowired
	private User user;
	
	@Autowired
	private OrderDAO orderDao;
	
	@Autowired
	 CartDAO cartdao ;
	
	@Autowired
	Order order;
	
	@Autowired
	Cart cart;
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	Product product;
	
	public Order initFlow(){
		log.debug("WEBFLOW -> -> starting of the method initflow" );
		order = new Order();
		log.debug("WEBFLOW-> -> ending of the method");
		return order;
	}
	public String addShippingAddress(Order order,ShippingAddress shippingAddress){
		log.debug("WEBFLOW -> -> starting of the method initflow");
		order.setShippingAddress(shippingAddress);
		log.debug("WEBFLOW-> -> ending of the method");
		return "success";
	}
		
		public String addBillingAddress(Order order,BillingAddress billingAddress){
			log.debug("WEBFLOW -> -> starting of the method initflow");
			order.setBillingAddress(billingAddress);
			log.debug("WEBFLOW-> -> ending of the method");
			return "success";
	}
		public String addPaymentMethod(Order order,PaymentMethod paymentMethod){
			log.debug("WEBFLOW -> -> starting of the method initflow");
			order.setPaymentMethod(paymentMethod.getPaymentMethod());
			log.debug("WEBFLOW-> -> ending of the method");
			return "success";
		}
			public String ConfirmOrder (Order order){
				log.debug("WEBFLOW -> -> starting of the method initflow");
				orderDao.saveorupdate(order);
				log.debug("WEBFLOW-> -> ending of the method");
				return "success";
	}
}
*/
