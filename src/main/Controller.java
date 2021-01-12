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
	
	
	public void ApriDepositoPanel(Controller ctrl) {
		DepositoPanel deposito = new DepositoPanel(ctrl);
		JPanel panel = new JPanel();
		deposito.setVisible(true);
	}

}
