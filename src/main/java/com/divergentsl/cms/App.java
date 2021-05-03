package com.divergentsl.cms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.divergentsl.cms.cms.AdminMenu;
import com.divergentsl.cms.cms.MainMenu;
import com.divergentsl.cms.config.AppConfig;

public class App 
{
    public static void main( String[] args )
    {
    	    	
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	MainMenu mainMenu = context.getBean(MainMenu.class);
        
    	mainMenu.mainMenu();
    	
    	
    }
}
