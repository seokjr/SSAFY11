package com.ssafy.mvc.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;


public class MyListener2 implements ServletContextListener {

    public MyListener2() {
        // TODO Auto-generated constructor stub
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	 System.out.println("웹어플리케이션 시작될때 호출2");
    	 
    	 ServletContext context = sce.getServletContext();
    	 System.out.println("welcome : " + context.getInitParameter("welcome"));
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("웹어플리케이션 종료될때 호출2");
    }
	
}
