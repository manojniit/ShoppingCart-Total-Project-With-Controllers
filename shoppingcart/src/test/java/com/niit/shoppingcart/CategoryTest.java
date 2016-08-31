package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryTest {

	public static void main(String[] args) {
		
AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
 context.scan("com.niit");
 context.refresh();
 CategoryDAO CategoryDAO =(CategoryDAO) context.getBean("categoryDAO");
 Category Category =(Category) context.getBean("category");

Category.setId("CQ");
Category.setName("STUDENTS");
Category.setDescription("A BOUT STUDENTS");
if(CategoryDAO.save(Category)==true){
	System.out.println("a");
}
else{
	System.out.println("b");
}
	}

}
