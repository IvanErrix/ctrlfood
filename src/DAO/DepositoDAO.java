package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Main.Controller;

public class DepositoDAO {
	
	public void AggiungiOrtofruttaAlDeposito(String nome, double prezzo, int quantita, Date data_scadenza, Date data_raccolta) throws SQLException {
		String sql = "CALL aggiungi_ortofrutta_deposito(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement query;
		query = Controller.getConnessione().getConn().prepareStatement(sql);
		query.setString(1, nome);
		query.setDouble(2, prezzo);
		query.setInt(3, quantita);
		query.setDate(4, data_scadenza);
		query.setBoolean(5, true);
		query.setDate(6, data_raccolta);
		query.executeUpdate();
	}

}
