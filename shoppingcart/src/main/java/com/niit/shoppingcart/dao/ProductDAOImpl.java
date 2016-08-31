package com.niit.shoppingcart.dao;


import java.util.List;



import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Product;
@EnableTransactionManagement
@Repository(value="productDAO")
public class ProductDAOImpl implements ProductDAO{
	private static final Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
@Transactional
public boolean save(Product product){
	try {
		log.debug("starting of the save method");
		sessionFactory.getCurrentSession().save(product);
		log.debug("ending of the save ethod");
		return true;
	} catch (Exception e) {
		log.error("error occured in save method"+e.getMessage());
		e.printStackTrace();
		return false;}
	}
	@Transactional
	public boolean update(Product product){
		try {
			log.debug("starting of the save method");
			sessionFactory.getCurrentSession().update(product);
			log.debug("ending of the save method");
			return true;
		} catch (Exception e) {
			log.error("error occured in save method"+e.getMessage());
			e.printStackTrace();
			return false;}
		}
		@Transactional
		public boolean delete(Product product){
			try {
				log.debug("starting of the save method");
				sessionFactory.getCurrentSession().delete(product);
				log.debug("ending of the save method");
				return true;
			} catch (Exception e) {
				log.error("error occured in save method"+e.getMessage());
				e.printStackTrace();
				return false;
			}
}
		@Transactional
public Product get(String id)
{
	log.debug("starting of the save method");
	log.info("Trying to get product based on id"+id);
	String hql="from Product where id="+"'"+id+"'";
	log.info("the hql query is :"+hql);
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			List<Product> list=query.list();
			if(list==null || list.isEmpty() ){
			log.info("No product is avilable with this id"+id);
				return null;
			}
			else{
				return list.get(0);
				 
			}
} @Transactional
public	List<Product> list(){
	log.debug("starting oof the save method");
	String hql="from Product";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	List<Product> list = query.list();
	if(list==null||list.isEmpty())
	{
		log.info("No product is available");
		return null;
	}
	else{
	return list;
	}
	}
}


