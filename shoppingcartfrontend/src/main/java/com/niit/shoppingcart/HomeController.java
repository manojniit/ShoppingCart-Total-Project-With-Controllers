package com.niit.shoppingcart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Controller
public class HomeController {
	@Autowired
	CategoryDAO categoryDAO;
	@RequestMapping("/")
	@Autowired
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("message","Thank q for visiting the url");
		List<Category> categoryList=categoryDAO.list();
		mv.addObject("categoryList", categoryList);
		System.out.println("Size:"+categoryList.size());
		return mv;
	}
	@RequestMapping("/log")
	public ModelAndView log()
	{
		ModelAndView mv = new ModelAndView("log");
		mv.addObject("userClickedloginHere","true");
		return mv;
	}
	@RequestMapping("/signup")
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView("signup");
		mv.addObject("userClickedsignupHere","true");
		return mv;
	}
}
