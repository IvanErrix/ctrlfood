package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Main.Controller;

public class ClienteDAO {
	
	public void AggiungiCliente(String nome, String cognome, String codice_fiscale) {
		String sql = "CALL aggiungi_cliente(?, ?, ?)";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			
			query.setString(1, nome);
			query.setString(2, cognome);
			query.setString(3, codice_fiscale);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
