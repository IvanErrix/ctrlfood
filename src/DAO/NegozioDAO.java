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
		String sql = "CALL recupera_prodotti_negozio()";

		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			ResultSet datiRecuperati = null;
			datiRecuperati = query.executeQuery();

			while(datiRecuperati.next())
				prodotti.add(new Prodotto(datiRecuperati.getInt(1), datiRecuperati.getString(2), datiRecuperati.getDouble(3), datiRecuperati.getInt(4), datiRecuperati.getDate(5),
						datiRecuperati.getBoolean(6), datiRecuperati.getBoolean(7), datiRecuperati.getBoolean(8), datiRecuperati.getBoolean(9), datiRecuperati.getBoolean(10),
						datiRecuperati.getDate(11), datiRecuperati.getDate(12), datiRecuperati.getDate(13), datiRecuperati.getDate(14), datiRecuperati.getDate(15)));
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
			query.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void SpostaProdottoDalNegozio(int idprodotto) {
		String sql = "CALL sposta_prodotto_dal_negozio(?)";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setInt(1, idprodotto);
			query.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
