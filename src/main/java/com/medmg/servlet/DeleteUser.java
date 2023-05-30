package com.medmg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medmg.dao.UserDao;
import com.medmg.db.DbCnx;

/**
 * Servlet implementation class DeleteUser
 */
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
        super();

    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			int del_uid = Integer.parseInt(request.getParameter("del-uid"));
			
			
			try {
				UserDao udao = new UserDao(DbCnx.getConnection());
				udao.deleteUser(del_uid);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        response.sendRedirect("/MedMg/manage_users.jsp");
		}
		
	}

}
