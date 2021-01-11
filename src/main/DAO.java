package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DAO {
	
	private Connection conn;
	
	public  DAO() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				conn = DriverManager.getConnection("jdbc:mysql://den1.mysql2.gear.host/spotyfree", "spotyfree", "ivan@2020");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Connessione al server fallita", "ERRORE", JOptionPane.ERROR_MESSAGE);
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
