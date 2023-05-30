package com.medmg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medmg.dao.MediDao;
import com.medmg.db.DbCnx;



public class DeleteMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public DeleteMedicine() {
        super();
    }


    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			int del_mid = Integer.parseInt(request.getParameter("del-mid"));
			
			
			try {
				MediDao mdao = new MediDao(DbCnx.getConnection());
				mdao.deleteMedicine(del_mid);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			response.sendRedirect("/MedMg/manage_medicines.jsp");
		
	}

}
}
