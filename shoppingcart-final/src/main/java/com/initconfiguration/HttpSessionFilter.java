package com.initconfiguration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpSessionFilter implements Filter {
	   @Override
	   public void destroy() {}

	   @Override
	   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	      throws IOException, ServletException
	   {
		   
	      HttpServletRequest req=(HttpServletRequest)request;
	      HttpServletResponse res=(HttpServletResponse)response;
	      HttpSession session=req.getSession();
	      if(session != null && !session.isNew())
	      {
	    	    chain.doFilter(request, response);
	    	} 
	      else {
	    	    res.sendRedirect("../");
	    	}
	     
	   }

	   @Override
	   public void init(FilterConfig filterconfig) throws ServletException {}
	}