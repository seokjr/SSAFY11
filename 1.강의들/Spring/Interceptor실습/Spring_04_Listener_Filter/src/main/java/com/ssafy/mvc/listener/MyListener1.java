package com.ssafy.mvc.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

//@WebListener
public class MyListener1 implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyListener1() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("웹어플리케이션 시작될때 호출1");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	 System.out.println("웹어플리케이션 종료될때 호출1");
    }
	
}
