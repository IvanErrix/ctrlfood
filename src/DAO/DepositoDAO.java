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
	
	public void AggiungiConfezionatoAlDeposito(String nome, double prezzo, int quantita, Date data_scadenza, Date data_confezionamento)throws SQLException{
		String sql2 = "CALL aggiungi_confezionato_depostio(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement query;
		query = Controller.getConnessione().getConn().prepareStatement(sql2);
		query.setString(1, nome);
		query.setDouble(2, prezzo);
		query.setInt(3, quantita);
		query.setDate(4, data_scadenza);
		query.setBoolean(5, true);
		query.setDate(6, data_confezionamento);
		query.executeUpdate();
	}
	
	public void AggiungiLatticinoAlDeposito(String nome, double prezzo, int quantita, Date data_scadenza, Date data_mungitura, Date data_produzione)throws SQLException {
		String sql3 ="CALL aggiungi_latticino_deposito(?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement query;
		query = Controller.getConnessione().getConn().prepareStatement(sql3);
		query.setString(1, nome);
		query.setDouble(2, prezzo);
		query.setInt(3, quantita);
		query.setDate(4, data_scadenza);
		query.setBoolean(5, true);
		query.setDate(6, data_mungitura);
		query.setDate(7, data_produzione);
		query.executeUpdate();
	}
	
	public void AggiungiFarinaceoAlDeposito(String nome, double prezzo, int quantita, Date data_scadenza, Date data_produzione)throws SQLException{
		String sql4 = "CALL aggiungi_farinaceo_deposito(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement query;
		query = Controller.getConnessione().getConn().prepareStatement(sql4);
		query.setString(1, nome);
		query.setDouble(2, prezzo);
		query.setInt(3, quantita);
		query.setDate(4, data_scadenza);
		query.setBoolean(5, true);
		query.setDate(6, data_produzione);
		query.executeUpdate();
	}
	
	public void AggiungiUovaAlDeposito(String nome, double prezzo, int quantita, Date data_scadenza, Date data_deposizione)throws SQLException{
		String sql5 = "CALL aggiungi_uovo_deposito(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement query;
		query = Controller.getConnessione().getConn().prepareStatement(sql5);
		query.setString(1, nome);
		query.setDouble(2, prezzo);
		query.setInt(3, quantita);
		query.setDate(4, data_scadenza);
		query.setBoolean(5, true);
		query.setDate(6, data_deposizione);
		query.executeUpdate();
	}

}
