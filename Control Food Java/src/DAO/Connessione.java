package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Connessione {
	
	private Connection conn;
	
	public  Connessione() {

		try {
			Class.forName("org.postgresql.Driver");
			try {
				conn = DriverManager.getConnection("jdbc:postgresql://ctrlfood-test.cwnsdb7npcei.eu-south-1.rds.amazonaws.com/CtrlFoodTest", "postgres", "ctrlfood");
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
