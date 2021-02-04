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

public class AggiungiAlDepositoDialog extends JDialog {

	private static final long serialVersionUID = 1L;

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

		JLabel LabelTipologia = new JLabel("Tipologia");
		LabelTipologia.setForeground(new Color(0, 41, 82));
		LabelTipologia.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelTipologia.setBounds(106, 40, 92, 14);
		getContentPane().add(LabelTipologia);
		
		JLabel LabelNome = new JLabel("Nome");
		LabelNome.setForeground(new Color(0, 41, 82));
		LabelNome.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelNome.setBounds(106, 89, 46, 14);
		getContentPane().add(LabelNome);
		
		JLabel LabelPrezzo = new JLabel("Prezzo");
		LabelPrezzo.setForeground(new Color(0, 41, 82));
		LabelPrezzo.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelPrezzo.setBounds(106, 136, 46, 14);
		getContentPane().add(LabelPrezzo);
		
		JLabel LabelDataScadenza = new JLabel("Data Scadenza");
		LabelDataScadenza.setForeground(new Color(0, 41, 82));
		LabelDataScadenza.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelDataScadenza.setBounds(106, 180, 118, 14);
		getContentPane().add(LabelDataScadenza);
		
		JLabel LabelQuantita = new JLabel("Quantit\u00E0");
		LabelQuantita.setForeground(new Color(0, 41, 82));
		LabelQuantita.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelQuantita.setBounds(106, 230, 68, 14);
		getContentPane().add(LabelQuantita);
		
		JLabel LabelDataRaccolta = new JLabel("Data Raccolta");
		LabelDataRaccolta.setVisible(true);
		LabelDataRaccolta.setForeground(new Color(0, 41, 82));
		LabelDataRaccolta.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelDataRaccolta.setBounds(106, 326, 118, 14);
		getContentPane().add(LabelDataRaccolta);
		
		JLabel LabelDataProduzione = new JLabel("Data Produzione");
		LabelDataProduzione.setVisible(false);
		LabelDataProduzione.setForeground(new Color(0, 41, 82));
		LabelDataProduzione.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelDataProduzione.setBounds(106, 326, 118, 14);
		getContentPane().add(LabelDataProduzione);
		
		JLabel LabelDataMungitura = new JLabel("Data Mungitura");
		LabelDataMungitura.setVisible(false);
		LabelDataMungitura.setForeground(new Color(0, 41, 82));
		LabelDataMungitura.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelDataMungitura.setBounds(106, 374, 118, 14);
		getContentPane().add(LabelDataMungitura);
		
		JLabel LabelDataConfezionamento = new JLabel("Data Confezionamento");
		LabelDataConfezionamento.setVisible(false);
		LabelDataConfezionamento.setForeground(new Color(0, 41, 82));
		LabelDataConfezionamento.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelDataConfezionamento.setBounds(106, 326, 161, 14);
		getContentPane().add(LabelDataConfezionamento);
		
		JLabel LabelFoto = new JLabel("Foto");
		LabelFoto.setForeground(new Color(0, 41, 82));
		LabelFoto.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelFoto.setBounds(106, 274, 46, 14);
		getContentPane().add(LabelFoto);
		
		JLabel LabelDataDeposizione = new JLabel ("Data Deposizione");
		LabelDataDeposizione.setVisible(false);
		LabelDataDeposizione.setForeground(new Color(0, 41, 82));
		LabelDataDeposizione.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelDataDeposizione.setBounds(106, 326, 161, 14);
		getContentPane().add(LabelDataDeposizione);
		
		JTextField textFieldNome = new JTextField(20);
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
		textFieldNome.setFont(new Font("Impact", Font.PLAIN, 14));
		textFieldNome.setBorder(new RoundedCornerBorder());
		textFieldNome.setForeground(new Color(0,41,82));
		textFieldNome.setBackground(new Color(191,215,255));
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(340, 78, 275, 25);
		textFieldNome.setCaretColor(new Color(0, 41, 82));
		getContentPane().add(textFieldNome);
		
		
		JTextField textFieldPrezzo = new JTextField(20) ;
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
		textFieldPrezzo.setFont(new Font("Impact", Font.PLAIN, 14));
		textFieldPrezzo.setBorder(new RoundedCornerBorder());
		textFieldPrezzo.setForeground(new Color(0,41,82));
		textFieldPrezzo.setBackground(new Color(191,215,255));
		textFieldPrezzo.setColumns(10);
		textFieldPrezzo.setBounds(340, 124, 275, 25);
		textFieldPrezzo.setCaretColor(new Color(0, 41, 82));
		getContentPane().add(textFieldPrezzo);
		
		SpinnerNumberModel spinnermodel = new SpinnerNumberModel(1, 1, 50, 1);
		JSpinner spinnerQuantita = new JSpinner(spinnermodel);
		spinnerQuantita.setOpaque(false);
		spinnerQuantita.setBorder(new RoundedCornerBorder());
		spinnerQuantita.getComponent(0).setBackground(new Color(191,215,255));
		spinnerQuantita.getComponent(1).setBackground(new Color(191,215,255));
		spinnerQuantita.getEditor().getComponent(0).setBackground(new Color(191,215,255));
		spinnerQuantita.getEditor().getComponent(0).setForeground(new Color(0, 41, 82));
		spinnerQuantita.setRequestFocusEnabled(false);
		spinnerQuantita.setFont(new Font("Impact", Font.PLAIN, 14));
		spinnerQuantita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		spinnerQuantita.setBounds(340, 219, 46, 25);
		getContentPane().add(spinnerQuantita);
		
		JDateChooser dateChooserScadenza = new JDateChooser();
		JTextFieldDateEditor dateChooserEditorScadenza = ((JTextFieldDateEditor)dateChooserScadenza.getDateEditor());
		dateChooserEditorScadenza.setBackground(new Color(191, 215, 255));
		dateChooserEditorScadenza.setForeground(new Color(0, 41, 82));
		dateChooserEditorScadenza.setBorder(new RoundedCornerBorder());
		dateChooserEditorScadenza.setFont(new Font("Impact", Font.PLAIN, 12));
		dateChooserScadenza.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserScadenza.setMinSelectableDate(data_corrente);
		dateChooserScadenza.setDateFormatString("dd-MM-yyyy");
		dateChooserScadenza.setBounds(340, 172, 275, 25);
		contentPane.add(dateChooserScadenza);
		
		JDateChooser dateChooserRaccolta = new JDateChooser();
		JTextFieldDateEditor dateChooserEditorRaccolta = ((JTextFieldDateEditor)dateChooserRaccolta.getDateEditor());
		dateChooserEditorRaccolta.setBackground(new Color(191, 215, 255));
		dateChooserEditorRaccolta.setForeground(new Color(0, 41, 82));
		dateChooserEditorRaccolta.setBorder(new RoundedCornerBorder());
		dateChooserEditorRaccolta.setFont(new Font("Impact", Font.PLAIN, 12));
		dateChooserRaccolta.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserRaccolta.setMaxSelectableDate(data_corrente);
		dateChooserRaccolta.setDateFormatString("dd-MM-yyyy");
		dateChooserRaccolta.setBounds(340, 315, 275, 25);
		contentPane.add(dateChooserRaccolta);
		
		JDateChooser dateChooserProduzione = new JDateChooser();
		JTextFieldDateEditor dateChooserEditorProduzione = ((JTextFieldDateEditor)dateChooserProduzione.getDateEditor());
		dateChooserEditorProduzione.setBackground(new Color(191, 215, 255));
		dateChooserEditorProduzione.setForeground(new Color(0, 41, 82));
		dateChooserEditorProduzione.setBorder(new RoundedCornerBorder());
		dateChooserEditorProduzione.setFont(new Font("Impact", Font.PLAIN, 12));
		dateChooserProduzione.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserProduzione.setMaxSelectableDate(data_corrente);
		dateChooserProduzione.setDateFormatString("dd-MM-yyyy");
		dateChooserProduzione.setBounds(340, 315, 275, 25);
		dateChooserProduzione.setVisible(false);
		contentPane.add(dateChooserProduzione);
		
		JDateChooser dateChooserConfezionamento = new JDateChooser();
		JTextFieldDateEditor dateChooserEditorConfezionamento = ((JTextFieldDateEditor)dateChooserConfezionamento.getDateEditor());
		dateChooserEditorConfezionamento.setBackground(new Color(191, 215, 255));
		dateChooserEditorConfezionamento.setForeground(new Color(0, 41, 82));
		dateChooserEditorConfezionamento.setBorder(new RoundedCornerBorder());
		dateChooserEditorConfezionamento.setFont(new Font("Impact", Font.PLAIN, 12));
		dateChooserConfezionamento.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserConfezionamento.setMaxSelectableDate(data_corrente);
		dateChooserConfezionamento.setDateFormatString("dd-MM-yyyy");
		dateChooserConfezionamento.setBounds(340, 315, 275, 25);
		dateChooserConfezionamento.setVisible(false);
		contentPane.add(dateChooserConfezionamento);
		
		JDateChooser dateChooserMungitura = new JDateChooser();
		JTextFieldDateEditor dateChooserEditorMungitura = ((JTextFieldDateEditor)dateChooserMungitura.getDateEditor());
		dateChooserEditorMungitura.setBackground(new Color(191, 215, 255));
		dateChooserEditorMungitura.setForeground(new Color(0, 41, 82));
		dateChooserEditorMungitura.setBorder(new RoundedCornerBorder());
		dateChooserEditorMungitura.setFont(new Font("Impact", Font.PLAIN, 12));
		dateChooserMungitura.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserMungitura.setMaxSelectableDate(data_corrente);
		dateChooserMungitura.setDateFormatString("dd-MM-yyyy");
		dateChooserMungitura.setBounds(340, 363, 275, 25);
		dateChooserMungitura.setVisible(false);
		contentPane.add(dateChooserMungitura);
		
		JDateChooser dateChooserDeposizione = new JDateChooser();
		JTextFieldDateEditor dateChooserEditorDeposizione = ((JTextFieldDateEditor)dateChooserDeposizione.getDateEditor());
		dateChooserEditorDeposizione.setBackground(new Color(191, 215, 255));
		dateChooserEditorDeposizione.setForeground(new Color(0, 41, 82));
		dateChooserEditorDeposizione.setBorder(new RoundedCornerBorder());
		dateChooserEditorDeposizione.setFont(new Font("Impact", Font.PLAIN, 12));
		dateChooserDeposizione.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserDeposizione.setMaxSelectableDate(data_corrente);
		dateChooserDeposizione.setDateFormatString("dd-MM-yyyy");
		dateChooserDeposizione.setBounds(340, 315, 275, 25);
		dateChooserDeposizione.setVisible(false);
		contentPane.add(dateChooserDeposizione);
		
		JComboBox comboBoxTipologia = new JComboBox();
		comboBoxTipologia.setOpaque(false);
		comboBoxTipologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxTipologia.getSelectedItem()=="Ortofrutta") {
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
				else if(comboBoxTipologia.getSelectedItem()=="Latticini") {
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
				else if(comboBoxTipologia.getSelectedItem()=="Confezionati") {
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
				
				}else if(comboBoxTipologia.getSelectedItem()=="Farinacei") {
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
					
				}else if(comboBoxTipologia.getSelectedItem()=="Uova") {
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
		});
		comboBoxTipologia.setFocusable(false);
		AccessibleContext ac = comboBoxTipologia.getAccessibleContext();
		BasicComboPopup pop = (BasicComboPopup) ac.getAccessibleChild(0);
		JList<?> list = pop.getList();
		list.setSelectionForeground(new Color(191, 215, 255));
		list.setSelectionBackground(new Color(0, 41, 82));	
		comboBoxTipologia.setModel(new DefaultComboBoxModel(new String[] {"Ortofrutta", "Latticini", "Confezionati", "Farinacei", "Uova"}));
		comboBoxTipologia.setBackground(new Color(191,215,255));
		comboBoxTipologia.setForeground(new Color(0, 41, 82));
		comboBoxTipologia.setFont(new Font("Impact", Font.PLAIN, 11));
		comboBoxTipologia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxTipologia.setBorder(new RoundedCornerBorder());
		comboBoxTipologia.setMaximumRowCount(3);
		comboBoxTipologia.setBounds(340, 29, 275, 25);
		getContentPane().add(comboBoxTipologia);
		
		JTextField textFieldFoto = new JTextField(20) ;
		textFieldFoto.setFont(new Font("Impact", Font.PLAIN, 14));
		textFieldFoto.setBorder(new RoundedCornerBorder());
		textFieldFoto.setBackground(new Color(191,215,255));
		textFieldFoto.setForeground(new Color(0,41,82));
		textFieldFoto.setColumns(10);
		textFieldFoto.setBounds(340, 263, 254, 25);
		textFieldFoto.setCaretColor(new Color(0, 41, 82));
		getContentPane().add(textFieldFoto);
		
		JButton ButtonAggiugni = new JButton("");
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
		ButtonAggiugni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				if (comboBoxTipologia.getSelectedItem()=="Ortofrutta") {
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
						ctrl.RimuoviTutto(textFieldNome, textFieldPrezzo, spinnerQuantita, textFieldFoto, dateChooserScadenza, dateChooserRaccolta, 
								dateChooserProduzione, dateChooserMungitura, dateChooserConfezionamento, dateChooserDeposizione);
					}
				}
				else if(comboBoxTipologia.getSelectedItem()=="Latticini") {
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
						ctrl.RimuoviTutto(textFieldNome, textFieldPrezzo, spinnerQuantita, textFieldFoto, dateChooserScadenza, dateChooserRaccolta, 
								dateChooserProduzione, dateChooserMungitura, dateChooserConfezionamento, dateChooserDeposizione);
					}
				}
				else if(comboBoxTipologia.getSelectedItem()=="Confezionati") {
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
						ctrl.RimuoviTutto(textFieldNome, textFieldPrezzo, spinnerQuantita, textFieldFoto, dateChooserScadenza, dateChooserRaccolta,
								dateChooserProduzione, dateChooserMungitura, dateChooserConfezionamento, dateChooserDeposizione);
					}
				}else if(comboBoxTipologia.getSelectedItem()=="Farinacei") {
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
						ctrl.RimuoviTutto(textFieldNome, textFieldPrezzo, spinnerQuantita, textFieldFoto, dateChooserScadenza, dateChooserRaccolta, 
								dateChooserProduzione, dateChooserMungitura, dateChooserConfezionamento, dateChooserDeposizione);
					}
				}else if(comboBoxTipologia.getSelectedItem()=="Uova") {
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
						ctrl.RimuoviTutto(textFieldNome, textFieldPrezzo, spinnerQuantita, textFieldFoto, dateChooserScadenza, dateChooserRaccolta, 
								dateChooserProduzione, dateChooserMungitura, dateChooserConfezionamento, dateChooserDeposizione);
					}
				}
			}
		});
		ButtonAggiugni.setBounds(505, 441, 110, 24);
		getContentPane().add(ButtonAggiugni);
		
		JButton ButtonRimuoviTutto = new JButton("");
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
		ButtonRimuoviTutto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "TUTTI I CAMPI VERRANNO CANCELLATI", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);
				setAlwaysOnTop(true);
				ctrl.RimuoviTutto(textFieldNome, textFieldPrezzo, spinnerQuantita, textFieldFoto, dateChooserScadenza, dateChooserRaccolta, 
						dateChooserProduzione, dateChooserMungitura, dateChooserConfezionamento, dateChooserDeposizione);
			}
		});
		ButtonRimuoviTutto.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
		ButtonRimuoviTutto.setOpaque(false);
		ButtonRimuoviTutto.setBorder(null);
		ButtonRimuoviTutto.setContentAreaFilled(false);
		ButtonRimuoviTutto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonRimuoviTutto.setBounds(345, 441, 150, 24);
		getContentPane().add(ButtonRimuoviTutto);
		
		JButton ButtonAnnulla = new JButton("");
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
		ButtonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ButtonAnnulla.setOpaque(false);
		ButtonAnnulla.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAnnulla.setBorder(null);
		ButtonAnnulla.setContentAreaFilled(false);
		ButtonAnnulla.setBounds(106, 441, 110, 24);
		getContentPane().add(ButtonAnnulla);
		
		JButton ButtonAggiungiFoto = new JButton("...");
		ButtonAggiungiFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAlwaysOnTop(false);
				ctrl.CaricaFileJPGDaPC(textFieldFoto);
				setAlwaysOnTop(true);

			}
		});
		ButtonAggiungiFoto.setBounds(595, 266, 20, 20);
		getContentPane().add(ButtonAggiungiFoto);
		
		JLabel LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/Sfondo.png")));
		LabelSfondo.setBounds(-8, -8, 727, 536);
		getContentPane().add(LabelSfondo);
	}
}
