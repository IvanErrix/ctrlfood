package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Main.Controller;

public class LoginAmministratoreDAO {
	
	public String ControllaDatiLogin(String username, String password) {
		String sql = "SELECT public.controllo_dati_login(?, ?)";
		
		String idamministratore = null;
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setString(1, username);
			query.setString(2, password);
			
			ResultSet datiRecuperati = query.executeQuery();
			
			datiRecuperati.next();
			idamministratore = datiRecuperati.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return idamministratore;
	}

}
