package com.medmg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medmg.dao.UserDao;
import com.medmg.db.DbCnx;
import com.medmg.model.User;




public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateUser() {
        super();

        
        
    }


    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
	}



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			int upuid = Integer.parseInt(request.getParameter("upuid"));  
		
			String username = request.getParameter("new-username");
			String password = request.getParameter("new-password");			
			String first_name = request.getParameter("new-fname");
			String last_name = request.getParameter("new-lname");
			String medical_facility_name = request.getParameter("new-mfn");
			String service = request.getParameter("new-service");
			String email = request.getParameter("new-email");
			String role = request.getParameter("new-role");
			//
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setFirst_name(first_name);
			user.setLast_name(last_name);
			user.setMedical_facility_name(medical_facility_name);
			user.setService(service);
			user.setEmail(email);
			user.setRole(role);
			//
			try {
				UserDao udao = new UserDao(DbCnx.getConnection());
				udao.updateUser(upuid, user);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        response.sendRedirect("/MedMg/upuser.jsp");
	    }

		
	}

}
