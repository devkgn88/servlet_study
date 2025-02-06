package com.gn.study.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class AppListener implements ServletContextListener {

    public AppListener() {}

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("💡 웹 애플리케이션 시작");
    }
    
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("⚠ 웹 애플리케이션 종료");
    }

}
