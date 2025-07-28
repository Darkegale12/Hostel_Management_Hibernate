package com.hostel.Service;

import java.util.List;

import com.hostel.DAO.userDAO;
import com.hostel.Entity.User_Login_Entity;
import com.hostel.Entity.hostel_room_database;

public class userService {
userDAO dao=new  userDAO();
	public void insertNewUser(User_Login_Entity uobj) {
	Boolean check=	dao.insertNewUser(uobj);
		
	}
	public String check_login(String user_name, String user_password) {
	List check=dao.check_login(user_name,user_password);
		if(check.isEmpty()) {
			return "Wrong  username or password\nTry Again!";
		}
		else {
		
			return "Credentials  verified\nWelcome back "+user_name;
		}
	}
	public String getEmailByUsername(String user_name) {
	return	dao.getEmailByUsername(user_name);
		
	}
	public String insertinto_hostelDB(hostel_room_database obj) {
	boolean check=	dao.insertinto_hostelDB(obj);
	if(check) {
		dao.incrementroomate(obj.getRoom_allocated());
		return "Room booked on your name in the Hostel Database";
	}else {
		return "Cannot book the room with this info try again!";
	}
		
	}
	public String getroom(String branch_name) {
	    List<hostel_room_database> check = dao.getroom(branch_name);
	    
	    for (hostel_room_database element : check) {
	        int otp = element.getRoommate_no();
	        
	        if (otp <= 3) {
	            return "Hostel room available for your branch with " + otp + " roommates at room "+element.getRoom_allocated();
	        }
	    }

	    return "Sorry, rooms aren't available at this moment.";
	}
	
	public String pay_fees(String username) {
	List<Integer> ans=dao.pay_fees(username);
	
	return "You have to pay "+ ans+" \nPay the fees in the office or go through the college website for hostel payment";
	}
	public String addQuery(String query,String room_allocated) {
		boolean check=	dao.addQuery(query,room_allocated);
		if(check) {
			return "Query regarding to your problem is sent it will be addressed on your registered mail\nAlso can contact +91-9870327700";   
		}else {
			return "There was an issue while reprting a query";
		}
	}
	
	
	public String change_room(hostel_room_database obj) {
	boolean check=dao.change_room( obj);
	if(check) {
		return "Your application to change the room is submitted \nBe patient till further replies";
	}
	else {
		return "Your application was not entered properly please try again";
	}
	}
	public String leave(hostel_room_database obj) {
		boolean check=dao.leave(obj);
		if(check) {
			return "Your application to for leave is submitted";
		}
		else {
			return "Your application was not entered properly please try again";
		}
	}
	
	
	}
	


  