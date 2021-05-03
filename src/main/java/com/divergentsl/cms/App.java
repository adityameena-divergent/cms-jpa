package com.divergentsl.cms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.divergentsl.cms.cms.AdminMenu;
import com.divergentsl.cms.config.AppConfig;

public class App 
{
    public static void main( String[] args )
    {
    	/*
    	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
        
        EntityManager entitymanager = emfactory.createEntityManager( );
        entitymanager.getTransaction( ).begin( );

        Patient p = new Patient();
        p.setId(101);
        p.setName("Abhishek");
        p.setAge(22);
        p.setAddress("Indore");
        p.setContactNumber(1234567890);
        p.setGender("Male");
        p.setWeight(60);
        
        
        entitymanager.persist(p);
        entitymanager.getTransaction( ).commit( );

        entitymanager.close( );
        emfactory.close( );
    	*/
    	
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	AdminMenu adminMenu = context.getBean(AdminMenu.class);
        
//    	AdminMenu adminMenu = new AdminMenu();
    	
    	adminMenu.adminMenu();
    	
//    	context.close();
        
    	
    }
}
