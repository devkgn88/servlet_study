package com.gn.study.common;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestLoggerListener implements ServletRequestListener {

    public RequestLoggerListener() {
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("🌍 새로운 요청이 들어왔습니다!");
    }
    public void requestDestroyed(ServletRequestEvent sre)  { 
        System.out.println("🔚 요청이 처리되었습니다.");
    }
}
