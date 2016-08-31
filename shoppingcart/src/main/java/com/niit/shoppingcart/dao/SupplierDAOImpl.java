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

import com.niit.shoppingcart.model.Supplier;
@EnableTransactionManagement
@Repository(value="supplierDAO")
public class SupplierDAOImpl implements SupplierDAO{
	private static final Logger log = LoggerFactory.getLogger(SupplierDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
@Transactional
public boolean save(Supplier supplier){
	try {
		log.debug("starting of the save method");
		sessionFactory.getCurrentSession().save(supplier);
		log.debug("ending of the save ethod");
		return true;
	} catch (Exception e) {
		log.error("error occured in save method"+e.getMessage());
		e.printStackTrace();
		return false;}
	}
	@Transactional
	public boolean update(Supplier supplier){
		try {
			log.debug("starting of the save method");
			sessionFactory.getCurrentSession().update(supplier);
			log.debug("ending of the save method");
			return true;
		} catch (Exception e) {
			log.error("error occured in save method"+e.getMessage());
			e.printStackTrace();
			return false;}
		}
		@Transactional
		public boolean delete(Supplier supplier){
			try {
				log.debug("starting of the save method");
				sessionFactory.getCurrentSession().delete(supplier);
				log.debug("ending of the save method");
				return true;
			} catch (Exception e) {
				log.error("error occured in save method"+e.getMessage());
				e.printStackTrace();
				return false;
			}
}
		@Transactional
public Supplier get(String id)
{
	log.debug("starting of the save method");
	log.info("Trying to get supplier based on id"+id);
	String hql="from Supplier where id="+"'"+id+"'";
	log.info("the hql query is :"+hql);
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			List<Supplier> list=query.list();
			if(list==null || list.isEmpty() ){
			log.info("No supplier is avilable with this id"+id);
				return null;
			}
			else{
				return list.get(0);
				 
			}
} @Transactional
public	List<Supplier> list(){
	log.debug("starting oof the save method");
	String hql="from Supplier";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	List<Supplier> list = query.list();
	if(list==null||list.isEmpty())
	{
		log.info("No supplier is available");
		return null;
	}
	else{
	return list;
	}
	}

public boolean delete(String id) {
	// TODO Auto-generated method stub
	return false;
}
}


