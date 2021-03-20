package Design;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import ExternalClasses.ContentPane;
import ExternalClasses.RoundedCornerBorder;
import Main.Controller;
import Objects.Prodotto;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class PagamentoConCartaDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private ArrayList<Prodotto> prodotti;
	private ContentPane contentPane;
	private JButton ButtonVediPassword;
	private JButton ButtonPaga;
	private JButton ButtonAnnulla;
	private JLabel LabelNumeroCarta;
	private JLabel LabelPin;
	private JLabel LabelScadenza;
	private JLabel LabelNumeroCartaFedelta;
	private JLabel LabelNumCartaSuCarta;
	private JLabel LabelScadenzaSuCarta;
	private MaskFormatter mf;
	private JFormattedTextField textFieldNumeroCarta;
	private JTextField textFieldNumeroCartaFedelta;
	private JPasswordField passwordFieldPin;
	private JDateChooser dateChooserScadenzaCarta;
	private JTextFieldDateEditor dateChooserEditorScadenzaCarta;
	private JLabel LabelSfondo;
	private boolean visible=false;

	public PagamentoConCartaDialog(Controller ctrl) {
		
		Date data_corrente = new Date();
		
		setAlwaysOnTop(true);
		getContentPane().setBackground(new Color(0, 67, 137));
		setUndecorated(true);
		setSize(697, 566);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		
		
		/*CONTENTPANE*/
		contentPane = new ContentPane();
		setContentPane(contentPane);
		getContentPane().isOpaque();
		setBackground(new Color(0, 67, 137, 0));
		contentPane.setLayout(null);
		
		/*BUTTON VEDI PASSWORD*/
		ButtonVediPassword = new JButton("");
		ButtonVediPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(visible==false) {
					visible=true;
					ButtonVediPassword.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonUnviewPassword.png")));
					passwordFieldPin.setEchoChar((char) 0);
					passwordFieldPin.setFont(new Font("Cambria", Font.BOLD, 15));
				}
				else if(visible==true) {
					visible=false;
					ButtonVediPassword.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonViewPassword.png")));
					passwordFieldPin.setEchoChar('●');
					passwordFieldPin.setFont(new Font("Impact", Font.PLAIN, 15));
				}
			}
		});
		getContentPane().setLayout(null);
		ButtonVediPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonVediPassword.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonViewPassword.png")));
		ButtonVediPassword.setBorder(null);
		ButtonVediPassword.setBounds(495, 250, 32, 32);
		ButtonVediPassword.setContentAreaFilled(false);
		getContentPane().add(ButtonVediPassword);
		
		/*LABEL NUMERO CARTA*/
		LabelNumeroCarta = new JLabel("N° Carta");
		LabelNumeroCarta.setBounds(101, 206, 76, 20);
		LabelNumeroCarta.setForeground(new Color(0,41,82));
		LabelNumeroCarta.setFont(new Font("Cambria", Font.BOLD, 18));
		getContentPane().add(LabelNumeroCarta);
		
		/*LABEL PIN*/
		LabelPin = new JLabel("Pin");
		LabelPin.setBounds(101, 262, 70, 20);
		LabelPin.setForeground(new Color(0,41,82));
		LabelPin.setFont(new Font("Cambria", Font.BOLD, 18));
		getContentPane().add(LabelPin);

		/*LABEL SCADNENZA*/
		LabelScadenza = new JLabel("Scadenza");
		LabelScadenza.setBounds(101, 318, 97, 20);
		LabelScadenza.setForeground(new Color(0,41,82));
		LabelScadenza.setFont(new Font("Cambria", Font.BOLD, 18));
		getContentPane().add(LabelScadenza);
		
		/*LABEL NUMERO CARTA FEDELTA*/
		LabelNumeroCartaFedelta = new JLabel("N° Carta Fedeltà");
		LabelNumeroCartaFedelta.setBounds(103, 374, 145, 20);
		LabelNumeroCartaFedelta.setForeground(new Color(0,41,82));
		LabelNumeroCartaFedelta.setFont(new Font("Cambria", Font.BOLD, 18));
		getContentPane().add(LabelNumeroCartaFedelta);	
		
		/*LABEL NUMERO CARTA SULLA CARTA*/
		LabelNumCartaSuCarta = new JLabel("");
		LabelNumCartaSuCarta.setFont(new Font("Cambria", Font.BOLD, 15));
		LabelNumCartaSuCarta.setForeground(new Color(191, 215, 255));
		LabelNumCartaSuCarta.setBounds(221, 89, 165, 20);
		contentPane.add(LabelNumCartaSuCarta);
		
		/*LABEL SCADENZA CARTA SULLA CARTA*/
		LabelScadenzaSuCarta = new JLabel("");
		LabelScadenzaSuCarta.setFont(new Font("Cambria", Font.BOLD, 15));
		LabelScadenzaSuCarta.setForeground(new Color(191, 215, 255));
		LabelScadenzaSuCarta.setBounds(221, 128, 102, 14);
		contentPane.add(LabelScadenzaSuCarta);

		/*FORMATTED TEXTFIELD NUMERO CARTA*/
		mf = null;
		try {
			mf = new MaskFormatter("####-####-####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		textFieldNumeroCarta = new JFormattedTextField(mf) ;
		textFieldNumeroCarta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					LabelNumCartaSuCarta.setText(textFieldNumeroCarta.getText());
				} catch (Exception e2) {
					LabelNumCartaSuCarta.setText("");
				}
			}
		});
		textFieldNumeroCarta.setBounds(258, 194, 269, 30);
		textFieldNumeroCarta.setBorder(new RoundedCornerBorder());
		textFieldNumeroCarta.setFont(new Font("Cambria", Font.BOLD, 11));
		textFieldNumeroCarta.setForeground(new Color(0,41,82));
		textFieldNumeroCarta.setBackground(new Color(191,215,255));
		textFieldNumeroCarta.setSelectedTextColor(new Color (191,215,255));
		textFieldNumeroCarta.setSelectionColor(new Color (0,41,82));
		textFieldNumeroCarta.setColumns(10);
		textFieldNumeroCarta.setCaretColor(new Color(0, 41, 82));
		getContentPane().add(textFieldNumeroCarta);
		
		/*PASSWORDFIELD PIN*/
		passwordFieldPin = new JPasswordField() ;
		passwordFieldPin.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyTyped(KeyEvent e) {
				if(passwordFieldPin.getText().length()<5) {
					char c=e.getKeyChar();
					if(!(Character.isDigit(c) ||  (c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
				}
				else {
					char c=e.getKeyChar();
					if(!((c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
				}

			}
		});
		passwordFieldPin.setBackground(new Color(191,215,255));
		passwordFieldPin.setSelectedTextColor(new Color (191,215,255));
		passwordFieldPin.setSelectionColor(new Color (0,41,82));
		passwordFieldPin.setBorder(new RoundedCornerBorder());
		passwordFieldPin.setForeground(new Color(0,41,82));
		passwordFieldPin.setFont(new Font("Cambria", Font.BOLD, 15));
		passwordFieldPin.setBounds(258, 250, 234, 30);
		passwordFieldPin.setCaretColor(new Color(0, 41, 82));
		getContentPane().add(passwordFieldPin);
		
		/*DATACHOOSER SCADENZA CARTA*/
		dateChooserScadenzaCarta = new JDateChooser();
		dateChooserScadenzaCarta.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					LabelScadenzaSuCarta.setText(dateChooserEditorScadenzaCarta.getText());
				} catch (Exception e2) {
					LabelScadenzaSuCarta.setText("");
				}
			}
		});
		dateChooserScadenzaCarta.getCalendarButton().setBorderPainted(false);
		dateChooserScadenzaCarta.getCalendarButton().setContentAreaFilled(false);
		dateChooserScadenzaCarta.getCalendarButton().setBackground(new Color(191,215,255));
		dateChooserScadenzaCarta.getCalendarButton().setOpaque(false);
		dateChooserScadenzaCarta.getCalendarButton().setBorder(null);
		dateChooserScadenzaCarta.getCalendarButton().setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/calendar.png")));
		dateChooserEditorScadenzaCarta = ((JTextFieldDateEditor)dateChooserScadenzaCarta.getDateEditor());
		dateChooserEditorScadenzaCarta.setBackground(new Color(191, 215, 255));
		dateChooserEditorScadenzaCarta.setForeground(new Color(0, 41, 82));
		dateChooserEditorScadenzaCarta.setSelectedTextColor(new Color (191,215,255));
		dateChooserEditorScadenzaCarta.setSelectionColor(new Color (0,41,82));
		dateChooserEditorScadenzaCarta.setBorder(new RoundedCornerBorder());
		dateChooserEditorScadenzaCarta.setFont(new Font("Cambria", Font.BOLD, 12));
		dateChooserScadenzaCarta.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserScadenzaCarta.setMinSelectableDate(data_corrente);
		dateChooserScadenzaCarta.setDateFormatString("dd-MM-yyyy");
		dateChooserScadenzaCarta.setBounds(258, 306, 292, 30);
		getContentPane().add(dateChooserScadenzaCarta);

		/*BUTTON PAGA*/
		ButtonPaga = new JButton("");
		ButtonPaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlloPagamaneto(ctrl);
				ctrl.ChiudiFrameCliente();
				ctrl.ApriFrameIniziale(ctrl);
			}
		});
		ButtonPaga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonPaga.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonPagaAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonPaga.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonPaga.png")));
			}
		});
		ButtonPaga.setPressedIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonPaga.png")));
		ButtonPaga.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonPaga.setOpaque(false);
		ButtonPaga.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonPaga.png")));
		ButtonPaga.setBorder(null);
		ButtonPaga.setBounds(496, 475, 110, 24);
		ButtonPaga.setContentAreaFilled(false);
		getContentPane().add(ButtonPaga);

		/*BUTTON ANNULLA*/
		ButtonAnnulla = new JButton("");
		ButtonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ButtonAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAnnulla.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonAnnullaAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAnnulla.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
			}
		});
		ButtonAnnulla.setPressedIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.setOpaque(false);
		ButtonAnnulla.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAnnulla.setBorder(null);
		ButtonAnnulla.setContentAreaFilled(false);
		ButtonAnnulla.setBounds(88, 475, 110, 24);
		getContentPane().add(ButtonAnnulla);
		
		/*TEXTFIELD NUMERO CARTA FEDELTA*/
		textFieldNumeroCartaFedelta = new JTextField() ;
		textFieldNumeroCartaFedelta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textFieldNumeroCartaFedelta.getText().length()<4) {
					char c=e.getKeyChar();
					if(!(Character.isDigit(c) ||  (c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
				}
				else {
					char c=e.getKeyChar();
					if(!((c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
				}

			}
		});
		textFieldNumeroCartaFedelta.setForeground(new Color(0,41,82));
		textFieldNumeroCartaFedelta.setBorder(new RoundedCornerBorder());
		textFieldNumeroCartaFedelta.setFont(new Font("Cambria", Font.BOLD, 15));
		textFieldNumeroCartaFedelta.setColumns(10);
		textFieldNumeroCartaFedelta.setCaretColor(new Color(0, 41, 82));
		textFieldNumeroCartaFedelta.setBackground(new Color(191,215,255));
		textFieldNumeroCartaFedelta.setSelectedTextColor(new Color (191,215,255));
		textFieldNumeroCartaFedelta.setSelectionColor(new Color (0,41,82));
		textFieldNumeroCartaFedelta.setBounds(258, 364, 269, 30);
		getContentPane().add(textFieldNumeroCartaFedelta);
		
		/*LABEL SFONDO*/
		LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/SfondoPagaConCarta.png")));
		LabelSfondo.setBounds(-9, -9, 710, 580);
		getContentPane().add(LabelSfondo);
		
	}
	
	@SuppressWarnings("deprecation")
	private void ControlloPagamaneto(Controller ctrl) {
		if(textFieldNumeroCarta.getText().length()==0 || passwordFieldPin.getText().length()==0 || dateChooserEditorScadenzaCarta.getText().length()==0 ) {
			setAlwaysOnTop(false);
			JOptionPane.showMessageDialog(null, "COMPLETARE TUTTI I CAMPI", "", JOptionPane.WARNING_MESSAGE);
			setAlwaysOnTop(true);
		}
		else {
			if (passwordFieldPin.getText().length()<5 || textFieldNumeroCarta.getText().replace("-", "").length()==0) {
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "IL PIN DEVE CONTENERE 5 NUMERI E IL NUMERO DELLA CARTA NE DEVE CONTENERE 16", "", JOptionPane.ERROR_MESSAGE);
				setAlwaysOnTop(true);
			}
			else {
				setAlwaysOnTop(false);
				try {
					ctrl.AggiungiPagamento(ctrl.RecuperaCarrello(), Integer.parseInt(textFieldNumeroCartaFedelta.getText()));
					CalcoloPunti(ctrl);
					ctrl.AggiornaCarrello(ctrl.RecuperaCarrello());
				} catch (NumberFormatException e) {
					ctrl.AggiungiPagamentoSenzaCarta(ctrl.RecuperaCarrello());
					CalcoloPunti(ctrl);
					ctrl.AggiornaCarrello(ctrl.RecuperaCarrello());
				}
				JOptionPane.showMessageDialog(null, "PAGAMENTO AVVENUTO CON SUCCESSO", "", JOptionPane.INFORMATION_MESSAGE);
				setAlwaysOnTop(true);
				dispose();
			} 
		}
	}
	
	private void CalcoloPunti(Controller ctrl) {
		prodotti=ctrl.CaricaProdottiCarrello();
		Double puntiortofrutta = 0.0;
		Double puntilatticini = 0.0;
		Double puntifarinacei = 0.0;
		Double puntiuova = 0.0;
		Double punticonfezionati = 0.0;
		for(int i=0; i<prodotti.size(); i++) {
			if(prodotti.get(i).getTipologia().equals("ORTOFRUTTA")) {
				puntiortofrutta=puntiortofrutta+(prodotti.get(i).getPrezzo()*prodotti.get(i).getQuantita())*10/100;
				System.out.println(puntiortofrutta);
			}
			else if(prodotti.get(i).getTipologia().equals("LATTICINO")){
				puntilatticini=puntilatticini+(prodotti.get(i).getPrezzo()*prodotti.get(i).getQuantita())*10/100;
			}
			else if(prodotti.get(i).getTipologia().equals("FARINACEO")) {
				puntifarinacei=puntifarinacei+(prodotti.get(i).getPrezzo()*prodotti.get(i).getQuantita())*10/100;
			}
			else if(prodotti.get(i).getTipologia().equals("UOVO")){
				puntiuova=puntiuova+(prodotti.get(i).getPrezzo()*prodotti.get(i).getQuantita())*10/100;
			}
			else if(prodotti.get(i).getTipologia().equals("CONFEZIONATO")) {
				punticonfezionati=punticonfezionati+(prodotti.get(i).getPrezzo()*prodotti.get(i).getQuantita())*10/100;
			}
		}
		try {
			ctrl.AggiornaPunti(ctrl.Arrotonda(puntiortofrutta, 2), ctrl.Arrotonda(puntilatticini, 2), ctrl.Arrotonda(puntifarinacei, 2), ctrl.Arrotonda(puntiuova, 2), 
					ctrl.Arrotonda(punticonfezionati, 2), Integer.parseInt(textFieldNumeroCartaFedelta.getText()));
		} catch (NumberFormatException e) {
		}
	}
}
