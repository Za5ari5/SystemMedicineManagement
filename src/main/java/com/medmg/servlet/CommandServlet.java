package com.medmg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medmg.dao.CommandDao;
import com.medmg.dao.MediDao;
import com.medmg.dao.UserDao;
import com.medmg.db.DbCnx;
import com.medmg.model.Command;


public class CommandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CommandServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int med_id = 1;
		int user_id = 1;
		int selected_quantity = 1;
		
		System.out.println(med_id+user_id +selected_quantity);
		
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			med_id = Integer.parseInt(request.getParameter("med-id"));
			user_id = Integer.parseInt(request.getParameter("user-id"));
			selected_quantity = Integer.parseInt(request.getParameter("selected-quantity"));
			System.out.println(med_id+user_id +selected_quantity);
			//int default_quantity = Integer.parseInt(request.getParameter("default-quantity"));

	
			Command cmd = new Command();
			cmd.setUser_id(user_id);
			cmd.setMedicine_id(med_id);
			cmd.setQuantity(selected_quantity);
			
			try {
				CommandDao cdao = new CommandDao(DbCnx.getConnection());
				cdao.addCommand(cmd);
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.print(e.getMessage());
	        }
			
			
			
			try {
				MediDao mdao = new MediDao(DbCnx.getConnection());
				mdao.updateQuantity(med_id , selected_quantity);
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.print(e.getMessage());
	        }
			response.sendRedirect("/MedMg/command_med.jsp");

			
	}
	}

}
