package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveObjectTest {
	
	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Product prod=null;
		Transaction tx=null;
		boolean flag=false;
		
		// Active Hibernate f/w (Bootstap Hibernate )
		
		cfg= new Configuration();
		
		// supply hibernate cfg file as input file
		
		 cfg.configure("/com/nt/cfgs/hibernate.cfgs.xml");
		 
		 // Build session factory
		 
		 factory=cfg.buildSessionFactory();
		 // open session 
		 
		 ses=factory.openSession();
		 
		 // crate Entity object to save with Db  s/w 
		 
		  prod= new Product();
		  
		  prod.setPid(5555); prod.setPname("manoj");prod.setPrice(700000);prod.setQty(3);
		      
		  try {
			  tx=ses.beginTransaction(); // internally calls con.setAutocommit(false) to begin the tx
			  ses.save(prod);
			  System.out.println(" object saved");
			  flag=true;
		  }
		  catch(HibernateException he) {
			  he.printStackTrace();
			  flag=false;
		  }
		  
		  finally {
			  // commit or rollback
			  if(flag==true)
				  tx.commit(); // internally calls the con.commit..
			  else
				  tx.rollback(); // internally calls the con.rollback..
			  // close session object 
			  ses.close();
			  factory.close();
			  
		  }
	
	}

}
