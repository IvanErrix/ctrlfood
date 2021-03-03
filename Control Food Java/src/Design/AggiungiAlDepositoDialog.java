package Design;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import Main.Controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.util.Date;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import ExternalClasses.ContentPane;
import ExternalClasses.RoundedCornerBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class AggiungiAlDepositoDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private ContentPane contentPane;
	private JLabel LabelNome;
	private JLabel LabelPrezzo;
	private JLabel LabelDataScadenza;
	private JLabel LabelQuantita;
	private JLabel LabelDataRaccolta;
	private JLabel LabelDataProduzione;
	private JLabel LabelDataConfezionamento;
	private JLabel LabelDataMungitura;
	private JLabel LabelDataDeposizione;
	private String nome = "ORTOFRUTTA";
	private JTextField textFieldNome;
	private JTextField textFieldPrezzo;
	private SpinnerNumberModel spinnermodel;
	private JSpinner spinnerQuantita;
	private JDateChooser dateChooserScadenza;
	private JTextFieldDateEditor dateChooserEditorScadenza;
	private JDateChooser dateChooserRaccolta;
	private JTextFieldDateEditor dateChooserEditorRaccolta;
	private JDateChooser dateChooserProduzione;
	private JTextFieldDateEditor dateChooserEditorProduzione;
	private JDateChooser dateChooserMungitura;
	private JTextFieldDateEditor dateChooserEditorMungitura;
	private JDateChooser dateChooserConfezionamento;
	private JTextFieldDateEditor dateChooserEditorConfezionamento;
	private JDateChooser dateChooserDeposizione;
	private JTextFieldDateEditor dateChooserEditorDeposizione;
	private JButton ButtonOrtofrutta;
	private JButton ButtonFarinacei;
	private JButton ButtonConfezionati;
	private JButton ButtonLatticini;
	private JButton ButtonUova;
	private JButton ButtonAggiugni;
	private JButton ButtonRimuoviTutto;
	private JButton ButtonAnnulla;
	private JLabel LabelSfondo;

	public AggiungiAlDepositoDialog(Controller ctrl) {
		
		Date data_corrente = new Date();
		setAlwaysOnTop(true);
		setUndecorated(true);
		setSize(710, 518);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setLayout(null);
		
		/*CONTENTPANE*/
		contentPane = new ContentPane();
		setContentPane(contentPane);
		getContentPane().isOpaque();
		setBackground(new Color(0, 67, 137, 0));
		contentPane.setLayout(null);
		
		/*LABEL NOME*/
		LabelNome = new JLabel("Nome");
		LabelNome.setForeground(new Color(0, 41, 82));
		LabelNome.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelNome.setBounds(106, 154, 46, 14);
		contentPane.add(LabelNome);
		
		/*LABEL PREZZO*/
		LabelPrezzo = new JLabel("Prezzo");
		LabelPrezzo.setForeground(new Color(0, 41, 82));
		LabelPrezzo.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelPrezzo.setBounds(106, 201, 50, 14);
		contentPane.add(LabelPrezzo);
		
		/*LABEL DATA SCADENZA*/
		LabelDataScadenza = new JLabel("Data Scadenza");
		LabelDataScadenza.setForeground(new Color(0, 41, 82));
		LabelDataScadenza.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataScadenza.setBounds(106, 245, 118, 14);
		contentPane.add(LabelDataScadenza);
		
		/*LABEL QUANTITA*/
		LabelQuantita = new JLabel("Quantit\u00E0");
		LabelQuantita.setForeground(new Color(0, 41, 82));
		LabelQuantita.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelQuantita.setBounds(106, 295, 68, 14);
		contentPane.add(LabelQuantita);
		
		/*LABEL RACCOLTA*/
		LabelDataRaccolta = new JLabel("Data Raccolta");
		LabelDataRaccolta.setVisible(true);
		LabelDataRaccolta.setForeground(new Color(0, 41, 82));
		LabelDataRaccolta.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataRaccolta.setBounds(106, 331, 118, 14);
		contentPane.add(LabelDataRaccolta);
		
		/*LABEL PRODUZIONE*/
		LabelDataProduzione = new JLabel("Data Produzione");
		LabelDataProduzione.setVisible(false);
		LabelDataProduzione.setForeground(new Color(0, 41, 82));
		LabelDataProduzione.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataProduzione.setBounds(106, 331, 141, 14);
		contentPane.add(LabelDataProduzione);
		
		/*LABEL MUNGITURA*/
		LabelDataMungitura = new JLabel("Data Mungitura");
		LabelDataMungitura.setVisible(false);
		LabelDataMungitura.setForeground(new Color(0, 41, 82));
		LabelDataMungitura.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataMungitura.setBounds(106, 379, 118, 14);
		contentPane.add(LabelDataMungitura);
		
		/*LABEL CONFEZIONAMENTO*/
		LabelDataConfezionamento = new JLabel("Data Confezionamento");
		LabelDataConfezionamento.setVisible(false);
		LabelDataConfezionamento.setForeground(new Color(0, 41, 82));
		LabelDataConfezionamento.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataConfezionamento.setBounds(106, 331, 180, 14);
		contentPane.add(LabelDataConfezionamento);
		
		/*LABEL DEPOSIZIONE*/
		LabelDataDeposizione = new JLabel ("Data Deposizione");
		LabelDataDeposizione.setVisible(false);
		LabelDataDeposizione.setForeground(new Color(0, 41, 82));
		LabelDataDeposizione.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataDeposizione.setBounds(106, 331, 161, 14);
		contentPane.add(LabelDataDeposizione);
		
		/*TEXTFIELD NOME*/
		textFieldNome = new JTextField(20);
 		textFieldNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textFieldNome.setText(textFieldNome.getText().toUpperCase());
			}
		});
		textFieldNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
			    if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE || c==KeyEvent.VK_SPACE ))
			        e.consume();
			}
		});
		textFieldNome.setFont(new Font("Cambria", Font.BOLD, 16));
		textFieldNome.setBorder(new RoundedCornerBorder());
		textFieldNome.setOpaque(false);
		textFieldNome.setBackground(new Color(191,215,255));
		textFieldNome.setForeground(new Color(0, 41, 82));
		textFieldNome.setSelectedTextColor(new Color (191,215,255));
		textFieldNome.setSelectionColor(new Color (0,41,82));
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(340, 143, 275, 25);
		textFieldNome.setCaretColor(new Color(0, 41, 82));
		contentPane.add(textFieldNome);
		
		/*TEXTFIELD PREZZO*/
		textFieldPrezzo = new JTextField(20) ;
		textFieldPrezzo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					if(ctrl.Arrotonda(Double.parseDouble(textFieldPrezzo.getText()), 2)==0.00) {
						textFieldPrezzo.setText("");
					}
				} catch (NumberFormatException e1) {
				}
			}
		});
		textFieldPrezzo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
			    if (textFieldPrezzo.getText().length()<7) {
					if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE
							|| c == KeyEvent.VK_PERIOD))
						e.consume();
				}
			    else {
					if(!((c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
			    }
			}
		});
		textFieldPrezzo.setFont(new Font("Cambria", Font.BOLD, 16));
		textFieldPrezzo.setBorder(new RoundedCornerBorder());
		textFieldPrezzo.setOpaque(false);
		textFieldPrezzo.setBackground(new Color(191,215,255));
		textFieldPrezzo.setForeground(new Color(0, 41, 82));
		textFieldPrezzo.setSelectedTextColor(new Color (191,215,255));
		textFieldPrezzo.setSelectionColor(new Color (0,41,82));
		textFieldPrezzo.setColumns(10);
		textFieldPrezzo.setBounds(340, 189, 275, 25);
		textFieldPrezzo.setCaretColor(new Color(0, 41, 82));
		contentPane.add(textFieldPrezzo);
		
		/*JSPINNER QUANTITA*/
		spinnermodel = new SpinnerNumberModel(1, 1, 50, 1);
		spinnerQuantita = new JSpinner(spinnermodel);
		spinnerQuantita.setOpaque(false);
		spinnerQuantita.setBorder(new RoundedCornerBorder());
		spinnerQuantita.getComponent(0).setBackground(new Color(191,215,255));
		spinnerQuantita.getComponent(1).setBackground(new Color(191,215,255));
		spinnerQuantita.getEditor().getComponent(0).setBackground(new Color(191,215,255));
		spinnerQuantita.getEditor().getComponent(0).setForeground(new Color(0, 41, 82));
		spinnerQuantita.setRequestFocusEnabled(false);
		spinnerQuantita.setFont(new Font("Cambria", Font.BOLD, 16));
		spinnerQuantita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		spinnerQuantita.setBounds(340, 284, 46, 25);
		contentPane.add(spinnerQuantita);
		
		/*JDATECHOOSER SCADENZA*/
		dateChooserScadenza = new JDateChooser();
		dateChooserScadenza.getCalendarButton().setBorderPainted(false);
		dateChooserScadenza.getCalendarButton().setContentAreaFilled(false);
		dateChooserScadenza.getCalendarButton().setBackground(new Color(191,215,255));
		dateChooserScadenza.getCalendarButton().setOpaque(false);
		dateChooserScadenza.getCalendarButton().setBorder(null);
		dateChooserScadenza.getCalendarButton().setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/calendar.png")));
		dateChooserEditorScadenza = ((JTextFieldDateEditor)dateChooserScadenza.getDateEditor());
		dateChooserEditorScadenza.setOpaque(false);
		dateChooserEditorScadenza.setForeground(new Color(0,41,82));
		dateChooserEditorScadenza.setBorder(new RoundedCornerBorder());
		dateChooserEditorScadenza.setFont(new Font("Cambria", Font.BOLD, 14));
		dateChooserEditorScadenza.setSelectedTextColor(new Color (191,215,255));
		dateChooserEditorScadenza.setSelectionColor(new Color (0,41,82));
		dateChooserScadenza.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserScadenza.setMinSelectableDate(data_corrente);
		dateChooserScadenza.setDateFormatString("dd-MM-yyyy");
		dateChooserScadenza.setBounds(340, 237, 275, 25);
		contentPane.add(dateChooserScadenza);
		
		/*JDATECHOOSER RACCOLTA*/
		dateChooserRaccolta = new JDateChooser();
		dateChooserRaccolta.getCalendarButton().setBorderPainted(false);
		dateChooserRaccolta.getCalendarButton().setContentAreaFilled(false);
		dateChooserRaccolta.getCalendarButton().setBackground(new Color(191,215,255));
		dateChooserRaccolta.getCalendarButton().setOpaque(false);
		dateChooserRaccolta.getCalendarButton().setBorder(null);
		dateChooserRaccolta.getCalendarButton().setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/calendar.png")));
		dateChooserEditorRaccolta = ((JTextFieldDateEditor)dateChooserRaccolta.getDateEditor());
		dateChooserEditorRaccolta.setOpaque(false);
		dateChooserEditorRaccolta.setForeground(new Color(0,41,82));
		dateChooserEditorRaccolta.setSelectedTextColor(new Color (191,215,255));
		dateChooserEditorRaccolta.setSelectionColor(new Color (0,41,82));
		dateChooserEditorRaccolta.setBorder(new RoundedCornerBorder());
		dateChooserEditorRaccolta.setFont(new Font("Cambria", Font.BOLD, 14));
		dateChooserRaccolta.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserRaccolta.setMaxSelectableDate(data_corrente);
		dateChooserRaccolta.setDateFormatString("dd-MM-yyyy");
		dateChooserRaccolta.setBounds(340, 320, 275, 25);
		contentPane.add(dateChooserRaccolta);
		
		/*JDATECHOOSER PRODUZIONE*/
		dateChooserProduzione = new JDateChooser();
		dateChooserProduzione.getCalendarButton().setBorderPainted(false);
		dateChooserProduzione.getCalendarButton().setContentAreaFilled(false);
		dateChooserProduzione.getCalendarButton().setBackground(new Color(191,215,255));
		dateChooserProduzione.getCalendarButton().setOpaque(false);
		dateChooserProduzione.getCalendarButton().setBorder(null);
		dateChooserProduzione.getCalendarButton().setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/calendar.png")));
		dateChooserEditorProduzione = ((JTextFieldDateEditor)dateChooserProduzione.getDateEditor());
		dateChooserEditorProduzione.setOpaque(false);
		dateChooserEditorProduzione.setForeground(new Color(0,41,82));
		dateChooserEditorProduzione.setSelectedTextColor(new Color (191,215,255));
		dateChooserEditorProduzione.setSelectionColor(new Color (0,41,82));
		dateChooserEditorProduzione.setBorder(new RoundedCornerBorder());
		dateChooserEditorProduzione.setFont(new Font("Cambria", Font.BOLD, 14));
		dateChooserProduzione.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserProduzione.setMaxSelectableDate(data_corrente);
		dateChooserProduzione.setDateFormatString("dd-MM-yyyy");
		dateChooserProduzione.setBounds(340, 320, 275, 25);
		dateChooserProduzione.setVisible(false);
		contentPane.add(dateChooserProduzione);
		
		/*JDATECHOOSER CONFEZIONAMENTO*/ 
		dateChooserConfezionamento = new JDateChooser();
		dateChooserConfezionamento.getCalendarButton().setBorderPainted(false);
		dateChooserConfezionamento.getCalendarButton().setContentAreaFilled(false);
		dateChooserConfezionamento.getCalendarButton().setBackground(new Color(191,215,255));
		dateChooserConfezionamento.getCalendarButton().setOpaque(false);
		dateChooserConfezionamento.getCalendarButton().setBorder(null);
		dateChooserConfezionamento.getCalendarButton().setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/calendar.png")));
		dateChooserEditorConfezionamento = ((JTextFieldDateEditor)dateChooserConfezionamento.getDateEditor());
		dateChooserEditorConfezionamento.setOpaque(false);
		dateChooserEditorConfezionamento.setForeground(new Color(0,41,82));
		dateChooserEditorConfezionamento.setSelectedTextColor(new Color (191,215,255));
		dateChooserEditorConfezionamento.setSelectionColor(new Color (0,41,82));
		dateChooserEditorConfezionamento.setBorder(new RoundedCornerBorder());
		dateChooserEditorConfezionamento.setFont(new Font("Cambria", Font.BOLD, 14));
		dateChooserConfezionamento.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserConfezionamento.setMaxSelectableDate(data_corrente);
		dateChooserConfezionamento.setDateFormatString("dd-MM-yyyy");
		dateChooserConfezionamento.setBounds(340, 320, 275, 25);
		dateChooserConfezionamento.setVisible(false);
		contentPane.add(dateChooserConfezionamento);
		
		/*JDATECHOOSER MUNGITURA*/ 
		dateChooserMungitura = new JDateChooser();
		dateChooserMungitura.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				dateChooserProduzione.setMinSelectableDate(dateChooserMungitura.getDate());
			}
		});
		dateChooserMungitura.getCalendarButton().setBorderPainted(false);
		dateChooserMungitura.getCalendarButton().setContentAreaFilled(false);
		dateChooserMungitura.getCalendarButton().setBackground(new Color(191,215,255));
		dateChooserMungitura.getCalendarButton().setOpaque(false);
		dateChooserMungitura.getCalendarButton().setBorder(null);
		dateChooserMungitura.getCalendarButton().setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/calendar.png")));
		dateChooserMungitura.setVisible(false);
		dateChooserEditorMungitura = ((JTextFieldDateEditor)dateChooserMungitura.getDateEditor());
		dateChooserEditorMungitura.setOpaque(false);
		dateChooserEditorMungitura.setForeground(new Color(0,41,82));;
		dateChooserEditorMungitura.setSelectedTextColor(new Color (191,215,255));
		dateChooserEditorMungitura.setSelectionColor(new Color (0,41,82));
		dateChooserEditorMungitura.setBorder(new RoundedCornerBorder());
		dateChooserEditorMungitura.setFont(new Font("Cambria", Font.BOLD, 14));
		dateChooserMungitura.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserMungitura.setMaxSelectableDate(data_corrente);
		dateChooserMungitura.setDateFormatString("dd-MM-yyyy");
		dateChooserMungitura.setBounds(340, 368, 275, 25);
		contentPane.add(dateChooserMungitura);
		
		/*JDATECHOOSER DEPOSIZIONE*/ 
		dateChooserDeposizione = new JDateChooser();
		dateChooserDeposizione.getCalendarButton().setBorderPainted(false);
		dateChooserDeposizione.getCalendarButton().setContentAreaFilled(false);
		dateChooserDeposizione.getCalendarButton().setBackground(new Color(191,215,255));
		dateChooserDeposizione.getCalendarButton().setOpaque(false);
		dateChooserDeposizione.getCalendarButton().setBorder(null);
		dateChooserDeposizione.getCalendarButton().setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/calendar.png")));
		dateChooserEditorDeposizione = ((JTextFieldDateEditor)dateChooserDeposizione.getDateEditor());
		dateChooserEditorDeposizione.setOpaque(false);
		dateChooserEditorDeposizione.setForeground(new Color(0,41,82));
		dateChooserEditorDeposizione.setSelectedTextColor(new Color (191,215,255));
		dateChooserEditorDeposizione.setSelectionColor(new Color (0,41,82));
		dateChooserEditorDeposizione.setBorder(new RoundedCornerBorder());
		dateChooserEditorDeposizione.setFont(new Font("Cambria", Font.BOLD, 14));
		dateChooserDeposizione.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserDeposizione.setMaxSelectableDate(data_corrente);
		dateChooserDeposizione.setDateFormatString("dd-MM-yyyy");
		dateChooserDeposizione.setBounds(340, 320, 275, 25);
		dateChooserDeposizione.setVisible(false);
		contentPane.add(dateChooserDeposizione);
		
		/*BUTTON ORTOFRUTTA*/
		ButtonOrtofrutta = new JButton("");
		ButtonOrtofrutta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome = "ORTOFRUTTA";
				VisibilitaLabel("ORTOFRUTTA");
			}
		});
		ButtonOrtofrutta.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonOrtofruttaBlue.png")));
		ButtonOrtofrutta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonOrtofrutta.setOpaque(false);
		ButtonOrtofrutta.setBorder(null);
		ButtonOrtofrutta.setContentAreaFilled(false);
		ButtonOrtofrutta.setBounds(74, 11, 78, 83);
		contentPane.add(ButtonOrtofrutta);
		
		/*BUTTON FARINACEI*/
		ButtonFarinacei = new JButton("");
		ButtonFarinacei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome = "FARINACEO";
				VisibilitaLabel("FARINACEO");
			}
		});
		ButtonFarinacei.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonFarinacei.png")));
		ButtonFarinacei.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonFarinacei.setOpaque(false);
		ButtonFarinacei.setBorder(null);
		ButtonFarinacei.setContentAreaFilled(false);
		ButtonFarinacei.setBounds(189, 11, 78, 83);
		contentPane.add(ButtonFarinacei);
		
		/*BUTTON CONFEZIONATI*/
		ButtonConfezionati = new JButton("");
		ButtonConfezionati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome = "CONFEZIONATO";
				VisibilitaLabel("CONFEZIONATO");
			}
		});
		ButtonConfezionati.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonConfezionati.png")));
		ButtonConfezionati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonConfezionati.setOpaque(false);
		ButtonConfezionati.setBorder(null);
		ButtonConfezionati.setContentAreaFilled(false);
		ButtonConfezionati.setBounds(308, 11, 78, 83);
		contentPane.add(ButtonConfezionati);
		
		/*BUTTON LATTICINI*/
		ButtonLatticini = new JButton("");
		ButtonLatticini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome = "LATTICINO";
				VisibilitaLabel("LATTICINO");
			}
		});
		ButtonLatticini.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonLatticini.png")));
		ButtonLatticini.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonLatticini.setOpaque(false);
		ButtonLatticini.setBorder(null);
		ButtonLatticini.setContentAreaFilled(false);
		ButtonLatticini.setBounds(431, 10, 78, 83);
		contentPane.add(ButtonLatticini);
		
		/*BUTTON UOVA*/
		ButtonUova = new JButton("");
		ButtonUova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome = "UOVA";
				VisibilitaLabel("UOVA");
			}
		});
		ButtonUova.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonUova.png")));
		ButtonUova.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonUova.setOpaque(false);
		ButtonUova.setBorder(null);
		ButtonUova.setContentAreaFilled(false);
		ButtonUova.setBounds(558, 10, 78, 83);
		contentPane.add(ButtonUova);
		
		/*BUTTON AGGIUNGI*/
		ButtonAggiugni = new JButton("");
		ButtonAggiugni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlliAggiungiProdotto(ctrl);
			}
		});
		ButtonAggiugni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi2Azzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi2.png")));
			}
		});
		ButtonAggiugni.setPressedIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi2.png")));
		ButtonAggiugni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiugni.setOpaque(false);
		ButtonAggiugni.setBorder(null);
		ButtonAggiugni.setContentAreaFilled(false);
		ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi2.png")));
		ButtonAggiugni.setBounds(505, 455, 110, 24);
		contentPane.add(ButtonAggiugni);
		
		/*BUTTON RIMUOVI TUTTO*/
		ButtonRimuoviTutto = new JButton("");
		ButtonRimuoviTutto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "TUTTI I CAMPI VERRANNO CANCELLATI", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);
				setAlwaysOnTop(true);
				RimuoviTutto();
			}
		});
		ButtonRimuoviTutto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonRimuoviTutto.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTuttoAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonRimuoviTutto.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
			}
		});
		ButtonRimuoviTutto.setPressedIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
		ButtonRimuoviTutto.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
		ButtonRimuoviTutto.setOpaque(false);
		ButtonRimuoviTutto.setBorder(null);
		ButtonRimuoviTutto.setContentAreaFilled(false);
		ButtonRimuoviTutto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonRimuoviTutto.setBounds(345, 455, 150, 24);
		contentPane.add(ButtonRimuoviTutto);
		
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
				ButtonAnnulla.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAnnullaAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAnnulla.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
			}
		});
		ButtonAnnulla.setPressedIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.setOpaque(false);
		ButtonAnnulla.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAnnulla.setBorder(null);
		ButtonAnnulla.setContentAreaFilled(false);
		ButtonAnnulla.setBounds(106, 455, 110, 24);
		contentPane.add(ButtonAnnulla);
		
		/*LABEL SFONDO*/
		LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/Sfondo.png")));
		LabelSfondo.setBounds(-8, -8, 727, 536);
		contentPane.add(LabelSfondo);
	}
	
	private void ControlliAggiungiProdotto(Controller ctrl) {
		if (nome.equals("ORTOFRUTTA")) {
			AggiungiOrtofrutta(ctrl);
		}
		else if(nome.equals("LATTICINO")) {
			AggiungiLatticino(ctrl);
		}
		else if(nome.equals("CONFEZIONATO")) {
			AggiungiConfezionato(ctrl);
		}
		else if(nome.equals("FARINACEO")) {
			AggiungiFarinaceo(ctrl);
		}
		else if(nome.equals("UOVA")) {
			AggiungiUovo(ctrl);
		}
	
	}
	
	private void RimuoviTutto() {
		textFieldNome.setText("");
		textFieldPrezzo.setText("");
		spinnerQuantita.setValue(1);
		dateChooserScadenza.setDate(null);
		dateChooserRaccolta.setDate(null);
		dateChooserProduzione.setDate(null);
		dateChooserMungitura.setDate(null);
		dateChooserConfezionamento.setDate(null);
		dateChooserDeposizione.setDate(null);
	}
	
	private void VisibilitaLabel(String nome) {
		if(nome.equals("ORTOFRUTTA")) {
			ButtonOrtofrutta.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonOrtofruttaBlue.png")));
			ButtonFarinacei.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonFarinacei.png")));
			ButtonConfezionati.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonConfezionati.png")));
			ButtonLatticini.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonLatticini.png")));
			ButtonUova.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonUova.png")));
			LabelDataConfezionamento.setVisible(false);
			LabelDataRaccolta.setVisible(true);
			LabelDataMungitura.setVisible(false);
			LabelDataProduzione.setVisible(false);
			LabelDataDeposizione.setVisible(false);
			textFieldNome.setText("");
			textFieldNome.setEnabled(true);
			dateChooserConfezionamento.setVisible(false);
			dateChooserRaccolta.setVisible(true);
			dateChooserMungitura.setVisible(false);
			dateChooserProduzione.setVisible(false);
			dateChooserDeposizione.setVisible(false);
		}
		else if(nome.equals("LATTICINO")) {
			ButtonOrtofrutta.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonOrtofrutta.png")));
			ButtonFarinacei.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonFarinacei.png")));
			ButtonConfezionati.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonConfezionati.png")));
			ButtonLatticini.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonLatticiniBlue.png")));
			ButtonUova.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonUova.png")));
			LabelDataConfezionamento.setVisible(false);
			LabelDataRaccolta.setVisible(false);
			LabelDataMungitura.setVisible(true);
			LabelDataProduzione.setVisible(true);
			LabelDataDeposizione.setVisible(false);
			textFieldNome.setText("");
			textFieldNome.setEnabled(true);
			dateChooserConfezionamento.setVisible(false);
			dateChooserConfezionamento.setVisible(false);
			dateChooserRaccolta.setVisible(false);
			dateChooserMungitura.setVisible(true);
			dateChooserProduzione.setVisible(true);
			dateChooserDeposizione.setVisible(false);
		}
		else if(nome.equals("CONFEZIONATO")) {
			ButtonOrtofrutta.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonOrtofrutta.png")));
			ButtonFarinacei.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonFarinacei.png")));
			ButtonConfezionati.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonConfezionatiBlue.png")));
			ButtonLatticini.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonLatticini.png")));
			ButtonUova.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonUova.png")));
			LabelDataConfezionamento.setVisible(true);
			LabelDataRaccolta.setVisible(false);
			LabelDataMungitura.setVisible(false);
			LabelDataProduzione.setVisible(false);
			LabelDataDeposizione.setVisible(false);
			textFieldNome.setText("");
			textFieldNome.setEnabled(true);
			dateChooserConfezionamento.setVisible(false);
			dateChooserConfezionamento.setVisible(true);
			dateChooserRaccolta.setVisible(false);
			dateChooserMungitura.setVisible(false);
			dateChooserProduzione.setVisible(false);
			dateChooserDeposizione.setVisible(false);
		
		}
		else if(nome.equals("FARINACEO")) {
			ButtonOrtofrutta.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonOrtofrutta.png")));
			ButtonFarinacei.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonFarinaceiBlue.png")));
			ButtonConfezionati.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonConfezionati.png")));
			ButtonLatticini.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonLatticini.png")));
			ButtonUova.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonUova.png")));
			LabelDataConfezionamento.setVisible(false);
			LabelDataRaccolta.setVisible(false);
			LabelDataMungitura.setVisible(false);
			LabelDataProduzione.setVisible(true);
			LabelDataDeposizione.setVisible(false);
			textFieldNome.setText("");
			textFieldNome.setEnabled(true);
			dateChooserConfezionamento.setVisible(false);
			dateChooserConfezionamento.setVisible(false);
			dateChooserRaccolta.setVisible(false);
			dateChooserMungitura.setVisible(false);
			dateChooserProduzione.setVisible(true);
			dateChooserDeposizione.setVisible(false);
			
		}
		else if(nome.equals("UOVA")) {
			ButtonOrtofrutta.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonOrtofrutta.png")));
			ButtonFarinacei.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonFarinacei.png")));
			ButtonConfezionati.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonConfezionati.png")));
			ButtonLatticini.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonLatticini.png")));
			ButtonUova.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonUovaBlue.png")));
			LabelDataConfezionamento.setVisible(false);
			LabelDataRaccolta.setVisible(false);
			LabelDataMungitura.setVisible(false);
			LabelDataProduzione.setVisible(false);
			LabelDataDeposizione.setVisible(true);
			textFieldNome.setText("UOVA");
			textFieldNome.setDisabledTextColor(new Color(0,41,82));
			textFieldNome.setEnabled(false);
			dateChooserConfezionamento.setVisible(false);
			dateChooserConfezionamento.setVisible(false);
			dateChooserRaccolta.setVisible(false);
			dateChooserMungitura.setVisible(false);
			dateChooserProduzione.setVisible(false);
			dateChooserDeposizione.setVisible(true);
		}
	}

	private void ProdottoAggiuntoCorrettamente() {
		setAlwaysOnTop(false);
		JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE \nAGGIORNARE LA TABELLA PER VISUALIZZARE IL PRODOTTO", "", JOptionPane.INFORMATION_MESSAGE);
		setAlwaysOnTop(true);
		RimuoviTutto();
	}
	
	private void ErroreAggiuntaProdotto() {
		setAlwaysOnTop(false);
		JOptionPane.showMessageDialog(null, "COMPLETARE TUTTI I CAMPI", "", JOptionPane.ERROR_MESSAGE);
		setAlwaysOnTop(true);
	}
	
	private void ErroreDateLatticino() {
		setAlwaysOnTop(false);
		JOptionPane.showMessageDialog(null, "LA DATA MUNGITURA NON PUO ESSERE MAGGIORE DELLA DATA PRODUZIONE", "", JOptionPane.ERROR_MESSAGE);
		setAlwaysOnTop(true);
	}
	
	private void AggiungiOrtofrutta(Controller ctrl) {
		if (textFieldNome.getText().length() == 0 || textFieldPrezzo.getText().length() == 0
				|| dateChooserEditorScadenza.getText().length() == 0 || dateChooserEditorRaccolta.getText().length() == 0) {
			ErroreAggiuntaProdotto();
		}
		else {
			ctrl.InserisciProdottoOrtofruttaInDeposito(textFieldNome.getText(), Double.parseDouble(textFieldPrezzo.getText()), Integer.parseInt(spinnerQuantita.getValue().toString()), 
					dateChooserEditorScadenza.getDate().getTime(), dateChooserEditorRaccolta.getDate().getTime());
			ProdottoAggiuntoCorrettamente();
		}
	}
	
	private void AggiungiLatticino(Controller ctrl) {
		if (textFieldNome.getText().length() == 0 || textFieldPrezzo.getText().length() == 0
				|| dateChooserEditorScadenza.getText().length() == 0 || dateChooserEditorProduzione.getText().length() == 0 
				|| dateChooserEditorMungitura.getText().length() == 0) {
			ErroreAggiuntaProdotto();
			
		}
		else if(dateChooserProduzione.getDate().compareTo(dateChooserMungitura.getDate())<0) {
			ErroreDateLatticino();
		}
		else {
			ctrl.InserisciProdottoLatticinoInDeposito(textFieldNome.getText(), Double.parseDouble(textFieldPrezzo.getText()), Integer.parseInt(spinnerQuantita.getValue().toString()), 
					dateChooserEditorScadenza.getDate().getTime(), dateChooserEditorMungitura.getDate().getTime(), dateChooserEditorProduzione.getDate().getTime());
			ProdottoAggiuntoCorrettamente();
		}
	}
	
	private void AggiungiConfezionato(Controller ctrl) {
		if (textFieldNome.getText().length() == 0 || textFieldPrezzo.getText().length() == 0
				|| dateChooserEditorScadenza.getText().length() == 0 || dateChooserEditorConfezionamento.getText().length() == 0) {
			ErroreAggiuntaProdotto();
		} 
		else {
			ctrl.InserisciProdottoConfezionatoInDeposito(textFieldNome.getText(), Double.parseDouble(textFieldPrezzo.getText()), Integer.parseInt(spinnerQuantita.getValue().toString()), 
					dateChooserEditorScadenza.getDate().getTime(), dateChooserEditorConfezionamento.getDate().getTime());
			ProdottoAggiuntoCorrettamente();
		}
	}
	
	private void AggiungiFarinaceo(Controller ctrl) {
		if (textFieldNome.getText().length() == 0 || textFieldPrezzo.getText().length() == 0
				|| dateChooserEditorScadenza.getText().length() == 0 || dateChooserEditorProduzione.getText().length() == 0 ) {
			ErroreAggiuntaProdotto();
		}
		else {
			ctrl.InserisciProdottoFarinaceoInDeposito(textFieldNome.getText(), Double.parseDouble(textFieldPrezzo.getText()), Integer.parseInt(spinnerQuantita.getValue().toString()), 
					dateChooserEditorScadenza.getDate().getTime(), dateChooserEditorProduzione.getDate().getTime());
			ProdottoAggiuntoCorrettamente();
		}
	}
	
	private void AggiungiUovo(Controller ctrl) {
		if (textFieldNome.getText().length() == 0 || textFieldPrezzo.getText().length() == 0
				|| dateChooserEditorScadenza.getText().length() == 0 || dateChooserEditorDeposizione.getText().length() == 0 ) {
			ErroreAggiuntaProdotto();
		}
		else {
			ctrl.InserisciProdottoUovaInDeposito(textFieldNome.getText(), Double.parseDouble(textFieldPrezzo.getText()), Integer.parseInt(spinnerQuantita.getValue().toString()), 
					dateChooserEditorScadenza.getDate().getTime(), dateChooserEditorDeposizione.getDate().getTime());
			ProdottoAggiuntoCorrettamente();
		}
	}
}
