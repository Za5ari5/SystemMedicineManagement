package com.medmg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.medmg.model.User;

public class UserDao {
	private Connection con;
	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
	public UserDao(Connection con) {
		this.con = con;
	}
	public User userLogin(String username, String password) {
		User user = null;
        try {
            query = "select * from users where username=? and password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt("id"));
            	user.setUsername(rs.getString("username"));
            	user.setPassword(rs.getString("password"));
            	user.setMedical_facility_name(rs.getString("medical_facility_name"));
            	user.setService(rs.getString("service"));
            	user.setFirst_name(rs.getString("first_name"));
            	user.setLast_name(rs.getString("last_name"));
            	user.setEmail(rs.getString("email"));
            	user.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }
	
	
	public int addUser(User user) {
		int result = 0;
		try {
			query = "INSERT INTO users(`username`,`password`,`first_name`,"
					+ "`last_name`,`medical_facility_name`,`service`,"
					+ "`email`,`role`)"
					+ "VALUES(?,?,?,?,?,?,?,?); ";
		            pst = this.con.prepareStatement(query);
		            pst.setString(1, user.getUsername());
		            pst.setString(2, user.getPassword());
		            pst.setString(3, user.getFirst_name());
		            pst.setString(4, user.getLast_name());
		            pst.setString(5, user.getMedical_facility_name());
		            pst.setString(6, user.getService());
		            pst.setString(7, user.getEmail());
		            pst.setString(8, user.getRole());
		            System.out.println(pst);
		            result = pst.executeUpdate();		            

		} catch (SQLException e) {
            System.out.print(e.getMessage());
        }
		return result;
	}
	
	public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {

            query = "select * from users";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
            	User row = new User();
                row.setId(rs.getInt("id"));
                row.setUsername(rs.getString("username"));
                row.setPassword(rs.getString("password"));
                row.setFirst_name(rs.getString("first_name"));
                row.setLast_name(rs.getString("last_name"));
                row.setMedical_facility_name(rs.getString("medical_facility_name"));
                row.setService(rs.getString("service"));
                row.setEmail(rs.getString("email"));
                row.setRole(rs.getString("role"));
                users.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return users;

		}
	
	
	
	
	
    public void updateUser(int id, User user) throws SQLException {
        String query = "UPDATE users SET username = ?, password = ?, first_name = ?, " +
                "last_name = ?, medical_facility_name = ?, service = ?, email = ?, role = ? WHERE id = ?";
        
        try (PreparedStatement pst = con.prepareStatement(query)) {
     
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getFirst_name());
            pst.setString(4, user.getLast_name());
            pst.setString(5, user.getMedical_facility_name());
            pst.setString(6, user.getService());
            pst.setString(7, user.getEmail());
            pst.setString(8, user.getRole());
            pst.setInt(9, id);
            

            pst.executeUpdate();
        }

}
    
    
    public boolean deleteUser(int uid) {
        String query = "DELETE FROM users WHERE id = ?";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, uid);
            int rowsDeleted = statement.executeUpdate();

            return rowsDeleted > 0; // Return true if at least one row was deleted
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or throw it further
        }

        return false; // Return false if the delete operation was unsuccessful
    }
	
}
	