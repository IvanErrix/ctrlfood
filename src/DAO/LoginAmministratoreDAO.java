package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Main.Controller;

public class LoginAmministratoreDAO {
	
	public String ControllaDatiLogin(String username, String password) throws SQLException {
		String sql = "SELECT controlla_dati_login(?, ?)";
		
		PreparedStatement query;
		query = Controller.getConnessione().getConn().prepareStatement(sql);
		query.setString(1, username);
		query.setString(2, password);
		
		ResultSet datiRecuperati = query.executeQuery();
		
		datiRecuperati.next();
		String idamministratore = datiRecuperati.getString(1);
		
		return idamministratore;
	}

}
