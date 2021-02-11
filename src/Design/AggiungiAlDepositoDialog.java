package Design;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboPopup;
import Main.Controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.accessibility.AccessibleContext;
import javax.swing.DefaultComboBoxModel;

import java.util.Date;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import ExternalClasses.ContentPane;
import ExternalClasses.RoundedCornerBorder;

public class AggiungiAlDepositoDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel LabelTipologia;
	private JLabel LabelNome;
	private JLabel LabelPrezzo;
	private JLabel LabelDataScadenza;
	private JLabel LabelQuantita;
	private JLabel LabelDataRaccolta;
	private JLabel LabelDataProduzione;
	private JLabel LabelDataConfezionamento;
	private JLabel LabelDataMungitura;
	private JLabel LabelDataDeposizione;
	private JLabel LabelFoto;
	private JTextField textFieldNome;
	private JTextField textFieldPrezzo;
	private JSpinner spinnerQuantita;
	private JTextField textFieldFoto;
	private JComboBox comboBoxTipologia;
	private JList<?> list;
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
	private JButton ButtonAggiugni;
	private JButton ButtonRimuoviTutto;
	private JButton ButtonAnnulla;
	private JButton ButtonAggiungiFoto;
	private JLabel LabelSfondo;

	public AggiungiAlDepositoDialog(Controller ctrl) {
		
		Date data_corrente = new Date();
		setAlwaysOnTop(true);
		setUndecorated(true);
		setSize(710, 518);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setLayout(null);
		
		ContentPane contentPane = new ContentPane();
		setContentPane(contentPane);
		getContentPane().isOpaque();
		setBackground(new Color(0, 67, 137, 0));
		contentPane.setLayout(null);

		/*LABEL TIPOLOGIA*/
		LabelTipologia = new JLabel("Tipologia");
		LabelTipologia.setForeground(new Color(0, 41, 82));
		LabelTipologia.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelTipologia.setBounds(106, 40, 92, 14);
		getContentPane().add(LabelTipologia);
		
		/*LABEL NOME*/
		LabelNome = new JLabel("Nome");
		LabelNome.setForeground(new Color(0, 41, 82));
		LabelNome.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelNome.setBounds(106, 89, 46, 14);
		getContentPane().add(LabelNome);
		
		/*LABEL PREZZO*/
		LabelPrezzo = new JLabel("Prezzo");
		LabelPrezzo.setForeground(new Color(0, 41, 82));
		LabelPrezzo.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelPrezzo.setBounds(106, 136, 50, 14);
		getContentPane().add(LabelPrezzo);
		
		/*LABEL DATA SCADENZA*/
		LabelDataScadenza = new JLabel("Data Scadenza");
		LabelDataScadenza.setForeground(new Color(0, 41, 82));
		LabelDataScadenza.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataScadenza.setBounds(106, 180, 118, 14);
		getContentPane().add(LabelDataScadenza);
		
		/*LABEL QUANTITA*/
		LabelQuantita = new JLabel("Quantit\u00E0");
		LabelQuantita.setForeground(new Color(0, 41, 82));
		LabelQuantita.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelQuantita.setBounds(106, 230, 68, 14);
		getContentPane().add(LabelQuantita);
		
		/*LABEL RACCOLTA*/
		LabelDataRaccolta = new JLabel("Data Raccolta");
		LabelDataRaccolta.setVisible(true);
		LabelDataRaccolta.setForeground(new Color(0, 41, 82));
		LabelDataRaccolta.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataRaccolta.setBounds(106, 326, 118, 14);
		getContentPane().add(LabelDataRaccolta);
		
		/*LABEL PRODUZIONE*/
		LabelDataProduzione = new JLabel("Data Produzione");
		LabelDataProduzione.setVisible(false);
		LabelDataProduzione.setForeground(new Color(0, 41, 82));
		LabelDataProduzione.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataProduzione.setBounds(106, 326, 141, 14);
		getContentPane().add(LabelDataProduzione);
		
		/*LABEL MUNGITURA*/
		LabelDataMungitura = new JLabel("Data Mungitura");
		LabelDataMungitura.setVisible(false);
		LabelDataMungitura.setForeground(new Color(0, 41, 82));
		LabelDataMungitura.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataMungitura.setBounds(106, 374, 118, 14);
		getContentPane().add(LabelDataMungitura);
		
		/*LABEL CONFEZIONAMENTO*/
		LabelDataConfezionamento = new JLabel("Data Confezionamento");
		LabelDataConfezionamento.setVisible(false);
		LabelDataConfezionamento.setForeground(new Color(0, 41, 82));
		LabelDataConfezionamento.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataConfezionamento.setBounds(106, 326, 180, 14);
		getContentPane().add(LabelDataConfezionamento);
		
		/*LABEL DEPOSIZIONE*/
		LabelDataDeposizione = new JLabel ("Data Deposizione");
		LabelDataDeposizione.setVisible(false);
		LabelDataDeposizione.setForeground(new Color(0, 41, 82));
		LabelDataDeposizione.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataDeposizione.setBounds(106, 326, 161, 14);
		getContentPane().add(LabelDataDeposizione);
		
		/*LABEL FOTO*/
		LabelFoto = new JLabel("Foto");
		LabelFoto.setVisible(false);
		LabelFoto.setForeground(new Color(0, 41, 82));
		LabelFoto.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelFoto.setBounds(106, 274, 46, 14);
		getContentPane().add(LabelFoto);
		
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
		textFieldNome.setSelectedTextColor(new Color (191,215,255));
		textFieldNome.setSelectionColor(new Color (0,41,82));
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(340, 78, 275, 25);
		textFieldNome.setCaretColor(new Color(0, 41, 82));
		getContentPane().add(textFieldNome);
		
		/*TEXTFIELD PREZZO*/
		textFieldPrezzo = new JTextField(20) ;
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
		textFieldPrezzo.setSelectedTextColor(new Color (191,215,255));
		textFieldPrezzo.setSelectionColor(new Color (0,41,82));
		textFieldPrezzo.setColumns(10);
		textFieldPrezzo.setBounds(340, 124, 275, 25);
		textFieldPrezzo.setCaretColor(new Color(0, 41, 82));
		getContentPane().add(textFieldPrezzo);
		
		/*JSPINNER QUANTITA*/
		SpinnerNumberModel spinnermodel = new SpinnerNumberModel(1, 1, 50, 1);
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
		spinnerQuantita.setBounds(340, 219, 46, 25);
		getContentPane().add(spinnerQuantita);
		
		/*JDATECHOOSER SCADENZA*/
		dateChooserScadenza = new JDateChooser();
		dateChooserEditorScadenza = ((JTextFieldDateEditor)dateChooserScadenza.getDateEditor());
		dateChooserEditorScadenza.setOpaque(false);
		dateChooserEditorScadenza.setForeground(new Color(0, 41, 82));
		dateChooserEditorScadenza.setBorder(new RoundedCornerBorder());
		dateChooserEditorScadenza.setFont(new Font("Cambria", Font.BOLD, 14));
		dateChooserEditorScadenza.setSelectedTextColor(new Color (191,215,255));
		dateChooserEditorScadenza.setSelectionColor(new Color (0,41,82));
		dateChooserScadenza.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserScadenza.setMinSelectableDate(data_corrente);
		dateChooserScadenza.setDateFormatString("dd-MM-yyyy");
		dateChooserScadenza.setBounds(340, 172, 275, 25);
		contentPane.add(dateChooserScadenza);
		
		/*JDATECHOOSER RACCOLTA*/
		dateChooserRaccolta = new JDateChooser();
		dateChooserEditorRaccolta = ((JTextFieldDateEditor)dateChooserRaccolta.getDateEditor());
		dateChooserEditorRaccolta.setOpaque(false);
		dateChooserEditorRaccolta.setForeground(new Color(0, 41, 82));
		dateChooserEditorRaccolta.setSelectedTextColor(new Color (191,215,255));
		dateChooserEditorRaccolta.setSelectionColor(new Color (0,41,82));
		dateChooserEditorRaccolta.setBorder(new RoundedCornerBorder());
		dateChooserEditorRaccolta.setFont(new Font("Cambria", Font.BOLD, 14));
		dateChooserRaccolta.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserRaccolta.setMaxSelectableDate(data_corrente);
		dateChooserRaccolta.setDateFormatString("dd-MM-yyyy");
		dateChooserRaccolta.setBounds(340, 315, 275, 25);
		contentPane.add(dateChooserRaccolta);
		
		/*JDATECHOOSER PRODUZIONE*/
		dateChooserProduzione = new JDateChooser();
		dateChooserEditorProduzione = ((JTextFieldDateEditor)dateChooserProduzione.getDateEditor());
		dateChooserEditorProduzione.setOpaque(false);
		dateChooserEditorProduzione.setForeground(new Color(0, 41, 82));
		dateChooserEditorProduzione.setSelectedTextColor(new Color (191,215,255));
		dateChooserEditorProduzione.setSelectionColor(new Color (0,41,82));
		dateChooserEditorProduzione.setBorder(new RoundedCornerBorder());
		dateChooserEditorProduzione.setFont(new Font("Cambria", Font.BOLD, 14));
		dateChooserProduzione.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserProduzione.setMaxSelectableDate(data_corrente);
		dateChooserProduzione.setDateFormatString("dd-MM-yyyy");
		dateChooserProduzione.setBounds(340, 315, 275, 25);
		dateChooserProduzione.setVisible(false);
		contentPane.add(dateChooserProduzione);
		
		/*JDATECHOOSER CONFEZIONAMENTO*/ 
		dateChooserConfezionamento = new JDateChooser();
		dateChooserEditorConfezionamento = ((JTextFieldDateEditor)dateChooserConfezionamento.getDateEditor());
		dateChooserEditorConfezionamento.setOpaque(false);
		dateChooserEditorConfezionamento.setForeground(new Color(0, 41, 82));
		dateChooserEditorConfezionamento.setSelectedTextColor(new Color (191,215,255));
		dateChooserEditorConfezionamento.setSelectionColor(new Color (0,41,82));
		dateChooserEditorConfezionamento.setBorder(new RoundedCornerBorder());
		dateChooserEditorConfezionamento.setFont(new Font("Cambria", Font.BOLD, 14));
		dateChooserConfezionamento.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserConfezionamento.setMaxSelectableDate(data_corrente);
		dateChooserConfezionamento.setDateFormatString("dd-MM-yyyy");
		dateChooserConfezionamento.setBounds(340, 315, 275, 25);
		dateChooserConfezionamento.setVisible(false);
		contentPane.add(dateChooserConfezionamento);
		
		/*JDATECHOOSER MUNGITURA*/ 
		dateChooserMungitura = new JDateChooser();
		dateChooserMungitura.setVisible(false);
		dateChooserEditorMungitura = ((JTextFieldDateEditor)dateChooserMungitura.getDateEditor());
		dateChooserEditorMungitura.setOpaque(false);
		dateChooserEditorMungitura.setForeground(new Color(0, 41, 82));
		dateChooserEditorMungitura.setSelectedTextColor(new Color (191,215,255));
		dateChooserEditorMungitura.setSelectionColor(new Color (0,41,82));
		dateChooserEditorMungitura.setBorder(new RoundedCornerBorder());
		dateChooserEditorMungitura.setFont(new Font("Cambria", Font.BOLD, 14));
		dateChooserMungitura.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserMungitura.setMaxSelectableDate(data_corrente);
		dateChooserMungitura.setDateFormatString("dd-MM-yyyy");
		dateChooserMungitura.setBounds(340, 363, 275, 25);
		contentPane.add(dateChooserMungitura);
		
		/*JDATECHOOSER DEPOSIZIONE*/ 
		dateChooserDeposizione = new JDateChooser();
		dateChooserEditorDeposizione = ((JTextFieldDateEditor)dateChooserDeposizione.getDateEditor());
		dateChooserEditorDeposizione.setOpaque(false);
		dateChooserEditorDeposizione.setForeground(new Color(0, 41, 82));
		dateChooserEditorDeposizione.setSelectedTextColor(new Color (191,215,255));
		dateChooserEditorDeposizione.setSelectionColor(new Color (0,41,82));
		dateChooserEditorDeposizione.setBorder(new RoundedCornerBorder());
		dateChooserEditorDeposizione.setFont(new Font("Cambria", Font.BOLD, 14));
		dateChooserDeposizione.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserDeposizione.setMaxSelectableDate(data_corrente);
		dateChooserDeposizione.setDateFormatString("dd-MM-yyyy");
		dateChooserDeposizione.setBounds(340, 315, 275, 25);
		dateChooserDeposizione.setVisible(false);
		contentPane.add(dateChooserDeposizione);
		
		/*COMBOBOX TIPOLOGIA*/
		comboBoxTipologia = new JComboBox();
		comboBoxTipologia.setOpaque(false);
		comboBoxTipologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisibilitaLabel();
			}
		});
		comboBoxTipologia.setFocusable(false);
		AccessibleContext ac = comboBoxTipologia.getAccessibleContext();
		BasicComboPopup pop = (BasicComboPopup) ac.getAccessibleChild(0);
		list = pop.getList();
		list.setSelectionForeground(new Color(191, 215, 255));
		list.setSelectionBackground(new Color(0, 41, 82));	
		comboBoxTipologia.setModel(new DefaultComboBoxModel(new String[] {"ORTOFRUTTA", "LATTICINI", "CONFEZIONATI", "FARINACEI", "UOVA"}));
		comboBoxTipologia.setOpaque(false);
		comboBoxTipologia.setForeground(new Color(0, 41, 82));
		comboBoxTipologia.setFont(new Font("Cambria", Font.BOLD, 14));
		comboBoxTipologia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxTipologia.setBorder(new RoundedCornerBorder());
		comboBoxTipologia.setMaximumRowCount(5);
		comboBoxTipologia.setBounds(340, 29, 275, 25);
		getContentPane().add(comboBoxTipologia);
		
		/*TEXTFIELD FOTO*/
		textFieldFoto = new JTextField(20) ;
		textFieldFoto.setVisible(false);
		textFieldFoto.setFont(new Font("Cambria", Font.BOLD, 16));
		textFieldFoto.setBorder(new RoundedCornerBorder());
		textFieldFoto.setOpaque(false);
		textFieldFoto.setForeground(new Color(0,41,82));
		textFieldFoto.setSelectedTextColor(new Color (191,215,255));
		textFieldFoto.setSelectionColor(new Color (0,41,82));
		textFieldFoto.setColumns(10);
		textFieldFoto.setBounds(340, 263, 254, 25);
		textFieldFoto.setCaretColor(new Color(0, 41, 82));
		getContentPane().add(textFieldFoto);
		
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
		ButtonAggiugni.setBounds(505, 441, 110, 24);
		getContentPane().add(ButtonAggiugni);
		
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
		ButtonRimuoviTutto.setBounds(345, 441, 150, 24);
		getContentPane().add(ButtonRimuoviTutto);
		
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
		ButtonAnnulla.setBounds(106, 441, 110, 24);
		getContentPane().add(ButtonAnnulla);
		
		/*BUTTON AGGIUNGI FOTO*/
		ButtonAggiungiFoto = new JButton("...");
		ButtonAggiungiFoto.setVisible(false);
		ButtonAggiungiFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAlwaysOnTop(false);
				ctrl.CaricaFileJPGDaPC(textFieldFoto);
				setAlwaysOnTop(true);

			}
		});
		ButtonAggiungiFoto.setBounds(595, 266, 20, 20);
		getContentPane().add(ButtonAggiungiFoto);
		
		/*LABEL SFONDO*/
		LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/Sfondo.png")));
		LabelSfondo.setBounds(-8, -8, 727, 536);
		getContentPane().add(LabelSfondo);
	}
	
	public void ControlliAggiungiProdotto(Controller ctrl) {
		if (comboBoxTipologia.getSelectedItem()=="ORTOFRUTTA") {
			if (textFieldNome.getText().length() == 0 || textFieldPrezzo.getText().length() == 0
					|| dateChooserEditorScadenza.getText().length() == 0 || dateChooserEditorRaccolta.getText().length() == 0) {
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "COMPLETARE TUTTI I CAMPI", "", JOptionPane.ERROR_MESSAGE);
				setAlwaysOnTop(true);
			}
			else {
				ctrl.InserisciProdottoDeposito(textFieldNome.getText(), Double.parseDouble(textFieldPrezzo.getText()), Integer.parseInt(spinnerQuantita.getValue().toString()), 
						dateChooserEditorScadenza.getDate().getTime(), dateChooserEditorRaccolta.getDate().getTime());
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
				setAlwaysOnTop(true);
				RimuoviTutto();
			}
		}
		else if(comboBoxTipologia.getSelectedItem()=="LATTICINI") {
			if (textFieldNome.getText().length() == 0 || textFieldPrezzo.getText().length() == 0
					|| dateChooserEditorScadenza.getText().length() == 0 || dateChooserEditorProduzione.getText().length() == 0 
					|| dateChooserEditorMungitura.getText().length() == 0) {
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "COMPLETARE TUTTI I CAMPI", "", JOptionPane.ERROR_MESSAGE);
				setAlwaysOnTop(true);
			}
			else {
				ctrl.InserisciProdottoLatticino(textFieldNome.getText(), Double.parseDouble(textFieldPrezzo.getText()), Integer.parseInt(spinnerQuantita.getValue().toString()), 
						dateChooserEditorScadenza.getDate().getTime(), dateChooserEditorMungitura.getDate().getTime(), dateChooserEditorProduzione.getDate().getTime());
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
				setAlwaysOnTop(true);
				RimuoviTutto();
			}
		}
		else if(comboBoxTipologia.getSelectedItem()=="CONFEZIONATI") {
			if (textFieldNome.getText().length() == 0 || textFieldPrezzo.getText().length() == 0
					|| dateChooserEditorScadenza.getText().length() == 0 || dateChooserEditorConfezionamento.getText().length() == 0) {
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "COMPLETARE TUTTI I CAMPI", "", JOptionPane.ERROR_MESSAGE);
				setAlwaysOnTop(true);
			}
			else {
				ctrl.InserisciProdottoConfezionato(textFieldNome.getText(), Double.parseDouble(textFieldPrezzo.getText()), Integer.parseInt(spinnerQuantita.getValue().toString()), 
						dateChooserEditorScadenza.getDate().getTime(), dateChooserEditorConfezionamento.getDate().getTime());
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
				setAlwaysOnTop(true);
				RimuoviTutto();
			}
		}else if(comboBoxTipologia.getSelectedItem()=="FARINACEI") {
			if (textFieldNome.getText().length() == 0 || textFieldPrezzo.getText().length() == 0
					|| dateChooserEditorScadenza.getText().length() == 0 || dateChooserEditorProduzione.getText().length() == 0 ) {
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "COMPLETARE TUTTI I CAMPI", "", JOptionPane.ERROR_MESSAGE);
				setAlwaysOnTop(true);
			}
			else {
				ctrl.InserisciProdottoFarinaceo(textFieldNome.getText(), Double.parseDouble(textFieldPrezzo.getText()), Integer.parseInt(spinnerQuantita.getValue().toString()), 
						dateChooserEditorScadenza.getDate().getTime(), dateChooserEditorProduzione.getDate().getTime());
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
				setAlwaysOnTop(true);
				RimuoviTutto();
			}
		}else if(comboBoxTipologia.getSelectedItem()=="UOVA") {
			if (textFieldNome.getText().length() == 0 || textFieldPrezzo.getText().length() == 0
					|| dateChooserEditorScadenza.getText().length() == 0 || dateChooserEditorDeposizione.getText().length() == 0 ) {
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "COMPLETARE TUTTI I CAMPI", "", JOptionPane.ERROR_MESSAGE);
				setAlwaysOnTop(true);
			}
			else {
				ctrl.InserisciProdottoUova(textFieldNome.getText(), Double.parseDouble(textFieldPrezzo.getText()), Integer.parseInt(spinnerQuantita.getValue().toString()), 
						dateChooserEditorScadenza.getDate().getTime(), dateChooserEditorDeposizione.getDate().getTime());
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
				setAlwaysOnTop(true);
				RimuoviTutto();
			}
		}
	
	}
	
	public void RimuoviTutto() {
		textFieldNome.setText("");
		textFieldPrezzo.setText("");
		spinnerQuantita.setValue(1);
		textFieldFoto.setText("");
		dateChooserScadenza.setDate(null);
		dateChooserRaccolta.setDate(null);
		dateChooserProduzione.setDate(null);
		dateChooserMungitura.setDate(null);
		dateChooserConfezionamento.setDate(null);
		dateChooserDeposizione.setDate(null);
	}
	
	public void VisibilitaLabel() {
		if(comboBoxTipologia.getSelectedItem()=="ORTOFRUTTA") {
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
		else if(comboBoxTipologia.getSelectedItem()=="LATTICINI") {
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
		else if(comboBoxTipologia.getSelectedItem()=="CONFEZIONATI") {
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
		
		}else if(comboBoxTipologia.getSelectedItem()=="FARINACEI") {
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
			
		}else if(comboBoxTipologia.getSelectedItem()=="UOVA") {
			LabelDataConfezionamento.setVisible(false);
			LabelDataRaccolta.setVisible(false);
			LabelDataMungitura.setVisible(false);
			LabelDataProduzione.setVisible(false);
			LabelDataDeposizione.setVisible(true);
			textFieldNome.setText("UOVA");
			textFieldNome.setEnabled(false);
			dateChooserConfezionamento.setVisible(false);
			dateChooserConfezionamento.setVisible(false);
			dateChooserRaccolta.setVisible(false);
			dateChooserMungitura.setVisible(false);
			dateChooserProduzione.setVisible(false);
			dateChooserDeposizione.setVisible(true);
	}
	}
}
