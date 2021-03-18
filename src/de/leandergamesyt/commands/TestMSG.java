package de.leandergamesyt.commands;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.mysql.jdbc.PreparedStatement;


public class TestMSG implements CommandExecutor{
	
	String server = "ventany.kappagames.de";
	String user = "testuser";
	String pw = "test";
	String query;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		query = "INSERT INTO test " + args[0] + ";";
		
		try {
			Connection con = DriverManager.getConnection(server, user, pw);
			
			PreparedStatement prepStmt = (PreparedStatement) con.prepareStatement(query);
			prepStmt.setString(1, args[0]);
			prepStmt.execute();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	


}
