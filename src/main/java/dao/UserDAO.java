package dao;

import java.util.ArrayList;
import java.util.List;

import model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import dao.UserDAO;

public class UserDAO {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void init(){
    	System.out.println("UserDAO is initializing...");
    }

	public void destroy(){
		System.out.println("UserDAO is now closing...");
	}

	public User addNewUser(User user){
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		return user;
	}
	
	public User updateUser(User user){
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		System.out.println("REACHING");
		System.out.println("UserDAO is reading...");
		Session session = this.sessionFactory.openSession();
		List<User> userList = session.createQuery("FROM User").list();
		System.out.println("UserDAO is finished reading...");
		session.close();
		return userList;
	}
	
	@SuppressWarnings("unchecked")
	public User getUserByID(int userId){
		Session session = this.sessionFactory.openSession();
	    Query<User> query = session.createQuery("FROM User WHERE userId = :id");
	    query.setParameter("id", userId);
		User user = new ArrayList<User>(query.list()).get(0);
		session.close();
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public User getUserByUsername(String username){
		Session session = this.sessionFactory.openSession();
	    Query<User> query = session.createQuery("FROM User WHERE username = :username");
	    query.setParameter("username", username);
		User user = new ArrayList<User>(query.list()).get(0);
		session.close();
		return user;
	}
}
