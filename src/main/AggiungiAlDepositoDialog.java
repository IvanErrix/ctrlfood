package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class AggiungiAlDepositoDialog extends JDialog {
	private JTextField textFieldNome;
	private JTextField textFieldPrezzo;
	private JTextField textFieldDataScadenza;
	private JTextField textFieldQuantita;

	public AggiungiAlDepositoDialog() {
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
		
		JLabel lblQuantit = new JLabel("Quantit\u00E0");
		lblQuantit.setForeground(new Color(255, 213, 0));
		lblQuantit.setFont(new Font("Impact", Font.PLAIN, 16));
		lblQuantit.setBounds(10, 240, 68, 14);
		getContentPane().add(lblQuantit);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldNome.setForeground(new Color(255, 213, 0));
		textFieldNome.setOpaque(false);
		textFieldNome.setBounds(220, 17, 267, 30);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldPrezzo = new JTextField();
		textFieldPrezzo.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldPrezzo.setOpaque(false);
		textFieldPrezzo.setForeground(new Color(255, 213, 0));
		textFieldPrezzo.setColumns(10);
		textFieldPrezzo.setBounds(220, 86, 267, 30);
		getContentPane().add(textFieldPrezzo);
		
		textFieldDataScadenza = new JTextField();
		textFieldDataScadenza.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldDataScadenza.setOpaque(false);
		textFieldDataScadenza.setForeground(new Color(255, 213, 0));
		textFieldDataScadenza.setColumns(10);
		textFieldDataScadenza.setBounds(220, 155, 267, 30);
		getContentPane().add(textFieldDataScadenza);
		
		textFieldQuantita = new JTextField();
		textFieldQuantita.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldQuantita.setOpaque(false);
		textFieldQuantita.setForeground(new Color(255, 213, 0));
		textFieldQuantita.setColumns(10);
		textFieldQuantita.setBounds(220, 224, 267, 30);
		getContentPane().add(textFieldQuantita);
		
		JButton ButtonAggiugni = new JButton("");
		ButtonAggiugni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiugni.setOpaque(false);
		ButtonAggiugni.setBorder(null);
		ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi.png")));
		ButtonAggiugni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ButtonAggiugni.setBounds(446, 344, 141, 30);
		getContentPane().add(ButtonAggiugni);
		
		JButton ButtonCancellaTutto = new JButton("");
		ButtonCancellaTutto.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
		ButtonCancellaTutto.setOpaque(false);
		ButtonCancellaTutto.setBorder(null);
		ButtonCancellaTutto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonCancellaTutto.setBounds(268, 344, 168, 30);
		getContentPane().add(ButtonCancellaTutto);
		
		JButton ButtonAnnulla = new JButton("");
		ButtonAnnulla.setOpaque(false);
		ButtonAnnulla.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAnnulla.setBorder(null);
		ButtonAnnulla.setBounds(39, 344, 141, 30);
		getContentPane().add(ButtonAnnulla);
		setBounds(100, 100, 623, 463);
	}
}
