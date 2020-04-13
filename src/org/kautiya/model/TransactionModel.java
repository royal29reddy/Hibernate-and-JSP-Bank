package org.kautiya.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.kautilya.entity.Transaction;

public class TransactionModel {

	SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Transaction.class)
            .buildSessionFactory();
	
	
	public void addUser(String username) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Transaction balances=new Transaction(username);
		session.save(balances);
		session.getTransaction().commit();
	}
	
	
	
	public List<Transaction> sendMoney(long useramount,long useraccount,int useruseraccount,String username,String userusername) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Transaction> query=session.createQuery("from balances where user_name='"+username+"' and balance>"+useramount).getResultList();
		if(!(query.isEmpty())) {
			session.createQuery("update balances set balance=balance+"+useramount+" where user_name='"+userusername+"'").executeUpdate();
			session.createQuery("update balances set balance=balance-"+useramount+" where user_name='"+username+"'").executeUpdate();
			session.getTransaction().commit();
			
		}
		return query;		
	}

	public List<Transaction> requestMoney(long useramount,long useraccount,int useruseraccount,String username,String userusername) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Transaction> query=session.createQuery("from balances where user_name='"+userusername+"' and balance>"+useramount).getResultList();
		if(!(query.isEmpty())) {
			session.createQuery("update balances set balance=balance-"+useramount+" where user_name='"+userusername+"'").executeUpdate();
			session.createQuery("update balances set balance=balance+"+useramount+" where user_name='"+username+"'").executeUpdate();
			session.getTransaction().commit();
			
		}
		System.out.println(query);
		return query;		
	}



	public void depositCheque(long useramount, String username,long useraccount) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Transaction transaction=new Transaction();
		transaction=session.get(Transaction.class, useraccount);
		transaction.setBalance(transaction.getBalance()+useramount);
		session.getTransaction().commit();
		
	}

	public List<Transaction> listUsers(String username) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Transaction> users=session.createQuery("from balances where user_name='"+username+"'").getResultList();
		return users;
		
	}



	public void updateUser(long accountNumber,String userName) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Transaction transaction=new Transaction();
		transaction=session.get(Transaction.class, accountNumber);
		transaction.setUserName(userName);
		session.getTransaction().commit();
		
		
	}


	
}
