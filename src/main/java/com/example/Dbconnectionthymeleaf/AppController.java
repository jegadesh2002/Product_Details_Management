package com.example.Dbconnectionthymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@Autowired
	private ProdectService service;
	@RequestMapping("/")
	public String viewHomePage(Model model)
	{
		List<Product> listProducts=service.listAll();
		model.addAttribute("listProducts",listProducts);
		return "index";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product){
		service.save(product);
		return "redirect:/";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model)
	{
		Product product=new Product();
		model.addAttribute("product",product);
		return "newproduct";
		
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name="id") int id) {
		ModelAndView mav=new ModelAndView("editproduct");
		Product product=service.get(id);
		mav.addObject("product",product);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name="id") int id) {
		service.delete(id);
		return "redirect:/";
	}
	
	
}
