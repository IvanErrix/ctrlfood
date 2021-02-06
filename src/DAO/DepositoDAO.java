package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import Main.Controller;
import Objects.Prodotto;

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
		String sql = "CALL aggiungi_confezionato_depostio(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement query;
		query = Controller.getConnessione().getConn().prepareStatement(sql);
		query.setString(1, nome);
		query.setDouble(2, prezzo);
		query.setInt(3, quantita);
		query.setDate(4, data_scadenza);
		query.setBoolean(5, true);
		query.setDate(6, data_confezionamento);
		query.executeUpdate();
	}
	
	public void AggiungiLatticinoAlDeposito(String nome, double prezzo, int quantita, Date data_scadenza, Date data_mungitura, Date data_produzione)throws SQLException {
		String sql ="CALL aggiungi_latticino_deposito(?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement query;
		query = Controller.getConnessione().getConn().prepareStatement(sql);
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
		String sql = "CALL aggiungi_farinaceo_deposito(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement query;
		query = Controller.getConnessione().getConn().prepareStatement(sql);
		query.setString(1, nome);
		query.setDouble(2, prezzo);
		query.setInt(3, quantita);
		query.setDate(4, data_scadenza);
		query.setBoolean(5, true);
		query.setDate(6, data_produzione);
		query.executeUpdate();
	}
	
	public void AggiungiUovoAlDeposito(String nome, double prezzo, int quantita, Date data_scadenza, Date data_deposizione)throws SQLException{
		String sql = "CALL aggiungi_uovo_deposito(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement query;
		query = Controller.getConnessione().getConn().prepareStatement(sql);
		query.setString(1, nome);
		query.setDouble(2, prezzo);
		query.setInt(3, quantita);
		query.setDate(4, data_scadenza);
		query.setBoolean(5, true);
		query.setDate(6, data_deposizione);
		query.executeUpdate();
	}
	
	public ArrayList<Prodotto> CaricaProdottiDeposito(Controller ctrl) throws SQLException{

		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
		String sql = "CALL recupera_prodotti_deposito()";

		PreparedStatement query = null;
		query = Controller.getConnessione().getConn().prepareStatement(sql);
		ResultSet datiRecuperati = null;
		datiRecuperati = query.executeQuery();

		while(datiRecuperati.next())
			prodotti.add(new Prodotto(datiRecuperati.getInt(1), datiRecuperati.getString(2), datiRecuperati.getDouble(3), datiRecuperati.getInt(4), datiRecuperati.getDate(5),
					datiRecuperati.getBoolean(6), datiRecuperati.getBoolean(7), datiRecuperati.getBoolean(8), datiRecuperati.getBoolean(9), datiRecuperati.getBoolean(10),
					datiRecuperati.getDate(11), datiRecuperati.getDate(12), datiRecuperati.getDate(13), datiRecuperati.getDate(14), datiRecuperati.getDate(15)));


		return prodotti;

	}

	public void EliminaProdottoDeposito(int idprodotto) {
		String sql = "CALL elimina_prodotto_deposito(?)";
		
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
