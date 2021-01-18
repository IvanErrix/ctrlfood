package main;

import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AggiungiAlDepositoDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public AggiungiAlDepositoDialog(Controller ctrl) {
		setUndecorated(true);
		setSize(623, 463);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setBackground(new Color(0, 67, 137));
		getContentPane().setLayout(null);
		
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
		textFieldNome.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldNome.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldNome.setForeground(new Color(255, 213, 0));
		textFieldNome.setOpaque(false);
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(220, 17, 267, 30);
		textFieldNome.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldNome);
		
		JTextField textFieldPrezzo = new JTextField();
		textFieldPrezzo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldPrezzo.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldPrezzo.setOpaque(false);
		textFieldPrezzo.setForeground(new Color(255, 213, 0));
		textFieldPrezzo.setColumns(10);
		textFieldPrezzo.setBounds(220, 86, 267, 30);
		textFieldPrezzo.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldPrezzo);
		
		JTextField textFieldDataScadenza = new JTextField();
		textFieldDataScadenza.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldDataScadenza.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldDataScadenza.setOpaque(false);
		textFieldDataScadenza.setForeground(new Color(255, 213, 0));
		textFieldDataScadenza.setColumns(10);
		textFieldDataScadenza.setBounds(220, 155, 267, 30);
		textFieldDataScadenza.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldDataScadenza);
		
		JTextField textFieldQuantita = new JTextField();
		textFieldQuantita.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldQuantita.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldQuantita.setOpaque(false);
		textFieldQuantita.setForeground(new Color(255, 213, 0));
		textFieldQuantita.setColumns(10);
		textFieldQuantita.setBounds(220, 224, 267, 30);
		textFieldQuantita.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldQuantita);
		
		JButton ButtonAggiugni = new JButton("");
		ButtonAggiugni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiugni.setOpaque(false);
		ButtonAggiugni.setBorder(null);
		ButtonAggiugni.setContentAreaFilled(false);
		ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi.png")));
		ButtonAggiugni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		ButtonAggiugni.setBounds(446, 344, 141, 30);
		getContentPane().add(ButtonAggiugni);
		
		JButton ButtonCancellaTutto = new JButton("");
		ButtonCancellaTutto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "TUTTI I CAMPI VERRANNO CANCELLATI", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);
				textFieldNome.setText("");
				textFieldPrezzo.setText("");
				textFieldDataScadenza.setText("");
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
	}
}
