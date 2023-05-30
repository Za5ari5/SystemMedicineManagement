package com.medmg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.medmg.model.Command;
import com.medmg.model.Medicine;

public class CommandDao {

	
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    

	public CommandDao(Connection con) {
		super();
		this.con = con;
	}
	
	
	
	
	public int addCommand(Command cmd) {
		int result = 0;
		try {
			query = "INSERT INTO commands(`user_id`,`med_id`,`quantity`)"
					+ "VALUES(?,?,?); ";
		            pst = this.con.prepareStatement(query);
		            pst.setInt(1, cmd.getUser_id());
		            pst.setInt(2, cmd.getMedicine_id());
		            pst.setInt(3, cmd.getQuantity());
		            System.out.println(pst);
		            result = pst.executeUpdate();		            

		} catch (SQLException e) {
            System.out.print(e.getMessage());
        }
		return result;
	}
	
	public List<Command> getAllCommands() {
        List<Command> commands = new ArrayList<>();
        
        try {

            query = "select * from commands";
            query= "SELECT c.id, c.user_id, c.med_id, c.quantity, c.command_date, m.`name` AS medicine_name, u.username AS user_name FROM commands c JOIN medicines m ON c.med_id = m.id JOIN users u ON c.user_id = u.id;";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while (rs.next()) {
            	 Command row = new Command();
            	 row.setUser_id(rs.getInt("user_id"));
		         row.setMedicine_id(rs.getInt("med_id"));
		         row.setQuantity(rs.getInt("quantity"));
		         row.setCommand_date(dateFormat.format(rs.getTimestamp("command_date")));
		         row.setCommander_name(rs.getString("user_name"));
		         row.setMedicine_name(rs.getString("medicine_name"));
		         

                commands.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return commands;
}
}
