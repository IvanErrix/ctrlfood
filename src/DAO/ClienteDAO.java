package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Main.Controller;
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
			ResultSet datirecuperati = null;
			datirecuperati = query.executeQuery();
			
			while(datirecuperati.next()) {
				clienti.add(new Cliente(datirecuperati.getInt(1), datirecuperati.getString(2), datirecuperati.getString(3), datirecuperati.getString(4), datirecuperati.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clienti;
	}
	
	public ArrayList<Integer> CaricaPuntidFedelta() {
		
		ArrayList<Integer> punti = new ArrayList<Integer>();
		String sql = "CALL recupera_punti_fedelta";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			ResultSet datirecuperati = null;
			datirecuperati = query.executeQuery();
			
			while(datirecuperati.next()) {
				punti.add(new Integer(datirecuperati.getInt(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return punti;
	}
	
	public void EliminaCliente(int idcliente) {
		String sql = "CALL elimina_cliente(?)";
		
		PreparedStatement query;
		try {
			query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setInt(1, idcliente);
			query.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
