package com.ciber.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * This Fiter class validate user valid user login or not
 * @author ssunkara
 *
 */
public class AuthenticationFilter implements Filter {
	 
    private ServletContext context;
     
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }
     
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        HttpSession session = req.getSession(false);
        boolean flag=false;
       if((uri.contains(".do")) || (uri.contains(".jsp"))){
    	   //below IndexS.jsp LoginSSO and Login page are entry point to login other pages need to verify user login or not.
    	   if(uri.contains("LoginPage") || uri.contains("LoginSSO") || uri.contains("Login")){
    		  
    	   }else{
    		   if(session!=null && session.getAttribute("user")!=null){
    			   
    		   }else{
    			flag=true;
    			   res.sendRedirect("./LoginPage.do");
    		   }
    	   }
       }
       if(!flag){
    		chain.doFilter(request, response);
       }
         
         
    }
 
     
 
    public void destroy() {
        //close any resources here
    }
 
}
