package org.kautiya.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.kautilya.entity.Transaction;
import org.kautilya.entity.Users;

public class UsersModel {
	
	SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Users.class)
            .buildSessionFactory();

	public void addUser(Users users) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(users);
		session.getTransaction().commit();
		System.out.println(users.getFirstName()+","+users.getLastName()+" Got added");
		
	}

	public List<Users> listUsers() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Users> users=session.createQuery("from users").getResultList();
		session.getTransaction().commit();
		return users;
	}

	public void updateUser(Users users) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Users user=new Users();
		user=session.get(Users.class, users.getaccount_number());
		user.setFirstName(users.getFirstName());
		user.setLastName(users.getLastName());
		user.setUserName(users.getUserName());
		user.setPassword(users.getPassword());
		user.setEmail(users.getEmail());
		user.setMobile(user.getMobile());
		session.getTransaction().commit();
		
	}




	
	
	

}
