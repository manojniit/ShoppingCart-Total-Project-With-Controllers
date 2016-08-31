package com.niit.shoppingcart;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;

public class UserController {
	
	@Autowired
	UserDetailsDAO  userDetailsDAO;
	@Autowired
	UserDetails userDetails;
	
	public ModelAndView login(@RequestParam(value="id")String id,@RequestParam(value="password")
										String password,HttpSession session)
	{
		ModelAndView mv = new ModelAndView("home");
		String msg;
		userDetails = userDetailsDAO.isValidUser(id,password);
		if(userDetails==null)
		{
			msg = "invalid user ....please try again";
		}
		else{
			if(userDetails.getRole().equals("Role_Admin"))
			{
				mv=new ModelAndView("adminHome");
			}
			else {
				session.setAttribute("welcome msg", userDetails.getName());
				session.setAttribute("userid", userDetails.getId());
			}
		}
		return mv;
	}

}
