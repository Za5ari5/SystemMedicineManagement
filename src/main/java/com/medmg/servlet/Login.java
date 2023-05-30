package com.medmg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medmg.dao.UserDao;
import com.medmg.db.DbCnx;
import com.medmg.model.User;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String username = request.getParameter("login-username");
			String password = request.getParameter("login-password");
			
			UserDao udao = new UserDao(DbCnx.getConnection());
			User user = udao.userLogin(username, password);
			String role = user.getRole();
			
			//if (user != null) {
	        	System.out.print(user.getId()+" " + user.getUsername()+" "+ user.getRole());

				request.getSession().setAttribute("auth", user);
				request.getSession().setAttribute("role", user.getRole());
				request.getSession().setAttribute("user_id", user.getId());

				response.sendRedirect("/MedMg/index.jsp");
				//out.print("user logged in");
				//response.sendRedirect("/PetShopWebApp/HomePage");
			//} else {
				//response.sendRedirect("/MedMg/login.jsp");
				//out.println("there is no user");
			//}

		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		} 
	}

}
