package com.hostel.DAO;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.hostel.Configuration.HBconfiguration;
import com.hostel.Entity.User_Login_Entity;
import com.hostel.Entity.hostel_room_database;



public class userDAO {

	private SessionFactory sf=HBconfiguration.configuration(); 
	
	public boolean insertNewUser(User_Login_Entity uobj) {
		 
		Session session=sf.openSession();
		session.save(uobj);
		session.beginTransaction().commit();;
		session.close();
		return true;
	}

	public List<User_Login_Entity> check_login(String user_name, String user_password) {
		Session session=sf.openSession();
		Criteria cr= session.createCriteria(User_Login_Entity.class);
		cr.add(Restrictions.eq("username",user_name));
		cr.add(Restrictions.eq("password", user_password));
		return cr.list();   
	}
	public String getEmailByUsername(String username) {
	    Session session = sf.openSession();
	    String hql = "FROM User_Login_Entity WHERE username = :uname";
	    Query query = session.createQuery(hql);
	    query.setParameter("uname", username);
	    List<User_Login_Entity> list = query.list();
	    session.close();
	    if (!list.isEmpty()) {
	        return list.get(0).getEmail();
	    }
	    return null;
	}

	public boolean insertinto_hostelDB(hostel_room_database obj) {
		Session session=sf.openSession();
		session.save(obj);
		session.beginTransaction().commit();
		session.close();
		return true;
	}

	public List getroom(String branch_name) {
		Session session=sf.openSession();
		Criteria cr= session.createCriteria(hostel_room_database.class);
		cr.add(Restrictions.eq("branch_name", branch_name));
		return cr.list();
	}

	

	public void incrementroomate(String room_allocated) {
		Session session=sf.openSession();
		Criteria cr= session.createCriteria(hostel_room_database.class);
		cr.add(Restrictions.eq("room_allocated", room_allocated));
		List<hostel_room_database>list=cr.list();
		for (hostel_room_database element : list) {
			int increment=element.getRoommate_no()+1;
			element.setRoommate_no(increment);
			session.update(element);
		}
		session.beginTransaction().commit();
		session.close();
	}

	public List<Integer> pay_fees(String username) {
	    Session session = sf.openSession();
	    
	    Criteria cr = session.createCriteria(hostel_room_database.class);
	    cr.createAlias("user", "u");  // Join with User_Login_Entity
	    cr.add(Restrictions.eq("u.username", username));
	    cr.setProjection(Projections.property("fees_payment"));  // Fetch only fees_payment
	    
	    List<Integer> feesList = cr.list();
	    session.close();
	    
	    return feesList;
	}

	public boolean addQuery(String query,String room_allocated) {
	   hostel_room_database obj=new hostel_room_database();
	   obj.setBranch_name("New");
	   obj.setService_request(query);
	   obj.setRoom_allocated(room_allocated);
	   Session session=sf.openSession();
	   session.save(obj);   
	   session.beginTransaction().commit();
	   session.close();
	   return true;
	}

	

	public boolean change_room(hostel_room_database obj) {
		Session session=sf.openSession();
		session.save(obj);
		session.beginTransaction().commit();
		session.close();
		return true;
		
	}

	public boolean leave(hostel_room_database obj) {
		Session session=sf.openSession();
		session.save(obj);
		session.beginTransaction().commit();
		session.close();
		return true;
	}

	



}
