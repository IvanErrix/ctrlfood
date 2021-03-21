package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Main.Controller;

public class PagamentoDAO {
	
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
