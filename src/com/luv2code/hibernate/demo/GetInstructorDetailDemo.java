package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a session
			session.beginTransaction();
			
			//get the instructor detail object
			int theId = 2999;
			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, theId);
			Instructor theInstructor = session.get(Instructor.class, theId);
			
			//print the detail
			System.out.println("Instructor Detail: " + theInstructorDetail);
			
			//print the associated instructor
			System.out.println("the associated Instructor: " + theInstructorDetail.getInstructor());
			System.out.println("the associated Instructor: " + theInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} 
		catch (Exception exc) {
			exc.printStackTrace();
		} 
		finally {
			session.close();
			
			factory.close();
		}

	}

}
