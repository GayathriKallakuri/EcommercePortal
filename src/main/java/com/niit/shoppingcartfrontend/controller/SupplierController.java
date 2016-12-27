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

import com.niit.shoppingcart.d.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class SupplierController {
	Logger log = LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listSupplier(Model model) {
		log.debug("Start of method to list the supplier");
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("isAdminClickedCategories", "true");
		log.debug("End of method to list the supplier");
		return "/index";
	}*/

	@RequestMapping(value = "addsupplier", method = RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier, Model model) {
		log.debug("Start of method add supplier");
		log.debug("id:" + supplier.getId());
		if (supplierDAO.addOrUpdate(supplier) == true) {
			model.addAttribute("messgae", "Successfully created or updated the supplier");
		} else {
			model.addAttribute("message", "not able to add/update the supplier");
		}
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("adminClickedSupplier", "true");
		log.debug("End of method add supplier");
		return "redirect:./";
	}
	
	@RequestMapping(value="deletesupplier/{id}" ,  method = RequestMethod.GET)
	public ModelAndView deleteSupplier(@PathVariable("id") int id){
		log.debug("start of method delete supplier");
		supplierDAO.delete(id);
		ModelAndView mv = new ModelAndView("redirect:/supplier");
		List<Supplier> supplier = supplierDAO.list();
		mv.addObject("Supplieritems", supplier);
		log.debug("End of method delete supplier");
		return mv; 
	}
	
	@RequestMapping("updatesupplier/{id}" )
	public String updateSupplier(@PathVariable("id") int id, Model model)throws Exception{
		log.debug("start of method delete supplier");
		supplier=supplierDAO.get(id);
		model.addAttribute("supplier", supplier);
		log.debug("End of method update supplier");
		return "forward:/";
	}
	
	@RequestMapping(value="editsupplier/{id}" , method = RequestMethod.GET)
	public ModelAndView editSupplier(@PathVariable("id") int id){
		log.debug("start of method edit supplier");
		ModelAndView mv=new ModelAndView("/index","command",supplierDAO.get(id));
		mv.addObject("adminClickedAddSupplier","true");
		log.debug("End of method edit supplier");
		return mv;
	}
}
