package com.medmg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medmg.dao.MediDao;
import com.medmg.db.DbCnx;
import com.medmg.model.Medicine;



public class UpdateMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateMedicine() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			int upmid = Integer.parseInt(request.getParameter("id"));  
			String name = request.getParameter("new-medname");
			String type = request.getParameter("new-medtype");			
			String category = request.getParameter("new-medcategory");
			String production_date = request.getParameter("new-medprodate");

			String expiration_date = request.getParameter("new-medexpdate");
			int quantity = Integer.parseInt(request.getParameter("new-medquantity"));
			System.out.println(upmid+name+type+category+production_date+expiration_date+quantity);



			
			
			Medicine med = new Medicine();
			med.setId(upmid);
			med.setName(name);
			med.setType(type);
			med.setCategory(category);
			med.setProduction_date(production_date);
			med.setExpiration_date(expiration_date);
			med.setQuantity(quantity);


			
			try {
				MediDao mdao = new MediDao(DbCnx.getConnection());
				mdao.updateMedicine(upmid, med);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			response.sendRedirect("/MedMg/upmedicine.jsp");

	    }
		
	}

}
