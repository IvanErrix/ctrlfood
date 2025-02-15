package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Main.Controller;
import Objects.Prodotto;

public class NegozioDAO {
	
	public ArrayList<Prodotto> CaricaProdottiNegozio() {

		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
		String sql = "SELECT * FROM recupera_prodotti_negozio() ORDER BY idprodotto";

		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			ResultSet datiRecuperati = query.executeQuery();

			while(datiRecuperati.next())
				prodotti.add(new Prodotto(datiRecuperati.getInt(1), datiRecuperati.getString(2), datiRecuperati.getDouble(3), datiRecuperati.getInt(4), 
						datiRecuperati.getDate(5), datiRecuperati.getString(6), datiRecuperati.getDate(7), datiRecuperati.getDate(8), 
						datiRecuperati.getDate(9), datiRecuperati.getDate(10), datiRecuperati.getDate(11)));
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return prodotti;
	}
	
	public void AggiungiProdottoAlNegozio(int idprodotto, int quantita) {
		String sql ="CALL aggiungi_prodotto_negozio(?,?)";
		
		try {
			PreparedStatement query= Controller.getConnessione().getConn().prepareStatement(sql);
			query.setInt(1,idprodotto);
			query.setInt(2, quantita);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void SpostaProdottoDalNegozio(int idprodotto) {
		String sql = "CALL sposta_prodotto_dal_negozio(?)";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setInt(1, idprodotto);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void EliminaProdottoNegozio(int idprodotto) {
		String sql = "CALL elimina_prodotto(?)";
		
		PreparedStatement query;
		try {
			query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setInt(1, idprodotto);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
