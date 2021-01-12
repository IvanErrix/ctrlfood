package main;

import java.awt.EventQueue;

public class Controller {
	
	static DAO dao = new DAO();

	public static void main(String[] args) {
		
		if(dao.getConn() != null) {
			EventQueue.invokeLater(new Runnable() {
	    		public void run() {
	    			try {
	    				Controller ctrl= new Controller();
	    				System.out.println("Connessione avvenuta");
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

}
