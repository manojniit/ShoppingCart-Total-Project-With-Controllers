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

import com.niit.shoppingcart.model.UserDetails;
@EnableTransactionManagement
@Repository(value="userDetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO{
	private static final Logger log = LoggerFactory.getLogger(UserDetailsDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	public UserDetailsDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
@Transactional
public boolean save(UserDetails userDetails){
	try {
		log.debug("starting of the save method");
		sessionFactory.getCurrentSession().save(userDetails);
		log.debug("ending of the save ethod");
		return true;
	} catch (Exception e) {
		log.error("error occured in save method"+e.getMessage());
		e.printStackTrace();
		return false;}
	}
	@Transactional
	public boolean update(UserDetails userDetails){
		try {
			log.debug("starting of the save method");
			sessionFactory.getCurrentSession().update(userDetails);
			log.debug("ending of the save method");
			return true;
		} catch (Exception e) {
			log.error("error occured in save method"+e.getMessage());
			e.printStackTrace();
			return false;}
		}
		@Transactional
		public boolean delete(UserDetails userDetails){
			try {
				log.debug("starting of the save method");
				sessionFactory.getCurrentSession().delete(userDetails);
				log.debug("ending of the save method");
				return true;
			} catch (Exception e) {
				log.error("error occured in save method"+e.getMessage());
				e.printStackTrace();
				return false;
			}
}
		@Transactional
public UserDetails get(String id)
{
	log.debug("starting of the save method");
	log.info("Trying to get userDetails based on id"+id);
	String hql="from UserDetails where id="+"'"+id+"'";
	log.info("the hql query is :"+hql);
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			List<UserDetails> list=query.list();
			if(list==null || list.isEmpty() ){
			log.info("No userDetails is avilable with this id"+id);
				return null;
			}
			else{
				return list.get(0);
				 
			}
} @Transactional
public	List<UserDetails> list(){
	log.debug("starting oof the save method");
	String hql="from UserDetails";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	List<UserDetails> list = query.list();
	if(list==null||list.isEmpty())
	{
		log.info("No userDetails is available");
		return null;
	}
	else{
	return list;
	}
	}
@Transactional
public UserDetails isValidUser(String id, String password) {
String hql = "from UserDetails where id ='" +id+ "' and password ='" +password+ "' ";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	List<UserDetails> list = query.list();
	if(list==null){
return null;
	}
	else{
		return list.get(0);
	}
}
}


