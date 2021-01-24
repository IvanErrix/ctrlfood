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

public class AggiungiAlDepositoDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public AggiungiAlDepositoDialog(Controller ctrl) {
		setUndecorated(true);
		setSize(623, 463);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setBackground(new Color(0, 67, 137));
		getContentPane().setLayout(null);
		((JComponent) getContentPane()).setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		
		JLabel LabelNome = new JLabel("Nome");
		LabelNome.setForeground(new Color(255, 213, 0));
		LabelNome.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelNome.setBounds(10, 33, 46, 14);
		getContentPane().add(LabelNome);
		
		JLabel lblPrezzo = new JLabel("Prezzo");
		lblPrezzo.setForeground(new Color(255, 213, 0));
		lblPrezzo.setFont(new Font("Impact", Font.PLAIN, 16));
		lblPrezzo.setBounds(10, 102, 46, 14);
		getContentPane().add(lblPrezzo);
		
		JLabel lblDataScadenza = new JLabel("Data Scadenza");
		lblDataScadenza.setForeground(new Color(255, 213, 0));
		lblDataScadenza.setFont(new Font("Impact", Font.PLAIN, 16));
		lblDataScadenza.setBounds(10, 165, 118, 14);
		getContentPane().add(lblDataScadenza);
		
		JLabel lblQuantita = new JLabel("Quantit\u00E0");
		lblQuantita.setForeground(new Color(255, 213, 0));
		lblQuantita.setFont(new Font("Impact", Font.PLAIN, 16));
		lblQuantita.setBounds(10, 240, 68, 14);
		getContentPane().add(lblQuantita);
		
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
		textFieldNome.setBounds(220, 17, 267, 30);
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
		textFieldPrezzo.setBounds(220, 86, 267, 30);
		textFieldPrezzo.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldPrezzo);
		
		JTextField textFieldDataScadenza = new JTextField();
		textFieldDataScadenza.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textFieldDataScadenza.getText().equals("YYYY-MM-GG")) {
					textFieldDataScadenza.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textFieldDataScadenza.getText().equals("")) {
					textFieldDataScadenza.setText("YYYY-MM-GG");
				}
			}
		});
		textFieldDataScadenza.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textFieldDataScadenza.getText().length()<10) {
					char c = e.getKeyChar();
					if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_MINUS))
						e.consume();
				}
				else {
					char c = e.getKeyChar();
					if (!(c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE))
						e.consume();
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(textFieldDataScadenza.getText().length()==4 || textFieldDataScadenza.getText().length()==7) {
					textFieldDataScadenza.setText(textFieldDataScadenza.getText()+"-");
				}
			}
		});
		textFieldDataScadenza.setText("YYYY-MM-GG");
		textFieldDataScadenza.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldDataScadenza.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldDataScadenza.setOpaque(false);
		textFieldDataScadenza.setForeground(new Color(255, 213, 0));
		textFieldDataScadenza.setColumns(10);
		textFieldDataScadenza.setBounds(220, 155, 267, 30);
		textFieldDataScadenza.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldDataScadenza);
		
		JTextField textFieldQuantita = new JTextField();
		textFieldQuantita.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
			    if(!(Character.isDigit(c) ||  (c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
			        e.consume();
			}
		});
		textFieldQuantita.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldQuantita.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldQuantita.setOpaque(false);
		textFieldQuantita.setForeground(new Color(255, 213, 0));
		textFieldQuantita.setColumns(10);
		textFieldQuantita.setBounds(220, 224, 267, 30);
		textFieldQuantita.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldQuantita);
		
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
				if(textFieldNome.getText().length()==0 || textFieldPrezzo.getText().length()==0 || textFieldQuantita.getText().length()==0 || textFieldDataScadenza.getText()=="YYYY-MM-GG") {
					JOptionPane.showMessageDialog(null, "COMPLETARE TUTTI I CAMPI", "", JOptionPane.WARNING_MESSAGE);
				}
				else{
					try {
						Double.parseDouble(textFieldPrezzo.getText());
						Integer.parseInt(textFieldQuantita.getText());
						JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "COMPLETARE TUTTI I CAMPI CON I VALORI CORRETTI", "", JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		ButtonAggiugni.setBounds(446, 344, 141, 30);
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
				textFieldDataScadenza.setText("YYYY-MM-GG");
				textFieldQuantita.setText("");
			}
		});
		ButtonCancellaTutto.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
		ButtonCancellaTutto.setOpaque(false);
		ButtonCancellaTutto.setBorder(null);
		ButtonCancellaTutto.setContentAreaFilled(false);
		ButtonCancellaTutto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonCancellaTutto.setBounds(268, 344, 168, 30);
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
		ButtonAnnulla.setBounds(39, 344, 141, 30);
		getContentPane().add(ButtonAnnulla);
		
//		JFormattedTextField formattedTextField = new JFormattedTextField();
//		try {
//			MaskFormatter mf = new MaskFormatter("##-###-#######");
//			mf.setPlaceholderCharacter('#');
//			formattedTextField = new JFormattedTextField(mf);
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
//		formattedTextField.setBounds(220, 285, 267, 20);
//		getContentPane().add(formattedTextField);
	}
}
