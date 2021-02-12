package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import DAO.CarrelloDAO;
import DAO.ClienteDAO;
import DAO.Connessione;
import DAO.DepositoDAO;
import DAO.LoginAmministratoreDAO;
import DAO.NegozioDAO;
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
import Design.LoadingDialog;
import Design.LoginAmministratoreDialog;
import Design.LoginFrame;
import Design.ModificaClienteDialog;
import Design.NegozioPanel;
import Design.PagamentoConCartaDialog;
import Design.PagamentoInContantiDialog;
import Design.SpostaDalNegozioDialog;
import Objects.CartaFedelta;
import Objects.Cliente;
import Objects.Prodotto;

public class Controller {
	
	private static Connessione connessione;
	private static CarrelloDAO carrellodao;
	private static ClienteDAO clientedao;
	private static DepositoDAO depositodao;
	private static NegozioDAO negoziodao;
	private static LoginAmministratoreDAO loginamministratoredao;
	
	/*Prima di tutto il programma controlla la connessione. See la connessione è assente
	 *Se invece la connessione è presente, la funzione main fa partire la prima schermata
	 *del programma, ovvero FramePrincipale
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
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller ctrl= new Controller();
//					System.out.println("Connessione avvenuta");
					LoginFrame login = new LoginFrame(ctrl);
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
			loginamministratoredao = new LoginAmministratoreDAO();
		} catch (Exception e) {
			System.exit(0);
			e.printStackTrace();
		}
	}
	
	public static Connessione getConnessione() {
		return connessione;
	}
	
	public void ApriFrameAmministratore(Controller ctrl) {
		FrameAmministratore frame = new FrameAmministratore(ctrl);
		frame.setVisible(true);
	}
	
	public void ApriFrameCliente (Controller ctrl) {
		FrameCliente frame = new FrameCliente(ctrl);
		frame.setVisible(true);
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
	
	public void ApriAnimazionePanel(Controller ctrl, JPanel PanelCaricamento) {
		AnimazionePanel animazione = new AnimazionePanel(ctrl);
		animazione.setVisible(true);
		PanelCaricamento.removeAll();
		PanelCaricamento.add(animazione);
		PanelCaricamento.repaint();
		PanelCaricamento.revalidate();
	}
	
	//Funzioni per l'apertura delle dialog
	
	public void ApriLoginAmministratoreDialog(Controller ctrl) {
		LoginAmministratoreDialog dialog = new LoginAmministratoreDialog(ctrl);
		dialog.setVisible(true);
	}
	
	public void ApriLoginFrame(Controller ctrl) {
		LoginFrame login = new LoginFrame(ctrl);
		login.setVisible(true);
	}
	
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
	
	public void ApriPagamentoConCartaDialog(Controller ctrl) {
		PagamentoConCartaDialog dialog = new PagamentoConCartaDialog(ctrl);
		dialog.setVisible(true);
	}
	
	public void ApriSpostaDalNegozioDialog() {
		SpostaDalNegozioDialog dialog = new SpostaDalNegozioDialog();
		dialog.setVisible(true);
	}
	
	public void ApriModificaClienteDialog(Controller ctrl) {
		ModificaClienteDialog dialog = new ModificaClienteDialog(ctrl);
		dialog.setVisible(true);
	}
	
	public void ApriPagamentoInContantiDialog(Controller ctrl) {
		PagamentoInContantiDialog dialog = new PagamentoInContantiDialog(ctrl);
		dialog.setVisible(true);
	}
	
	public JDialog ApriLoadingDialog(Controller ctrl) {
		LoadingDialog dialog = new LoadingDialog(ctrl);
		return dialog;
	}
	
	public void ChiudiLoadingDialog(Controller ctrl, JDialog dialog) {
		dialog.dispose();
	}
	
	//Stampa all'interno di un file txt che si trova sul desktop, il contenuto della tabella passata come argomento
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
	
	//Carica il file con estensione JPG dal pc tramite il filechooser
	public void CaricaFileJPGDaPC(JTextField textFieldFoto) {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Seleziona un file");
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter =new FileNameExtensionFilter("JPG", "jpg");
		jfc.addChoosableFileFilter(filter);
		int returnValue = jfc.showOpenDialog(null);
		if(returnValue == JFileChooser.APPROVE_OPTION) {
			textFieldFoto.setText(jfc.getSelectedFile().getPath());
		}
	}
	
	//Consente il movimento delle icone all'interno di AnimazionePanel
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
	
	//Funzioni per Database
	public String ControllaDatiLogin(String username, String password) {
		return loginamministratoredao.ControllaDatiLogin(username, password);
	}
	
	//Funzioni Database Deposito
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
	
	//Funzioni Database Negozio
	public void AggiungiProdottoAlNegozio(int idprodotto,int quantita) {
		negoziodao.AggiungiProdottoAlNegozio(idprodotto, quantita);
	}
	
	public ArrayList<Prodotto> CaricaProdottiNegozio() {
		return negoziodao.CaricaProdottiNegozio();
	}
	
	public void SpostaProdotto(int idprodotto) {
		negoziodao.SpostaProdottoDalNegozio(idprodotto);
	}
	
	//Funzioni Database Clienti
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
	
}
