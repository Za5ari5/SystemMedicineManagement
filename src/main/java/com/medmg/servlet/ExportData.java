package com.medmg.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.medmg.dao.MediDao;
import com.medmg.db.DbCnx;
import com.medmg.model.Medicine;


public class ExportData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ExportData() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {


			MediDao md = new MediDao(DbCnx.getConnection());
			List<Medicine> medicines = md.getAllMedicines();

			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=Commands.xlsx");
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("Table Data");

			//int rowNum = 0;
			//while (resultSet.next()) {
			// Row row = sheet.createRow(rowNum++);
			// Assuming the table has three columns: column1, column2, and column3
			// row.createCell(0).setCellValue(resultSet.getString("column1"));
			// row.createCell(1).setCellValue(resultSet.getString("column2"));
			//  row.createCell(2).setCellValue(resultSet.getString("column3"));
			// }
			Row headerRow = sheet.createRow(0);
			headerRow.createCell(0).setCellValue("Id");
			headerRow.createCell(1).setCellValue("Name");
			headerRow.createCell(2).setCellValue("Type");
			headerRow.createCell(3).setCellValue("Category");
			headerRow.createCell(4).setCellValue("Production date");
			headerRow.createCell(5).setCellValue("Expiration date");
			headerRow.createCell(6).setCellValue("Quantity");

			if (!medicines.isEmpty()) {
				int rowNum = 1;
				int id = 0;
				Row ro = sheet.createRow(0);
				ro.createCell(0).setCellValue("Id");
				ro.createCell(1).setCellValue("Name");
				ro.createCell(2).setCellValue("Type");
				ro.createCell(3).setCellValue("Category");
				ro.createCell(4).setCellValue("Production date");
				ro.createCell(5).setCellValue("Expiration date");
				ro.createCell(6).setCellValue("Quantity");

				for (Medicine m : medicines) {
					Row row = sheet.createRow(rowNum++);

					row.createCell(0).setCellValue(id++);
					row.createCell(1).setCellValue(m.getName());
					row.createCell(2).setCellValue(m.getType());
					row.createCell(3).setCellValue(m.getCategory());
					row.createCell(4).setCellValue(m.getProduction_date());
					row.createCell(5).setCellValue(m.getExpiration_date());
					row.createCell(6).setCellValue(m.getQuantity());

				}


				try (OutputStream outputStream = response.getOutputStream()) {
					workbook.write(outputStream);
				}
				workbook.close();


			}
		}

		catch(Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());

		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			

	}

}
