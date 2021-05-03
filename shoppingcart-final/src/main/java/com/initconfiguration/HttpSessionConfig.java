package com.initconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.LoginService;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Configuration
public class HttpSessionConfig {
	
	@Autowired
	LoginService loginservice;
	
    @Bean                           
    public HttpSessionListener httpSessionListener() {
        return new HttpSessionListener() {
            @Override
            public void sessionCreated(HttpSessionEvent se)
            {             
            	//se.getSession().setMaxInactiveInterval(1);
                System.out.println("Session Created with session id+" + se.getSession().getId());
            }
            @Override
            public void sessionDestroyed(HttpSessionEvent se)
            {        
            	HttpSession session=se.getSession();
            	Object n=session.getAttribute("username");
            	Object p=session.getAttribute("password");
        		if(n!=null)
        		{
        			String name=(String)n;
        			String password=(String)p;
        			loginservice.updateFlag(name,password, 0);
        			
        		}
        		
                System.out.println("Session Destroyed, Session id:" + se.getSession().getId());
               
            }
        };
    }

}