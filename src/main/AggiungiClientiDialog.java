package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AggiungiClientiDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public AggiungiClientiDialog(Controller ctrl) {
		
		setAlwaysOnTop(true);
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
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setForeground(new Color(255, 213, 0));
		lblCognome.setFont(new Font("Impact", Font.PLAIN, 16));
		lblCognome.setBounds(10, 102, 68, 14);
		getContentPane().add(lblCognome);
		
		JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
		lblCodiceFiscale.setForeground(new Color(255, 213, 0));
		lblCodiceFiscale.setFont(new Font("Impact", Font.PLAIN, 16));
		lblCodiceFiscale.setBounds(10, 165, 118, 14);
		getContentPane().add(lblCodiceFiscale);
		
		JTextField textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldNome.setForeground(new Color(255, 213, 0));
		textFieldNome.setOpaque(false);
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(220, 17, 267, 30);
		textFieldNome.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldNome);
		
		JTextField textFieldCognome = new JTextField();
		textFieldCognome.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldCognome.setOpaque(false);
		textFieldCognome.setForeground(new Color(255, 213, 0));
		textFieldCognome.setColumns(10);
		textFieldCognome.setBounds(220, 86, 267, 30);
		textFieldCognome.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldCognome);
		
		JTextField textFieldCodiceFiscale = new JTextField();
		textFieldCodiceFiscale.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldCodiceFiscale.setOpaque(false);
		textFieldCodiceFiscale.setForeground(new Color(255, 213, 0));
		textFieldCodiceFiscale.setColumns(10);
		textFieldCodiceFiscale.setBounds(220, 155, 267, 30);
		textFieldCodiceFiscale.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldCodiceFiscale);
		
		JButton ButtonAggiugni = new JButton("");
		ButtonAggiugni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiugni.setOpaque(false);
		ButtonAggiugni.setBorder(null);
		ButtonAggiugni.setContentAreaFilled(false);
		ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi.png")));
		ButtonAggiugni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ButtonAggiugni.setBounds(446, 344, 141, 30);
		getContentPane().add(ButtonAggiugni);
		
		JButton ButtonCancellaTutto = new JButton("");
		ButtonCancellaTutto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNome.setText("");
				textFieldCognome.setText("");
				textFieldCodiceFiscale.setText("");
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
