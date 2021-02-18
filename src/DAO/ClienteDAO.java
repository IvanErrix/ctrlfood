package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Main.Controller;
import Objects.CartaFedelta;
import Objects.Cliente;

public class ClienteDAO {
	
	public void AggiungiCliente(String nome, String cognome, String codice_fiscale) {
		String sql = "CALL aggiungi_cliente(?, ?, ?)";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			
			query.setString(1, nome);
			query.setString(2, cognome);
			query.setString(3, codice_fiscale);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Cliente> CaricaClienti() {
		
		ArrayList<Cliente> clienti = new ArrayList<Cliente>();
		
		String sql = "CALL recupera_clienti";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			ResultSet datirecuperati = query.executeQuery();
			
			while(datirecuperati.next()) {
				clienti.add(new Cliente(datirecuperati.getInt(1), datirecuperati.getString(2), datirecuperati.getString(3), datirecuperati.getString(4), datirecuperati.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clienti;
	}
	
	public ArrayList<CartaFedelta> CaricaPuntidFedelta() {
		
		ArrayList<CartaFedelta> carte = new ArrayList<CartaFedelta>();
		String sql = "CALL recupera_punti_fedelta";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			ResultSet datirecuperati = query.executeQuery();
			
			while(datirecuperati.next()) {
				carte.add(new CartaFedelta(datirecuperati.getInt(1), datirecuperati.getDouble(2), datirecuperati.getDouble(3), datirecuperati.getDouble(4), datirecuperati.getDouble(5), datirecuperati.getDouble(6), datirecuperati.getDouble(7), datirecuperati.getDate(8), datirecuperati.getInt(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return carte;
	}
	
	public void EliminaCliente(int idcliente) {
		String sql = "CALL elimina_cliente(?)";
		
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setInt(1, idcliente);
			query.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void AggiornaDatiCliente (int idcliente, String nome, String cognome, String codicefiscale) {
		String sql = "CALL aggiorna_dati_cliente(?, ?, ?, ?)";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setInt(1,idcliente);
			query.setString(2, nome);
			query.setString(3, cognome);
			query.setString(4, codicefiscale);
			query.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
