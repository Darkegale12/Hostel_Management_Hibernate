package com.hostel.Controller;

import com.hostel.Entity.User_Login_Entity;
import com.hostel.Entity.hostel_room_database;
import com.hostel.Service.userService;

public class userController {
userService sobj =new userService();
	public void insertNewUser(User_Login_Entity uobj) {
		sobj.insertNewUser(uobj);
		
	}
	public String check_login(String user_name, String user_password) {
	return	sobj.check_login(user_name,user_password);
		
	}
	public String getEmailByUsername(String user_name) {
		
		return sobj.getEmailByUsername(user_name);
	}
	public String insertinto_hostelDB(hostel_room_database obj) {
	return	sobj. insertinto_hostelDB(obj);
		
	}
	public String getroom(String branch_name) {
		return sobj.getroom(branch_name);
		
	}
	
	public String pay_fees(String username) {
	return	sobj.pay_fees(username);
	}
	public String addQuery(String query,String room_allocated) {
	return	sobj.addQuery(query,room_allocated);  
		
	}
	public String change_room(hostel_room_database obj) {
	return	sobj.change_room(obj);
		
	}
	public String leave(hostel_room_database obj) {
		return sobj.leave( obj);
		
	}

}
