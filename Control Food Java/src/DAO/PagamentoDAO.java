package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Main.Controller;

public class PagamentoDAO {
	
	public void AggiornaPunti(double puntiortofrutta, double puntilatticini, double puntifarinacei, double puntiuova, double punticonfezionati, int cartafedelta ) {
		String sql = "CALL aggiorna_punti(?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setDouble(1, puntiortofrutta);
			query.setDouble(2, puntilatticini);
			query.setDouble(3, puntifarinacei);
			query.setDouble(4, puntiuova);
			query.setDouble(5, punticonfezionati);
			query.setInt(6, cartafedelta);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void AggiungiPagamento(int chiavecarrello, int chiavecartafedelta) {
		String sql = "CALL aggiungi_pagamento(?,?)";
		
		try {
			PreparedStatement query= Controller.getConnessione().getConn().prepareStatement(sql);
			query.setInt(1, chiavecarrello);
			query.setInt(2, chiavecartafedelta);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void AggiungiPagamentoSenzaCarta(int chiavecarrello) {
		String sql = "CALL aggiungi_pagamento_senza_carta(?)";
		
		try {
			PreparedStatement query= Controller.getConnessione().getConn().prepareStatement(sql);
			query.setInt(1, chiavecarrello);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
