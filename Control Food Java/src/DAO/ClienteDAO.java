package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
			JOptionPane.showMessageDialog(null, "CLIENTE AGGIUNTO CORRETTAMENTE \nAGGIORNARE LA TABELLA PER VISUALIZZARLO", "", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "UTENTE GIA ESISTENTE NEL DATABASE CON QUESTO CODICE FISCALE", "", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public ArrayList<Cliente> CaricaClienti() {
		
		ArrayList<Cliente> clienti = new ArrayList<Cliente>();
		
		String sql = "SELECT * FROM recupera_clienti() ORDER BY idcliente";
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			ResultSet datirecuperati = query.executeQuery();
			
			while(datirecuperati.next()) {
				clienti.add(new Cliente(datirecuperati.getInt(1), datirecuperati.getString(2), datirecuperati.getString(3), datirecuperati.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clienti;
	}
	
	public void EliminaCliente(int idcliente) {
		String sql = "CALL elimina_cliente(?)";
		
		
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setInt(1, idcliente);
			query.executeUpdate();
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
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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
	
	public ArrayList<CartaFedelta> CaricaCartaFedelta() {
		
		ArrayList<CartaFedelta> carte = new ArrayList<CartaFedelta>();
		String sql = "SELECT * FROM recupera_carta_fedelta() ORDER BY idcarta_fedelta";
		
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
	
	public Integer ControlloEsistenzaCartaFedelta(int idcarta_fedelta_selezionata) {
	String sql = "SELECT public.controllo_esistenza_carta_fedelta(?)";
		
		Integer idcarta_fedelta = null;
		try {
			PreparedStatement query = Controller.getConnessione().getConn().prepareStatement(sql);
			query.setInt(1, idcarta_fedelta_selezionata);
			
			ResultSet datiRecuperati = query.executeQuery();
			
			datiRecuperati.next();
			idcarta_fedelta = datiRecuperati.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return idcarta_fedelta;
	}
}
