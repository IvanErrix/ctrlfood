package main;

import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;

public class Controller {
	
	static DAO dao = new DAO();
	
	/*Prima di tutto il programma controlla la connessione. See la connessione � assente
	 *Se invece la connessione � presente, la funzione main fa partire la prima schermata
	 *del programma, ovvero FramePrincipale
	 */
	public static void main(String[] args) {
		UIManager.put("ComboBox.background", new Color(0, 67, 137));
//		UIManager.put("ScrollPane.background", new Color(0, 67, 137));
		UIManager.put("Table.gridColor", new Color(255, 213, 0));
		
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
	
	//Funzioni per l'apertura dei panel
	public void ApriDepositoPanel(Controller ctrl, JPanel PanelCaricamento) {
		DepositoPanel deposito = new DepositoPanel(ctrl);
		deposito.setVisible(true);
		PanelCaricamento.removeAll();
		PanelCaricamento.add(deposito);
		PanelCaricamento.repaint();
		PanelCaricamento.revalidate();
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
	
	public void ApriCarrelloPanel(Controller ctrl, JPanel PanelCaricamento) {
		CarrelloPanel carrello = new CarrelloPanel(ctrl);
		carrello.setVisible(true);
		PanelCaricamento.removeAll();
		PanelCaricamento.add(carrello);
		PanelCaricamento.repaint();
		PanelCaricamento.revalidate();
	}
	
	public void ApriCassaPanel(Controller ctrl, JPanel PanelCaricamento) {
		CassaPanel cassa = new CassaPanel(ctrl);
		cassa.setVisible(true);
		PanelCaricamento.removeAll();
		PanelCaricamento.add(cassa);
		PanelCaricamento.repaint();
		PanelCaricamento.revalidate();
	}
	
	//Funzioni per l'apertura delle dialog
	public void ApriAggiungiAlDepositoDialog(Controller ctrl) {
		AggiungiAlDepositoDialog dialog = new AggiungiAlDepositoDialog(ctrl);
		dialog.setVisible(true);
	}
	
	public void ApriAggiungiAlNegozioDialog(Controller ctrl) {
		AggiungiAlNegozioDialog dialog = new AggiungiAlNegozioDialog(ctrl);
		dialog.setVisible(true);
	}
	
	public void ApriAggiungiClientiDialog(Controller ctrl) {
		AggiungiClientiDialog dialog = new AggiungiClientiDialog(ctrl);
		dialog.setVisible(true);
	}
	
	public void ApriAggiungiAlCarrelloDialog(Controller ctrl) {
		AggiungiAlCarrelloDialog dialog = new AggiungiAlCarrelloDialog(ctrl);
		dialog.setVisible(true);
	}
	
	//Stampa all'interno di un file txt che si trova sul desktop, il contenuto della tabella passata come argomento
	public void StampaListaProdotti(JTable table, String luogo) {
		String cartellahome = System.getProperty("user.home");
		String nome = new String();
		if(luogo=="negozio") {
			nome = "Lista_"+ luogo + ".txt";
		}
		else if(luogo=="deposito") {
			nome = "Lista_"+ luogo + ".txt";
		}
		else if(luogo=="clienti") {
			nome = "Lista_"+ luogo + ".txt";
		}
		File file = new File(cartellahome+ "/Desktop", nome+".txt");
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			for(int i = 0; i < table.getRowCount(); i++){
                for(int j = 0; j < table.getColumnCount(); j++){
                    output.write(table.getModel().getValueAt(i, j)+" ");
                }
                output.write("\n- - - - - - - - - - - - - - - - \n");
            }
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
