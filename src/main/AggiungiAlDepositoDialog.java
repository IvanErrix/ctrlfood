package main;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;

public class AggiungiAlDepositoDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public AggiungiAlDepositoDialog(Controller ctrl) {
		setUndecorated(true);
		setSize(726, 553);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setBackground(new Color(0, 67, 137));
		getContentPane().setLayout(null);
		((JComponent) getContentPane()).setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		
		JLabel LabelTipologia = new JLabel("Tipologia");
		LabelTipologia.setForeground(new Color(255, 213, 0));
		LabelTipologia.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelTipologia.setBounds(107, 37, 92, 21);
		getContentPane().add(LabelTipologia);
		
		JLabel LabelNome = new JLabel("Nome");
		LabelNome.setForeground(new Color(255, 213, 0));
		LabelNome.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelNome.setBounds(107, 101, 46, 14);
		getContentPane().add(LabelNome);
		
		JLabel LabelPrezzo = new JLabel("Prezzo");
		LabelPrezzo.setForeground(new Color(255, 213, 0));
		LabelPrezzo.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelPrezzo.setBounds(107, 170, 46, 14);
		getContentPane().add(LabelPrezzo);
		
		JLabel LabelDataScadenza = new JLabel("Data Scadenza");
		LabelDataScadenza.setForeground(new Color(255, 213, 0));
		LabelDataScadenza.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelDataScadenza.setBounds(107, 233, 118, 14);
		getContentPane().add(LabelDataScadenza);
		
		JLabel LabelQuantita = new JLabel("Quantit\u00E0");
		LabelQuantita.setForeground(new Color(255, 213, 0));
		LabelQuantita.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelQuantita.setBounds(107, 308, 68, 14);
		getContentPane().add(LabelQuantita);
		
		JComboBox comboBoxTipologia = new JComboBox();
		comboBoxTipologia.setFocusable(false);
		comboBoxTipologia.setOpaque(false);
		comboBoxTipologia.setModel(new DefaultComboBoxModel(new String[] {"Ortofrutta", "Latticini", "Confezionati"}));
		comboBoxTipologia.setBackground(new Color(10, 67, 137));
		comboBoxTipologia.setForeground(new Color(255, 213, 0));
		comboBoxTipologia.setFont(new Font("Impact", Font.PLAIN, 11));
		comboBoxTipologia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxTipologia.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 213, 0), new Color(255, 213, 0)));
		comboBoxTipologia.setMaximumRowCount(3);
		comboBoxTipologia.setBounds(317, 25, 267, 30);
		getContentPane().add(comboBoxTipologia);
		
		JTextField textFieldNome = new JTextField();
		textFieldNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
			    if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
			        e.consume();
			}
		});
		
		
		
		textFieldNome.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldNome.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldNome.setForeground(new Color(255, 213, 0));
		textFieldNome.setOpaque(false);
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(317, 85, 267, 30);
		textFieldNome.setCaretColor(new Color(255, 213, 0));
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
		textFieldPrezzo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldPrezzo.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldPrezzo.setOpaque(false);
		textFieldPrezzo.setForeground(new Color(255, 213, 0));
		textFieldPrezzo.setColumns(10);
		textFieldPrezzo.setBounds(317, 154, 267, 30);
		textFieldPrezzo.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldPrezzo);
		
		JFormattedTextField textFieldDataScadenza = new JFormattedTextField();
		try {
			MaskFormatter mf = new MaskFormatter("####-##-##");
			textFieldDataScadenza = new JFormattedTextField(mf);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		textFieldDataScadenza.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldDataScadenza.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldDataScadenza.setOpaque(false);
		textFieldDataScadenza.setForeground(new Color(255, 213, 0));
		textFieldDataScadenza.setColumns(10);
		textFieldDataScadenza.setBounds(317, 223, 267, 30);
		textFieldDataScadenza.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldDataScadenza);
		
		JSpinner spinnerQuantita = new JSpinner();
		spinnerQuantita.setOpaque(false);
		spinnerQuantita.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color (255, 213, 0)));
		spinnerQuantita.setBackground(new Color(0, 67, 137));
		spinnerQuantita.setRequestFocusEnabled(false);
		spinnerQuantita.setModel(new SpinnerNumberModel(1, null, 50, 1));
		spinnerQuantita.setForeground(new Color(255, 213, 0));
		spinnerQuantita.setFont(new Font("Impact", Font.PLAIN, 11));
		spinnerQuantita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		spinnerQuantita.setBounds(317, 292, 59, 30);
		getContentPane().add(spinnerQuantita);
		
		JButton ButtonAggiugni = new JButton("");
		ButtonAggiugni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungiYellow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi.png")));
			}
		});
		ButtonAggiugni.setPressedIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi.png")));
		ButtonAggiugni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiugni.setOpaque(false);
		ButtonAggiugni.setBorder(null);
		ButtonAggiugni.setContentAreaFilled(false);
		ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi.png")));
		ButtonAggiugni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNome.getText().length()==0 || textFieldPrezzo.getText().length()==0 /*|| textFieldQuantita.getText().length()==0*/) {
					JOptionPane.showMessageDialog(null, "COMPLETARE TUTTI I CAMPI", "", JOptionPane.WARNING_MESSAGE);
				}
				else{
					try {
						Double.parseDouble(textFieldPrezzo.getText());
						//Integer.parseInt(textFieldQuantita.getText());
						JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "COMPLETARE TUTTI I CAMPI CON I VALORI CORRETTI", "", JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		ButtonAggiugni.setBounds(532, 480, 141, 30);
		getContentPane().add(ButtonAggiugni);
		
		JButton ButtonCancellaTutto = new JButton("");
		ButtonCancellaTutto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonCancellaTutto.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTuttoYellow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonCancellaTutto.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
			}
		});
		ButtonCancellaTutto.setPressedIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
		ButtonCancellaTutto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "TUTTI I CAMPI VERRANNO CANCELLATI", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);
				textFieldNome.setText("");
				textFieldPrezzo.setText("");
				//textFieldQuantita.setText("");
			}
		});
		ButtonCancellaTutto.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
		ButtonCancellaTutto.setOpaque(false);
		ButtonCancellaTutto.setBorder(null);
		ButtonCancellaTutto.setContentAreaFilled(false);
		ButtonCancellaTutto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonCancellaTutto.setBounds(354, 480, 168, 30);
		getContentPane().add(ButtonCancellaTutto);
		
		JButton ButtonAnnulla = new JButton("");
		ButtonAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAnnulla.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAnnullaYellow.png")));
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
		ButtonAnnulla.setBounds(43, 480, 141, 30);
		getContentPane().add(ButtonAnnulla);
		
		
		
//		JTextField textFieldQuantita = new JTextField();
//		textFieldQuantita.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyTyped(KeyEvent e) {
//				char c=e.getKeyChar();
//			    if(!(Character.isDigit(c) ||  (c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
//			        e.consume();
//			}
//		});
//		textFieldQuantita.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
//		textFieldQuantita.setFont(new Font("Impact", Font.PLAIN, 11));
//		textFieldQuantita.setOpaque(false);
//		textFieldQuantita.setForeground(new Color(255, 213, 0));
//		textFieldQuantita.setColumns(10);
//		textFieldQuantita.setBounds(220, 291, 267, 30);
//		textFieldQuantita.setCaretColor(new Color(255, 213, 0));
//		getContentPane().add(textFieldQuantita);

		
//		JTextField textFieldDataScadenza = new JTextField();
//		textFieldDataScadenza.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusGained(FocusEvent e) {
//				if(textFieldDataScadenza.getText().equals("YYYY-MM-GG")) {
//					textFieldDataScadenza.setText("");
//				}
//			}
//			@Override
//			public void focusLost(FocusEvent e) {
//				if(textFieldDataScadenza.getText().equals("")) {
//					textFieldDataScadenza.setText("YYYY-MM-GG");
//				}
//			}
//		});
//		textFieldDataScadenza.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyTyped(KeyEvent e) {
//				if (textFieldDataScadenza.getText().length()<10) {
//					char c = e.getKeyChar();
//					if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_MINUS))
//						e.consume();
//				}
//				else {
//					char c = e.getKeyChar();
//					if ((c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) { 
//						textFieldDataScadenza.setText("");
//					}
//					else {
////						if((c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE))
//							e.consume();
//					}
//				}
//			}
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if(textFieldDataScadenza.getText().length()==4 || textFieldDataScadenza.getText().length()==7) {
//					textFieldDataScadenza.setText(textFieldDataScadenza.getText()+"-");
//				}
//			}
//		});
//		textFieldDataScadenza.setText("YYYY-MM-GG");
//		textFieldDataScadenza.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
//		textFieldDataScadenza.setFont(new Font("Impact", Font.PLAIN, 11));
//		textFieldDataScadenza.setOpaque(false);
//		textFieldDataScadenza.setForeground(new Color(255, 213, 0));
//		textFieldDataScadenza.setColumns(10);
//		textFieldDataScadenza.setBounds(220, 155, 267, 30);
//		textFieldDataScadenza.setCaretColor(new Color(255, 213, 0));
//		getContentPane().add(textFieldDataScadenza);
	}
}
