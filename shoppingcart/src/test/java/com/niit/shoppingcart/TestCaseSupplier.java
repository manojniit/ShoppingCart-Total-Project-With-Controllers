package com.niit.shoppingcart;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class TestCaseSupplier {

 @Autowired
 SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;
	AnnotationConfigApplicationContext context;
	@Before
	public void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
	supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
	supplier= (Supplier) context.getBean("supplier");
	}
@Test
public void deleteSupplierTest(){
	supplier.setId("mk_1");
	boolean flag =supplierDAO.delete(supplier);
	assertEquals("deleteSupplierTest",flag,true);
	
}
@Test
public void addSupplierTest()

{
	supplier.setId("mk_2");
	supplier.setName("ganesh");
	supplier.setDescription("this is new iphone");
	
	assertEquals("addSupplierTest",supplierDAO.save(supplier),true);
	
}
@Test
public void listSupplierTest(){
	assertEquals("listSupplierTest",supplierDAO.list().size(),1);
}
@Test
public void updateSupplierTestCase(){
	supplier.setId("mk_2");
	supplier.setName("ganesh");
	supplier.setDescription("this is new iphone");
	assertEquals("updateSupplierTestCase",supplierDAO.update(supplier),true);
	
}
@Test
public void getSupplierTestCase(){
supplier=supplierDAO.get("mk_2");
assertEquals("getSupplierTestCase",supplier.getName(),"ganesh");
}
}
