package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Main.Controller;

public class Connessione {
	
	private Connection conn;
	
	public  Connessione() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				conn = DriverManager.getConnection("jdbc:mysql://den1.mysql4.gear.host/ctrlfood", "ctrlfood", "Po3IZ79Y?C_6");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Connessione al server fallita", "ERRORE", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
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
