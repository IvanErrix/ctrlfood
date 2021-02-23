package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;

import DAO.CarrelloDAO;
import DAO.ClienteDAO;
import DAO.Connessione;
import DAO.DepositoDAO;
import DAO.LoginAmministratoreDAO;
import DAO.NegozioDAO;
import DAO.PagamentoDAO;
import Design.AggiungiAlCarrelloDialog;
import Design.AggiungiAlDepositoDialog;
import Design.AggiungiAlNegozioDialog;
import Design.AggiungiClientiDialog;
import Design.AnimazionePanel;
import Design.CarrelloPanel;
import Design.CassaPanel;
import Design.ClientiPanel;
import Design.DepositoPanel;
import Design.FrameAmministratore;
import Design.FrameCliente;
import Design.LoginAmministratoreFrame;
import Design.FrameIniziale;
import Design.ModificaClienteDialog;
import Design.NegozioPanel;
import Design.PagamentoConCartaDialog;
import Design.PagamentoInContantiDialog;
import Objects.CartaFedelta;
import Objects.Cliente;
import Objects.Prodotto;

public class Controller {
	
	private static Connessione connessione;
	private static CarrelloDAO carrellodao;
	private static ClienteDAO clientedao;
	private static DepositoDAO depositodao;
	private static NegozioDAO negoziodao;
	private static PagamentoDAO pagamentodao;
	private static LoginAmministratoreDAO loginamministratoredao;
	
	/* Prima di tutto il programma controlla la connessione. Se la connessione è assente,
	 * il programa non si avvierà.
	 * Se invece la connessione è presente, la funzione main farà partire la prima schermata
	 * del programma, ovvero FramePrincipale
	 */
	public static void main(String[] args) {
		UIManager.put("ComboBox.background", new Color(191, 215, 255));
		UIManager.put("CheckBox.background", new Color(191, 215, 255));
		UIManager.getDefaults().put("controlDkShadow", new Color(0, 41, 82));
		UIManager.put("Table.gridColor", new Color(0,41,82));
		UIManager.put("OptionPane.background", new Color(191, 215, 255));    
		UIManager.put("OptionPane.messageForeground", new Color(0, 41, 82));
		UIManager.put("OptionPane.messageFont",new Font("Cambria", Font.BOLD, 16));
		UIManager.put("OptionPane.buttonFont",new Font("Cambria", Font.BOLD, 16));
		UIManager.put("Panel.background", new Color(191, 215, 255));
		UIManager.put("Button.background", new Color(191, 215, 255));
		UIManager.put("Button.foreground", new Color(0, 41, 82));
//		UIManager.put("ScrollBarUI", "my.package.MyScrollBarUI");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller ctrl= new Controller();
					FrameIniziale login = new FrameIniziale(ctrl);
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Controller() {
		try {
			connessione = new Connessione();
			carrellodao = new CarrelloDAO();
			clientedao = new ClienteDAO();
			depositodao = new DepositoDAO();
			negoziodao = new NegozioDAO();
			pagamentodao = new PagamentoDAO();
			loginamministratoredao = new LoginAmministratoreDAO();
		} catch (Exception e) {
			System.exit(0);
			e.printStackTrace();
		}
	}
	
	public static Connessione getConnessione() {
		return connessione;
	}
	
	//Metodi per l'apertura dei frame
	public void ApriFrameAmministratore(Controller ctrl) {
		FrameAmministratore frame = new FrameAmministratore(ctrl);
		frame.setVisible(true);
	}
	
	public void ApriFrameCliente (Controller ctrl) {
		FrameCliente frame = new FrameCliente(ctrl);
		frame.setVisible(true);
	}

	public void ApriFrameIniziale(Controller ctrl) {
		FrameIniziale login = new FrameIniziale(ctrl);
		login.setVisible(true);
	}
	
	public void ApriFrameLoginAmministratore(Controller ctrl) {
		LoginAmministratoreFrame frame = new LoginAmministratoreFrame(ctrl);
		frame.setVisible(true);
	}
	
	//Metodi per l'apertura dei panel
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
	
	public void ApriAnimazionePanel(Controller ctrl, JPanel PanelCaricamento) {
		AnimazionePanel animazione = new AnimazionePanel(ctrl);
		animazione.setVisible(true);
		PanelCaricamento.removeAll();
		PanelCaricamento.add(animazione);
		PanelCaricamento.repaint();
		PanelCaricamento.revalidate();
	}
	
	//Metodi per l'apertura delle dialog
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
	
	public void ApriModificaClienteDialog(Controller ctrl) {
		ModificaClienteDialog dialog = new ModificaClienteDialog(ctrl);
		dialog.setVisible(true);
	}
	
	public void ApriAggiungiAlCarrelloDialog(Controller ctrl) {
		AggiungiAlCarrelloDialog dialog = new AggiungiAlCarrelloDialog(ctrl);
		dialog.setVisible(true);
	}
	
	public void ApriPagamentoConCartaDialog(Controller ctrl) {
		PagamentoConCartaDialog dialog = new PagamentoConCartaDialog(ctrl);
		dialog.setVisible(true);
	}
	
	public void ApriPagamentoInContantiDialog(Controller ctrl) {
		PagamentoInContantiDialog dialog = new PagamentoInContantiDialog(ctrl);
		dialog.setVisible(true);
	}
	
	//Metodo che consente il movimento delle icone all'interno di AnimazionePanel
	public void MovimentoIcone(JLabel label) {
		int velocita = 2;
    	if (label.getLocation().x>0 && label.getLocation().x<=690 && label.getLocation().y==490) {		//Sposta a sinistra
    		label.setLocation(label.getLocation().x-velocita, label.getLocation().y);
		}
    	else if (label.getLocation().y>0 && label.getLocation().y<=490 && label.getLocation().x==0) {		//Sposta su
    		label.setLocation(label.getLocation().x, label.getLocation().y-velocita);
    	}
    	else if(label.getLocation().x>=0 && label.getLocation().x<690 && label.getLocation().y==0) {		//Sposta a destra
    		label.setLocation(label.getLocation().x+velocita, label.getLocation().y);
    	}
    	else if(label.getLocation().y>=0 && label.getLocation().y<489 && label.getLocation().x==690) {		//Sposta giu
    		label.setLocation(label.getLocation().x, label.getLocation().y+velocita);
    	}
	}
	
	//Metodi per Database
	public String ControllaDatiLogin(String username, String password) {
		return loginamministratoredao.ControllaDatiLogin(username, password);
	}
	
	//Metodi Database Deposito
	public void InserisciProdottoDeposito(String nome, double prezzo, int quantita, long data_scadenza, long data_raccolta) {
		java.sql.Date scadenza = new java.sql.Date(data_scadenza);
		java.sql.Date raccolta = new java.sql.Date(data_raccolta);
		try {
			depositodao.AggiungiOrtofruttaAlDeposito(nome, prezzo, quantita, scadenza, raccolta);
		} catch (NumberFormatException e) {
			System.out.println("errore controller");
			e.printStackTrace();
		}
	}
	
	public void InserisciProdottoConfezionato(String nome, double prezzo, int quantita, long data_scadenza, long data_confezionamento) {
		java.sql.Date scadenza = new java.sql.Date(data_scadenza);
		java.sql.Date confezionamento = new java.sql.Date(data_confezionamento);
		try {
			depositodao.AggiungiConfezionatoAlDeposito(nome, prezzo, quantita, scadenza, confezionamento);
		} catch (NumberFormatException e) {
			System.out.println("errore controller");
			e.printStackTrace();
		}
	}
	
	public void InserisciProdottoLatticino(String nome, double prezzo, int quantita, long data_scadenza, long data_mungitura, long data_produzione) {
		java.sql.Date scadenza = new java.sql.Date(data_scadenza);
		java.sql.Date mungitura = new java.sql.Date(data_mungitura);
		java.sql.Date produzione = new java.sql.Date(data_produzione);
		try {
			depositodao.AggiungiLatticinoAlDeposito(nome, prezzo, quantita, scadenza, mungitura, produzione);
		} catch (NumberFormatException e) {
			System.out.println("errore controller");
			e.printStackTrace();
		}
	}
	
	public void InserisciProdottoFarinaceo(String nome, double prezzo, int quantita, long data_scadenza, long data_produzione) {
		java.sql.Date scadenza = new java.sql.Date(data_scadenza);
		java.sql.Date produzione = new java.sql.Date(data_produzione);
		try {
			depositodao.AggiungiFarinaceoAlDeposito(nome, prezzo, quantita, scadenza, produzione);
		} catch (NumberFormatException e) {
			System.out.println("errore controller");
			e.printStackTrace();
		}
	}
	
	public void InserisciProdottoUova(String nome, double prezzo, int quantita, long data_scadenza, long data_deposizione) {
		java.sql.Date scadenza = new java.sql.Date(data_scadenza);
		java.sql.Date deposizione = new java.sql.Date(data_deposizione);
		try {
			depositodao.AggiungiUovoAlDeposito(nome, prezzo, quantita, scadenza, deposizione);
		} catch (NumberFormatException e) {
			System.out.println("errore controller");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Prodotto> CaricaProdottiDeposito(Controller ctrl) {
		return depositodao.CaricaProdottiDeposito(ctrl);
	}

	public void EliminaProdottoDeposito(int idprodotto) {
		depositodao.EliminaProdottoDeposito(idprodotto);
	}
	
	//Metodi Database Negozio
	public void AggiungiProdottoAlNegozio(int idprodotto,int quantita) {
		negoziodao.AggiungiProdottoAlNegozio(idprodotto, quantita);
	}
	
	public ArrayList<Prodotto> CaricaProdottiNegozio() {
		return negoziodao.CaricaProdottiNegozio();
	}
	
	public void SpostaProdotto(int idprodotto) {
		negoziodao.SpostaProdottoDalNegozio(idprodotto);
	}
	
	public void EliminaProdottoNegozio(int idprodotto) {
		negoziodao.EliminaProdottoNegozio(idprodotto);
	}
	
	//Metodi Database Clienti
	public void AggiungiCliente(String nome, String cognome, String codice_fiscale) {
		clientedao.AggiungiCliente(nome, cognome, codice_fiscale);
	}
	
	public ArrayList<Cliente> CaricaClienti() {
		return clientedao.CaricaClienti();
	}
	
	public ArrayList<CartaFedelta> CaricaPunti() {
		return clientedao.CaricaPuntidFedelta();
	}

	public void EliminaCliente(int idcliente) {
		clientedao.EliminaCliente(idcliente);
	}
	
	public void AggiornaDatiCliente(int idcliente, String nome, String cognome, String codicefiscale) {
		clientedao.AggiornaDatiCliente(idcliente, nome, cognome, codicefiscale);
	}
	
	//Metodi Database Carrello
	public void CreaCarrello() {
		carrellodao.CreaCarrello();
	}
	
	public void EliminaCarrelliNonPagati() {
		carrellodao.EliminaCarrelliNonPagati();
	}
	
	public int RecuperaCarrello() {
		int  id = carrellodao.RecuperaCarrello();
		
		return id;
	}
	
	public void AggiungiProdottoAlCarrello(int idcarrello, int idprodotto, int quantita) {
		carrellodao.AggiungiProdottoAlCarrello(idcarrello, idprodotto, quantita);
	}
	
	public ArrayList<Prodotto> CaricaProdottiCarrello() {
		return carrellodao.RecuperaProdottiCarrello();
	}
	
	public void EliminaProdottoCarrello(int idprodotto) {
		carrellodao.EliminaProdottoCarrello(idprodotto);
	}	
	
	public void AggiornaCarrello(int idcarrello) {
		carrellodao.AggiornaCarrello(idcarrello);
	}
	
	//Metodi Database Pagamento
	public void AggiornaPunti(double puntiortofrutta, double puntilatticini, double puntifarinacei, double puntiuova, double punticonfezionati, double puntitotali, int cartafedelta ) {
		pagamentodao.AggiornaPunti(puntiortofrutta, puntilatticini, puntifarinacei, puntiuova, punticonfezionati, puntitotali, cartafedelta);
	}
	
	public void AggiungiPagamento(int chiavecarrello, int chiavecartafedelta) {
		pagamentodao.AggiungiPagamento(chiavecarrello, chiavecartafedelta);
	}
	
	//Metodo per arrotondare i double a due cifre decimali
	public double Arrotonda(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	//Metodo che stampa all'interno di un file txt che si trova sul desktop, il contenuto della tabella passata come argomento
	public void StampaListaProdotti(JTable table, String tipo) {
			String cartellahome = System.getProperty("user.home");
			String nome = new String();
			if(tipo=="negozio") {
				nome = "Lista_"+ tipo + ".txt";
			}
			else if(tipo=="deposito") {
				nome = "Lista_"+ tipo + ".txt";
			}
			else if(tipo=="clienti") {
				nome = "Lista_"+ tipo + ".txt";
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
				JOptionPane.showMessageDialog(null, "FILE STAMPATO", "", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
