package com.dbs.project;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ApplicationSessionFactory {
	private static SessionFactory sessionFactory=null;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
				  try {
					StandardServiceRegistry standardRegistry = 
				       new StandardServiceRegistryBuilder().configure().build();
					sessionFactory = 
				        new MetadataSources(standardRegistry).buildMetadata().buildSessionFactory();
				   } catch (Throwable th) {
					System.err.println("Enitial SessionFactory creation failed" + th);
					throw new ExceptionInInitializerError(th);
				  }
				  
		}
		return sessionFactory;
	}

}
