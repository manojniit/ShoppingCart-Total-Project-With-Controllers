package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class TestCaseProduct {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	Product product;
	AnnotationConfigApplicationContext context;
	@Before
	public void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
	productDAO=(ProductDAO) context.getBean("productDAO");
	product= (Product) context.getBean("product");
	}
	@Test
	public void deleteProductTestCase(){
		product.setId("mob-22");
		boolean flag =productDAO.delete(product);
		assertEquals("deleteProductTestCase",flag,true);
		
	}
	@Test
	public void addProductTestCase()
	
	{
		product.setId("MOB_002");
		product.setName("i-phone6");
		product.setDescription("this is new iphone");
		product.setPrice(60000);
		assertEquals("addProductTestCase",productDAO.save(product),true);
		
	}
	@Test
	public void listProductTestCase(){
		assertEquals("listProductTestCase",productDAO.list().size(),1);
		
	}
	@Test
	public void updateProductTestCase(){
		product.setId("MOB_002");
		product.setName("i-phone6");
		product.setDescription("this is new iphone");
		product.setPrice(68000);
		assertEquals("updateProductTestCase",productDAO.update(product),true);
		
	}
	@Test
	public void getProductTestCase()
	{
		product=productDAO.get("MOB_002");
	assertEquals("getProductTestCase",product.getId(),"MOB_002");
	}
	}
