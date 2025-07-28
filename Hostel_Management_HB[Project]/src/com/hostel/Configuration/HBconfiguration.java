package com.hostel.Configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hostel.Entity.User_Login_Entity;

public class HBconfiguration {
	public static final SessionFactory configuration() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(User_Login_Entity.class);
		SessionFactory sf = cfg.buildSessionFactory();
		return sf;
	}
}
