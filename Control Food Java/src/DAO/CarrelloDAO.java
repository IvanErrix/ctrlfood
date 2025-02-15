package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Main.Controller;
import Objects.Prodotto;

public class CarrelloDAO {
	
	public void CreaCarrello() {
		String sql = "CALL crea_carrello()";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void EliminaCarrelliNonPagati() {
		String sql = "CALL elimina_carrelli_non_pagati()";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int RecuperaCarrello() {
		String sql = "SELECT recupera_carrello()";
		
		int id = 0;
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			ResultSet datirecuperati = query.executeQuery();
			if(datirecuperati.next()) {
				id = datirecuperati.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	public void AggiungiProdottoAlCarrello(int idcarrello, int idprodotto, int quantita) {
		String sql = "CALL aggiungi_prodotto_carrello(?, ?, ?)";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			
			query.setInt(1, idcarrello);
			query.setInt(2, idprodotto);
			query.setInt(3, quantita);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Prodotto> RecuperaProdottiCarrello(){
		String sql = "SELECT * FROM recupera_prodotti_carrello() ORDER BY idprodotto";
		
		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			
			ResultSet datiRecuperati = query.executeQuery();
			
			while(datiRecuperati.next()) 
				prodotti.add(new Prodotto(datiRecuperati.getInt(1), datiRecuperati.getString(2), datiRecuperati.getDouble(3), 
						datiRecuperati.getInt(4), datiRecuperati.getDate(5), datiRecuperati.getString(6),datiRecuperati.getDate(7), 
						datiRecuperati.getDate(8), datiRecuperati.getDate(9), datiRecuperati.getDate(10), datiRecuperati.getDate(11)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prodotti;
		
		
	}
	
	public void EliminaProdottoCarrello(int idprodotto) {
		String sql = "CALL elimina_prodotto_carrello(?)";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setInt(1, idprodotto);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void AggiornaCarrello(int idcarrello) {
		String sql ="CALL aggiorna_carrello(?)";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setInt(1, idcarrello);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
