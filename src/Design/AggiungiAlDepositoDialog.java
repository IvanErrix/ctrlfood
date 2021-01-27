package Design;

import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import main.Controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import java.util.Properties;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AggiungiAlDepositoDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public AggiungiAlDepositoDialog(Controller ctrl) {
		setUndecorated(true);
		setSize(680, 490);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setBackground(new Color(0, 67, 137));
		getContentPane().setLayout(null);
//		((JComponent) getContentPane()).setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		
		
		JLabel LabelTipologia = new JLabel("Tipologia");
		LabelTipologia.setForeground(new Color(0, 41, 82));
		LabelTipologia.setFont(new Font("Impact", Font.PLAIN, 14));
		LabelTipologia.setBounds(133, 71, 92, 14);
		getContentPane().add(LabelTipologia);
		
		JLabel LabelNome = new JLabel("Nome");
		LabelNome.setForeground(new Color(0, 41, 82));
		LabelNome.setFont(new Font("Impact", Font.PLAIN, 14));
		LabelNome.setBounds(133, 104, 46, 14);
		getContentPane().add(LabelNome);
		
		JLabel LabelPrezzo = new JLabel("Prezzo");
		LabelPrezzo.setForeground(new Color(0, 41, 82));
		LabelPrezzo.setFont(new Font("Impact", Font.PLAIN, 14));
		LabelPrezzo.setBounds(133, 131, 46, 14);
		getContentPane().add(LabelPrezzo);
		
		JLabel LabelDataScadenza = new JLabel("Data Scadenza");
		LabelDataScadenza.setForeground(new Color(0, 41, 82));
		LabelDataScadenza.setFont(new Font("Impact", Font.PLAIN, 14));
		LabelDataScadenza.setBounds(133, 168, 118, 14);
		getContentPane().add(LabelDataScadenza);
		
		JLabel LabelQuantita = new JLabel("Quantit\u00E0");
		LabelQuantita.setForeground(new Color(0, 41, 82));
		LabelQuantita.setFont(new Font("Impact", Font.PLAIN, 14));
		LabelQuantita.setBounds(133, 199, 68, 14);
		getContentPane().add(LabelQuantita);
		
		JLabel LabelDataRaccolta = new JLabel("Data Raccolto");
		LabelDataRaccolta.setVisible(true);
		LabelDataRaccolta.setForeground(new Color(0, 41, 82));
		LabelDataRaccolta.setFont(new Font("Impact", Font.PLAIN, 14));
		LabelDataRaccolta.setBounds(133, 260, 118, 14);
		getContentPane().add(LabelDataRaccolta);
		
		JLabel LabelDataProduzione = new JLabel("Data Produzione");
		LabelDataProduzione.setVisible(false);
		LabelDataProduzione.setForeground(new Color(0, 41, 82));
		LabelDataProduzione.setFont(new Font("Impact", Font.PLAIN, 14));
		LabelDataProduzione.setBounds(133, 260, 118, 14);
		getContentPane().add(LabelDataProduzione);
		
		JLabel LabelDataMungitura = new JLabel("Data Mungitura");
		LabelDataMungitura.setVisible(false);
		LabelDataMungitura.setForeground(new Color(0, 41, 82));
		LabelDataMungitura.setFont(new Font("Impact", Font.PLAIN, 14));
		LabelDataMungitura.setBounds(133, 291, 118, 14);
		getContentPane().add(LabelDataMungitura);
		
		JLabel LabelDataConfezionamento = new JLabel("Data Confezionamento");
		LabelDataConfezionamento.setVisible(false);
		LabelDataConfezionamento.setForeground(new Color(0, 41, 82));
		LabelDataConfezionamento.setFont(new Font("Impact", Font.PLAIN, 14));
		LabelDataConfezionamento.setBounds(133, 260, 161, 14);
		getContentPane().add(LabelDataConfezionamento);
		
		JLabel LabelFoto = new JLabel("Foto");
		LabelFoto.setForeground(new Color(0, 41, 82));
		LabelFoto.setFont(new Font("Impact", Font.PLAIN, 14));
		LabelFoto.setBounds(133, 226, 46, 14);
		getContentPane().add(LabelFoto);
		
		JTextField textFieldNome = new JTextField();
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
			    if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
			        e.consume();
			}
		});
		
		
		textFieldNome.setBorder(null);
		textFieldNome.setFont(new Font("Impact", Font.PLAIN, 14));
		textFieldNome.setForeground(new Color(191,215,255));
		textFieldNome.setOpaque(false);
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(312, 98, 177, 20);
		textFieldNome.setCaretColor(new Color(0, 41, 82));
		getContentPane().add(textFieldNome);
		
		
		JTextField textFieldPrezzo = new JTextField();
		textFieldPrezzo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
			    if(!(Character.isDigit(c) ||  (c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD))
			        e.consume();
			}
		});
		textFieldPrezzo.setBorder(null);
		textFieldPrezzo.setFont(new Font("Impact", Font.PLAIN, 14));
		textFieldPrezzo.setOpaque(false);
		textFieldPrezzo.setForeground(new Color(191,215,255));
		textFieldPrezzo.setColumns(10);
		textFieldPrezzo.setBounds(312, 128, 177, 20);
		textFieldPrezzo.setCaretColor(new Color(0, 41, 82));
		getContentPane().add(textFieldPrezzo);
		
		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter("####-##-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		SpinnerNumberModel spinnermodel = new SpinnerNumberModel(1, null, 50, 1);
		JSpinner spinnerQuantita = new JSpinner(spinnermodel);
		spinnerQuantita.setOpaque(false);
		spinnerQuantita.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(191,215,255), new Color (191,215,255)));
		spinnerQuantita.getComponent(0).setBackground(new Color(0, 41, 82));
		spinnerQuantita.getComponent(1).setBackground(new Color(0, 41, 82));
		spinnerQuantita.getEditor().getComponent(0).setBackground(new Color(0, 41, 82));
		spinnerQuantita.getEditor().getComponent(0).setForeground(new Color(191,215,255));
		spinnerQuantita.setRequestFocusEnabled(false);
		spinnerQuantita.setFont(new Font("Impact", Font.PLAIN, 14));
		spinnerQuantita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		spinnerQuantita.setBounds(302, 199, 46, 20);
		getContentPane().add(spinnerQuantita);
		
		Properties p = new Properties();
		UtilDateModel model = new UtilDateModel();
		UtilDateModel model2 = new UtilDateModel();
		UtilDateModel model3 = new UtilDateModel();
		UtilDateModel model4 = new UtilDateModel();
		UtilDateModel model5 = new UtilDateModel();
		p.put("text.today", "Oggi");
		p.put("text.month", "Mese");
		p.put("text.year", "Anno");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
		JDatePanelImpl datePanel3 = new JDatePanelImpl(model3, p);
		JDatePanelImpl datePanel4 = new JDatePanelImpl(model4, p);
		JDatePanelImpl datePanel5 = new JDatePanelImpl(model5, p);
		
		JDatePickerImpl datePickerScadenza = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePickerScadenza.getJFormattedTextField().setBorder(null);
		datePickerScadenza.getJFormattedTextField().setForeground(new Color(191,215,255));
		datePickerScadenza.getJFormattedTextField().setFont(new Font("Impact", Font.PLAIN, 14));
		datePickerScadenza.getJFormattedTextField().setBackground(new Color(0,41,82));
		datePickerScadenza.setLocation(302, 168);
		datePickerScadenza.setSize(190, 20);
		datePickerScadenza.setVisible(true);
		getContentPane().add(datePickerScadenza);
		
		JDatePickerImpl datePickerRaccolta = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		datePickerRaccolta.getJFormattedTextField().setBorder(null);
		datePickerRaccolta.getJFormattedTextField().setForeground(new Color(191,215,255));
		datePickerRaccolta.getJFormattedTextField().setFont(new Font("Impact", Font.PLAIN, 14));
		datePickerRaccolta.getJFormattedTextField().setBackground(new Color(0, 41, 82));
		datePickerRaccolta.setLocation(302, 254);
		datePickerRaccolta.setSize(190, 20);
		datePickerRaccolta.setVisible(true);
		getContentPane().add(datePickerRaccolta);
		
		JDatePickerImpl datePickerProduzione = new JDatePickerImpl(datePanel3, new DateLabelFormatter());
		datePickerProduzione.getJFormattedTextField().setBorder(null);
		datePickerProduzione.getJFormattedTextField().setForeground(new Color(191,215,255));
		datePickerProduzione.getJFormattedTextField().setFont(new Font("Impact", Font.PLAIN, 14));
		datePickerProduzione.getJFormattedTextField().setBackground(new Color(0, 41, 82));
		datePickerProduzione.setLocation(302, 254);
		datePickerProduzione.setSize(190, 20);
		datePickerProduzione.setVisible(false);
		getContentPane().add(datePickerProduzione);
		
		JDatePickerImpl datePickerConfezionamento = new JDatePickerImpl(datePanel4, new DateLabelFormatter());
		datePickerConfezionamento.getJFormattedTextField().setBorder(null);
		datePickerConfezionamento.getJFormattedTextField().setForeground(new Color(191,215,255));
		datePickerConfezionamento.getJFormattedTextField().setFont(new Font("Impact", Font.PLAIN, 14));
		datePickerConfezionamento.getJFormattedTextField().setBackground(new Color(0, 41, 82));
		datePickerConfezionamento.setLocation(302, 254);
		datePickerConfezionamento.setSize(190, 20);
		datePickerConfezionamento.setVisible(false);
		getContentPane().add(datePickerConfezionamento);
		
		JDatePickerImpl datePickerMungitura = new JDatePickerImpl(datePanel5, new DateLabelFormatter());
		datePickerMungitura.getJFormattedTextField().setBorder(null);
		datePickerMungitura.getJFormattedTextField().setForeground(new Color(191,215,255));
		datePickerMungitura.getJFormattedTextField().setFont(new Font("Impact", Font.PLAIN, 14));
		datePickerMungitura.getJFormattedTextField().setBackground(new Color(0, 41, 82));
		datePickerMungitura.setLocation(302, 285);
		datePickerMungitura.setSize(190, 20);
		datePickerMungitura.setVisible(false);
		getContentPane().add(datePickerMungitura);
		
		JComboBox comboBoxTipologia = new JComboBox();
		comboBoxTipologia.setOpaque(false);
		comboBoxTipologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxTipologia.getSelectedItem()=="Ortofrutta") {
					LabelDataConfezionamento.setVisible(false);
					LabelDataRaccolta.setVisible(true);
					LabelDataMungitura.setVisible(false);
					LabelDataProduzione.setVisible(false);
					datePickerConfezionamento.setVisible(false);
					datePickerRaccolta.setVisible(true);
					datePickerMungitura.setVisible(false);
					datePickerProduzione.setVisible(false);
				}
				else if(comboBoxTipologia.getSelectedItem()=="Latticini") {
					LabelDataConfezionamento.setVisible(false);
					LabelDataRaccolta.setVisible(false);
					LabelDataMungitura.setVisible(true);
					LabelDataProduzione.setVisible(true);
					datePickerConfezionamento.setVisible(false);
					datePickerRaccolta.setVisible(false);
					datePickerMungitura.setVisible(true);
					datePickerProduzione.setVisible(true);
				}
				else if(comboBoxTipologia.getSelectedItem()=="Confezionati") {
					LabelDataConfezionamento.setVisible(true);
					LabelDataRaccolta.setVisible(false);
					LabelDataMungitura.setVisible(false);
					LabelDataProduzione.setVisible(false);
					datePickerConfezionamento.setVisible(true);
					datePickerRaccolta.setVisible(false);
					datePickerMungitura.setVisible(false);
					datePickerProduzione.setVisible(false);
				}
			}
		});
		comboBoxTipologia.setFocusable(false);
		comboBoxTipologia.setModel(new DefaultComboBoxModel(new String[] {"Ortofrutta", "Latticini", "Confezionati"}));
		comboBoxTipologia.setBackground(new Color(0,41,82));
		comboBoxTipologia.setForeground(new Color(191,215,255));
		comboBoxTipologia.setFont(new Font("Impact", Font.PLAIN, 11));
		comboBoxTipologia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxTipologia.setBorder(null);
		comboBoxTipologia.setMaximumRowCount(3);
		comboBoxTipologia.setBounds(302, 68, 190, 20);
		getContentPane().add(comboBoxTipologia);
		
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
				if(textFieldNome.getText().length()==0 || textFieldPrezzo.getText().length()==0 ) {
					JOptionPane.showMessageDialog(null, "COMPLETARE TUTTI I CAMPI", "", JOptionPane.WARNING_MESSAGE);
				}
				else{
					if(comboBoxTipologia.getSelectedItem()=="Ortofrutta") {
						String [] parti = datePickerScadenza.getJFormattedTextField().getValue().toString().split("-");
						if(Integer.parseInt(parti[0])<2021 || Integer.parseInt(parti[1])>12 || Integer.parseInt(parti[1])==0 || Integer.parseInt(parti[2])>31 || Integer.parseInt(parti[2])==0) {
							JOptionPane.showMessageDialog(null, "INSERIRE DATA CORRETTA", "", JOptionPane.ERROR_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
							textFieldNome.setText("");
							textFieldPrezzo.setText("");
							spinnerQuantita.setValue(1);
							LabelFoto.setText("");
						}
					}
				}
				
			}
		});
		ButtonAggiugni.setBounds(489, 376, 110, 24);
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
				JOptionPane.showMessageDialog(null, "TUTTI I CAMPI VERRANNO CANCELLATI", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);
				textFieldNome.setText("");
				textFieldPrezzo.setText("");
				spinnerQuantita.setValue(1);
				LabelFoto.setText("");
			}
		});
		ButtonRimuoviTutto.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
		ButtonRimuoviTutto.setOpaque(false);
		ButtonRimuoviTutto.setBorder(null);
		ButtonRimuoviTutto.setContentAreaFilled(false);
		ButtonRimuoviTutto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonRimuoviTutto.setBounds(331, 376, 150, 24);
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
		ButtonAnnulla.setBounds(108, 376, 110, 24);
		getContentPane().add(ButtonAnnulla);
		
		JTextField textFieldFoto = new JTextField();
		textFieldFoto.setBorder(null);
		textFieldFoto.setFont(new Font("Impact", Font.PLAIN, 14));
		textFieldFoto.setForeground(new Color(191,215,255));
		textFieldFoto.setOpaque(false);
		textFieldFoto.setColumns(10);
		textFieldFoto.setBounds(312, 223, 179, 20);
		textFieldFoto.setCaretColor(new Color(0, 41, 82));
		getContentPane().add(textFieldFoto);
		
		JButton ButtonAggiungiFoto = new JButton("...");
		ButtonAggiungiFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CaricaFileJPGDaPC(textFieldFoto);
			}
		});
		ButtonAggiungiFoto.setBounds(525, 228, 25, 30);
		getContentPane().add(ButtonAggiungiFoto);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/Sfondo.png")));
		lblNewLabel.setBounds(72, 0, 598, 480);
		getContentPane().add(lblNewLabel);
		
		JLabel LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/Group 4.png")));
		LabelSfondo.setBounds(0, 0, 680, 490);
		getContentPane().add(LabelSfondo);
	
	}
}
