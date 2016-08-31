package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;

public class UserDetailsTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
 context.scan("com.niit");
 context.refresh();
 UserDetailsDAO UserDetailsDAO =(UserDetailsDAO) context.getBean("userDetailsDAO");
 UserDetails UserDetails =(UserDetails) context.getBean("userDetails");

UserDetails.setId("mk_1");
UserDetails.setName("manoj");
UserDetails.setEmail("manoj@123");
UserDetails.setPassword("tejasri");
UserDetails.setContact("hyd");
UserDetails.setAddress("dsnr");
if(UserDetailsDAO.save(UserDetails)==true){
	System.out.println("a");
}
else{
	System.out.println("b");
}
	}

}
