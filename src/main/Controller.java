package main;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JPanel;

public class Controller {
	
	static DAO dao = new DAO();
	
	
	public static void main(String[] args) {
		
		if(dao.getConn() != null) {
			EventQueue.invokeLater(new Runnable() {
	    		public void run() {
	    			try {
	    				Controller ctrl= new Controller();
	    				System.out.println("Connessione avvenuta");
	    				FramePrincipale frameprincipale = new FramePrincipale(ctrl);
	    				frameprincipale.setVisible(true);
	    			} catch (Exception e) {
	    				e.printStackTrace();
	    			}
	    		}
	    	});
		}
		else {
			System.exit(0);
		}
	}
	
	
	public void ApriDepositoPanel(Controller ctrl, JPanel PanelCaricamento) {
		DepositoPanel deposito = new DepositoPanel(ctrl);
		deposito.setVisible(true);
		PanelCaricamento.removeAll();
		PanelCaricamento.add(deposito);
		PanelCaricamento.repaint();
		PanelCaricamento.revalidate();
	}
	
	public void ApriAggiungiAlDepositoDialog(Controller ctrl) {
		AggiungiAlDepositoDialog dialog = new AggiungiAlDepositoDialog(ctrl);
		dialog.setVisible(true);
	}
	
	public void ApriNegozioPanel(Controller ctrl, JPanel PanelCaricamento) {
		NegozioPanel negozio = new NegozioPanel(ctrl);
		negozio.setVisible(true);
		PanelCaricamento.removeAll();
		PanelCaricamento.add(negozio);
		PanelCaricamento.repaint();
		PanelCaricamento.revalidate();
	}
	
	public void ApriClientiPanel(Controller ctrl, JPanel PanelCaricamento) {
		ClientiPanel clienti = new ClientiPanel(ctrl);
		clienti.setVisible(true);
		PanelCaricamento.removeAll();
		PanelCaricamento.add(clienti);
		PanelCaricamento.repaint();
		PanelCaricamento.revalidate();
	}
}
