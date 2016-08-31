package com.niit.shoppingcart;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;

public class TestCaseUserDetails {

 @Autowired
 UserDetailsDAO userDetailsDAO;
	@Autowired
	UserDetails userDetails;
	AnnotationConfigApplicationContext context;
	@Before
	public void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
	userDetailsDAO=(UserDetailsDAO) context.getBean("userDetailsDAO");
	userDetails= (UserDetails) context.getBean("userDetails");
	}
@Test
public void deleteUserDetailsTest(){
	userDetails.setId("mk_1");
	boolean flag =userDetailsDAO.delete(userDetails);
	assertEquals("deleteUserDetailsTest",flag,true);
	
}
@Test
public void addUserDetailsTest()

{
	userDetails.setId("ud_2");
	userDetails.setName("rahul");
	userDetails.setEmail("rahul@123");
	userDetails.setPassword("12365jk");
	userDetails.setContact("wgl");
	userDetails.setAddress("nrsmpt");
	assertEquals("addUserDetailsTest",userDetailsDAO.save(userDetails),true);
	
}
@Test
public void listUserDetailsTest(){
	assertEquals("listUserDetailsTest",userDetailsDAO.list().size(),1);
}
@Test
public void updateUserDetailsTestCase(){
	userDetails.setId("ud_2");
	userDetails.setName("ganesh");
	
	assertEquals("updateUserDetailsTestCase",userDetailsDAO.update(userDetails),true);
	
}
@Test
public void getUserDetailsTestCase(){
userDetails=userDetailsDAO.get("ud_2");
assertEquals("getUserDetailsTestCase",userDetails.getName(),"ganesh");
}
}
