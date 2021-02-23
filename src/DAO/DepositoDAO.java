package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Main.Controller;
import Objects.Prodotto;

public class DepositoDAO {

	public void AggiungiOrtofruttaAlDeposito(String nome, double prezzo, int quantita, Date data_scadenza, Date data_raccolta) {
		String sql = "CALL aggiungi_ortofrutta_deposito(?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setString(1, nome);
			query.setDouble(2, prezzo);
			query.setInt(3, quantita);
			query.setDate(4, data_scadenza);
			query.setBoolean(5, true);
			query.setDate(6, data_raccolta);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void AggiungiConfezionatoAlDeposito(String nome, double prezzo, int quantita, Date data_scadenza, Date data_confezionamento) {
		String sql = "CALL aggiungi_confezionato_depostio(?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setString(1, nome);
			query.setDouble(2, prezzo);
			query.setInt(3, quantita);
			query.setDate(4, data_scadenza);
			query.setBoolean(5, true);
			query.setDate(6, data_confezionamento);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void AggiungiLatticinoAlDeposito(String nome, double prezzo, int quantita, Date data_scadenza, Date data_mungitura, Date data_produzione) {
		String sql ="CALL aggiungi_latticino_deposito(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setString(1, nome);
			query.setDouble(2, prezzo);
			query.setInt(3, quantita);
			query.setDate(4, data_scadenza);
			query.setBoolean(5, true);
			query.setDate(6, data_mungitura);
			query.setDate(7, data_produzione);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void AggiungiFarinaceoAlDeposito(String nome, double prezzo, int quantita, Date data_scadenza, Date data_produzione) {
		String sql = "CALL aggiungi_farinaceo_deposito(?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setString(1, nome);
			query.setDouble(2, prezzo);
			query.setInt(3, quantita);
			query.setDate(4, data_scadenza);
			query.setBoolean(5, true);
			query.setDate(6, data_produzione);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void AggiungiUovoAlDeposito(String nome, double prezzo, int quantita, Date data_scadenza, Date data_deposizione) {
		String sql = "CALL aggiungi_uovo_deposito(?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setString(1, nome);
			query.setDouble(2, prezzo);
			query.setInt(3, quantita);
			query.setDate(4, data_scadenza);
			query.setBoolean(5, true);
			query.setDate(6, data_deposizione);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Prodotto> CaricaProdottiDeposito(Controller ctrl) {

		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
		String sql = "CALL recupera_prodotti_deposito()";

		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			ResultSet datiRecuperati = query.executeQuery();

			while(datiRecuperati.next()) 
				prodotti.add(new Prodotto(datiRecuperati.getInt(1), datiRecuperati.getString(2), datiRecuperati.getDouble(3), datiRecuperati.getInt(4), datiRecuperati.getDate(5),
						datiRecuperati.getBoolean(6), datiRecuperati.getBoolean(7), datiRecuperati.getBoolean(8), datiRecuperati.getBoolean(9), datiRecuperati.getBoolean(10),
						datiRecuperati.getDate(11), datiRecuperati.getDate(12), datiRecuperati.getDate(13), datiRecuperati.getDate(14), datiRecuperati.getDate(15)));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return prodotti;

	}

	public void EliminaProdottoDeposito(int idprodotto) {
		String sql = "CALL elimina_prodotto(?)";
		
		PreparedStatement query;
		try {
			query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setInt(1, idprodotto);
			query.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
