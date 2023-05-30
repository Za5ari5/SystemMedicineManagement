package com.medmg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medmg.model.*;

public class MediDao {
	

		private Connection con;

		private String query;
	    private PreparedStatement pst;
	    private ResultSet rs;
	    

		public MediDao(Connection con) {
			super();
			this.con = con;
		}
		
		
		
		
		public int addMedicine(Medicine med) {
			int result = 0;
			try {
				query = "INSERT INTO medicines(`name`,`type`,`category`,"
						+ "`production_date`,`expiration_date`,`quantity`)"
						+ "VALUES(?,?,?,?,?,?); ";
			            pst = this.con.prepareStatement(query);
			            pst.setString(1, med.getName());
			            pst.setString(2, med.getType());
			            pst.setString(3, med.getCategory());
			            pst.setString(4, med.getProduction_date());
			            pst.setString(5, med.getExpiration_date());
			            pst.setInt(6, med.getQuantity());
			            System.out.println(pst);
			            result = pst.executeUpdate();		            

			} catch (SQLException e) {
	            System.out.print(e.getMessage());
	        }
			return result;
		}
		
		
		
		
		public List<Medicine> getAllMedicines() {
	        List<Medicine> medicines = new ArrayList<>();
	        try {

	            query = "select * from medicines";
	            pst = this.con.prepareStatement(query);
	            rs = pst.executeQuery();

	            while (rs.next()) {
	            	Medicine row = new Medicine();
	                row.setId(rs.getInt("id"));
	                row.setName(rs.getString("name"));
	                row.setType(rs.getString("type"));
	                row.setCategory(rs.getString("category"));
	                row.setProduction_date(rs.getString("production_date"));
	                row.setExpiration_date(rs.getString("expiration_date"));
	                row.setQuantity(rs.getInt("quantity"));

	                medicines.add(row);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        return medicines;

			}
		
		
		
		
		
	    public void updateMedicine(int id, Medicine medicine) throws SQLException {
	        String query = "UPDATE medicines SET name = ?, type = ?, category = ?, production_date = ?, expiration_date = ?, quantity = ? WHERE id = ?";
	        
	        try (PreparedStatement statement = con.prepareStatement(query)) {
	            statement.setString(1, medicine.getName());
	            statement.setString(2, medicine.getType());
	            statement.setString(3, medicine.getCategory());
	            statement.setString(4, medicine.getProduction_date());
	            statement.setString(5, medicine.getExpiration_date());
	            statement.setInt(6, medicine.getQuantity());
	            statement.setInt(7, medicine.getId());
	            

	            statement.executeUpdate();
	        }
	
}
	    
	    
	    public boolean deleteMedicine(int medicineId) {
	        String query = "DELETE FROM medicines WHERE id = ?";

	        try {
	            PreparedStatement statement = con.prepareStatement(query);
	            statement.setInt(1, medicineId);
	            int rowsDeleted = statement.executeUpdate();

	            return rowsDeleted > 0; // Return true if at least one row was deleted
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle the exception or throw it further
	        }

	        return false; // Return false if the delete operation was unsuccessful
	    }
	    
	    
	    
	    public void updateQuantity(int id, int quantity) throws SQLException {
	        String sql = "UPDATE medicines SET quantity = quantity - ? WHERE id = ?";

	        try (PreparedStatement statement = con.prepareStatement(sql)) {
	            // Set the parameter values
	            statement.setInt(1, quantity);
	            statement.setInt(2, id);

	            // Execute the update query
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace(); // Handle or log the exception as per your needs
	        }
	        }
}