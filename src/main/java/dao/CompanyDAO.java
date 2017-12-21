package dao;

import java.util.ArrayList;
import java.util.List;

import model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class CompanyDAO {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void init(){
    	System.out.println("CompanyDAO is initializing...");
    }

	public void destroy(){
		System.out.println("CompanyDAO is now closing...");
	}

	@SuppressWarnings("unchecked")
	public List<Company> getAllCompanies(){
		System.out.println("REACHING");
		System.out.println("CompanyDAO is reading...");
		Session session = this.sessionFactory.openSession();
		List<Company> companyList = session.createQuery("FROM Company").list();
		System.out.println("CompanyDAO is finished reading...");
		session.close();
		return companyList;
	}
	
	@SuppressWarnings("unchecked")
	public Company getCompanyByID(int userId){
		Session session = this.sessionFactory.openSession();
	    Query<Company> query = session.createQuery("FROM Company WHERE companyId = :id");
	    query.setParameter("id", userId);
		Company company = new ArrayList<Company>(query.list()).get(0);
		session.close();
		return company;
	}
}
