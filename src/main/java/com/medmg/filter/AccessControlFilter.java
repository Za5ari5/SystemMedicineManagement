package com.medmg.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AccessControlFilter implements Filter {
    private static final String[] EXCLUDED_PAGES = {"/log.jsp"};
    private static final String[] EXCLUDED_PAGES2 = {"/Login"};
    private static final String[] USER_PAGES1 = {"/medmanage.jsp"}; 
    private static final String[] USER_PAGES2 = {"/Logout"};
    private static final String[] USER_PAGES3 = {"/navbar.jsp"};
    private static final String[] USER_PAGES4 = {"/sidebar.jsp"};
    


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
 
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
 
        HttpSession session = httpRequest.getSession(false);
 
        String requestedUrl = httpRequest.getRequestURI();
        String requestURL = httpRequest.getRequestURL().toString();
        System.out.print(requestURL);


        for (String excludedPage : EXCLUDED_PAGES) {
           if (requestURL.contains(excludedPage)) {
               chain.doFilter(request, response);
              return;
           }
        }

        for (String excludedPage : EXCLUDED_PAGES2) {
           if (requestURL.contains(excludedPage)) {
               chain.doFilter(request, response);
              return;
           }
        } 
 
        if (session != null && session.getAttribute("role") != null) {
            String role = (String) session.getAttribute("role");
 
            
            
            if (role.equals("admin")) {
                // Allow access to all pages
                chain.doFilter(request, response);
                

                
                
                
            } 
            else if (role.equals("user") || role.equals("sub-user")) {
                // Define a set of pages that the "user" and "sub-user" roles can access
                //Set<String> allowedUrls = new HashSet<>();
                //allowedUrls.add("/medmanage.jsp");
                //if (allowedUrls.contains(requestedUrl)) {
                    chain.doFilter(request, response);
                //} 
                    for (String excludedPage : USER_PAGES1) {
                        if (requestURL.contains(excludedPage)) {
                            chain.doFilter(request, response);
                           return;
                        }
                
                        else {
                    	// Redirect to an error page or display an error message
                    	httpResponse.sendRedirect(httpRequest.getContextPath() + "/log.jsp");
                        } 
                     }
                
                
                
                
                
                
                
            }
            else {
                // Redirect to an error page or display an error message
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/log.jsp");
            }
        } 
        
        
        
        
        else {
            // Redirect to the login page
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/log.jsp");
        }
    }
 
    // Other Filter methods
}

