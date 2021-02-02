package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import DAO.CarrelloDAO;
import DAO.ClienteDAO;
import DAO.Connessione;
import DAO.DepositoDAO;
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
import Design.FramePrincipale;
import Design.LoadingPanel;
import Design.LoginAmministratoreDialog;
import Design.LoginDialog;
import Design.NegozioPanel;
import Design.PagamentoConCartaDialog;
import Design.SpostaDalNegozioDialog;

public class Controller {
	
	private static Connessione connessione;
	private static CarrelloDAO carrellodao;
	private static ClienteDAO clientedao;
	private static DepositoDAO depositodao;
	private static NegozioDAO negoziodao;
	
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
		UIManager.put("OptionPane.messageFont",new Font("Impact", Font.PLAIN, 16));
		UIManager.put("OptionPane.buttonFont",new Font("Impact", Font.PLAIN, 16));
		UIManager.put("Panel.background", new Color(191, 215, 255));
		UIManager.put("Button.background", new Color(191, 215, 255));
		UIManager.put("Button.foreground", new Color(0, 41, 82));
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller ctrl= new Controller();
					System.out.println("Connessione avvenuta");
					LoginDialog login = new LoginDialog(ctrl);
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
		} catch (Exception e) {
			System.exit(0);
			e.printStackTrace();
		}
	}
	
	public static Connessione getConnessione() {
		return connessione;
	}
	
	public void ApriFramePrincipale(Controller ctrl) {
		FramePrincipale frame = new FramePrincipale(ctrl);
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
	
	public void ApriLoadingPanel(Controller ctrl, JPanel PanelCaricamento) {
		LoadingPanel loading = new LoadingPanel(ctrl);
		PanelCaricamento.add(loading);
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
	
	//Consente di cambiare le icone delle label e dei button nel FramePrincipale
	public void CambiaIconaAiButton(String nome, JLabel LabelDeposito, JLabel LabelNegozio, JLabel LabelClienti, JLabel LabelCarrello,
			JLabel LabelCassa, JButton ButtonDeposito, JButton ButtonNegozio, JButton ButtonClienti, JButton ButtonCarrello, JButton ButtonCassa) {
		if(nome.equals("deposito")) {
			LabelDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IconHouse3D.png")));
			LabelNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShopWhite_32.png")));
			LabelClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoUserWhite_32.png")));
			LabelCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShoppingCartWhite_32.png")));
			LabelCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CheckoutWhite_32.png")));
			ButtonDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ButtonDeposito.png")));
			ButtonNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/NegozioWhite.png")));
			ButtonClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ClientiWhite.png")));
			ButtonCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CarrelloWhite.png")));
			ButtonCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CassaWhite.png")));
		}
		else if(nome.equals("negozio")) {
			LabelDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoHomeWhite_32.png")));
			LabelNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IconShop3D.png")));
			LabelClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoUserWhite_32.png")));
			LabelCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShoppingCartWhite_32.png")));
			LabelCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CheckoutWhite_32.png")));
			ButtonDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/DepositoWhite.png")));
			ButtonNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ButtonNegozio.png")));
			ButtonClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ClientiWhite.png")));
			ButtonCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CarrelloWhite.png")));
			ButtonCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CassaWhite.png")));
		}
		else if(nome.equals("clienti")) {
			LabelDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoHomeWhite_32.png")));
			LabelNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShopWhite_32.png")));
			LabelClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IconUser3D.png")));
			LabelCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShoppingCartWhite_32.png")));
			LabelCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CheckoutWhite_32.png")));
			ButtonDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/DepositoWhite.png")));
			ButtonNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/NegozioWhite.png")));
			ButtonClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ButtonClienti.png")));
			ButtonCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CarrelloWhite.png")));
			ButtonCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CassaWhite.png")));
		}
		else if (nome.equals("carrello")) {
			LabelDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoHomeWhite_32.png")));
			LabelNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShopWhite_32.png")));
			LabelClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoUserWhite_32.png")));
			LabelCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IconShoppingCart3D.png")));
			LabelCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CheckoutWhite_32.png")));
			ButtonDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/DepositoWhite.png")));
			ButtonNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/NegozioWhite.png")));
			ButtonClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ClientiWhite.png")));
			ButtonCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ButtonCarrello.png")));
			ButtonCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CassaWhite.png")));	
		}
		else if(nome.equals("cassa")) {
			LabelDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoHomeWhite_32.png")));
			LabelNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShopWhite_32.png")));
			LabelClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoUserWhite_32.png")));
			LabelCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShoppingCartWhite_32.png")));
			LabelCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IconCheckout3D.png")));
			ButtonDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/DepositoWhite.png")));
			ButtonNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/NegozioWhite.png")));
			ButtonClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ClientiWhite.png")));
			ButtonCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CarrelloWhite.png")));
			ButtonCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ButtonCassa.png")));
		}
		else if(nome.equals("homepage")) {
			LabelDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoHomeWhite_32.png")));
			LabelNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShopWhite_32.png")));
			LabelClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoUserWhite_32.png")));
			LabelCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShoppingCartWhite_32.png")));
			LabelCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CheckoutWhite_32.png")));
			ButtonDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/DepositoWhite.png")));
			ButtonNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/NegozioWhite.png")));
			ButtonClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ClientiWhite.png")));
			ButtonCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CarrelloWhite.png")));
			ButtonCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CassaWhite.png")));
		}
	}
	
	public void RimuoviTutto(JTextField textFieldNome, JTextField textFieldPrezzo, JSpinner spinnerQuantita, JTextField textFieldFoto, JDateChooser dateChooserScadenza, 
			JDateChooser dateChooserRaccolta, JDateChooser dateChooserProduzione, JDateChooser dateChooserMungitura, JDateChooser dateChooserConfezionamento, JDateChooser dataChooserDeposizione) {
		textFieldNome.setText("");
		textFieldPrezzo.setText("");
		spinnerQuantita.setValue(1);
		textFieldFoto.setText("");
		dateChooserScadenza.setDate(null);
		dateChooserRaccolta.setDate(null);
		dateChooserProduzione.setDate(null);
		dateChooserMungitura.setDate(null);
		dateChooserConfezionamento.setDate(null);
		dataChooserDeposizione.setDate(null);
	}
	
	public void RimuoviTutto(JTextField textFieldNome, JTextField textFieldCognome, JTextField textFieldCodiceFiscale, JCheckBox CheckBoxCartaFedelta) {
		textFieldNome.setText("");
		textFieldCognome.setText("");
		textFieldCodiceFiscale.setText("");
		CheckBoxCartaFedelta.setSelected(false);
	}
	
	//Funzioni per Database
	public void InserisciProdottoDeposito(String nome, JTextField prezzo, JSpinner quantita, JTextFieldDateEditor data_scadenza, JTextFieldDateEditor data_raccolta) {
		java.sql.Date scadenza = new java.sql.Date(data_raccolta.getDate().getTime());
		java.sql.Date raccolta = new java.sql.Date(data_raccolta.getDate().getTime());
		try {
			depositodao.AggiungiOrtofruttaAlDeposito(nome, Double.parseDouble(prezzo.getText()), Integer.parseInt(quantita.getValue().toString()), scadenza, raccolta);
		} catch (NumberFormatException | SQLException e) {
			System.out.println("errore controller");
			e.printStackTrace();
		}
	}
}
