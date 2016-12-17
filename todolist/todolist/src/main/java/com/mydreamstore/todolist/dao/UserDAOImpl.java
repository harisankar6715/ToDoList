package com.mydreamstore.todolist.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mydreamstore.todolist.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	};
	
	
	@Transactional
	public void delete(String mailid){
		User UserToDelete=new User();
		UserToDelete.setMailid(mailid);
		sessionFactory.getCurrentSession().delete(UserToDelete);
		
	}
	
	@Transactional
	public User get(String mailid){
		String hql= "from User where mailid=" + "'"+mailid+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser=query.list();
		
		if(listUser != null && !listUser.isEmpty()){
			return listUser.get(0);
		}
		return null;
		
	}
	
	@Transactional
	public List<User> list(){
		@SuppressWarnings("unchecked")
		List<User> listUser=(List<User>)sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
		     
	}
	
	@Transactional
	public boolean isValidUser(String mailid, String password) {
		String hql = "from User where mailid= '" + mailid + "' and " + " password ='" + password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	
	
	

}
