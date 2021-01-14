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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AggiungiAlNegozioDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public AggiungiAlNegozioDialog(Controller ctrl) {
		setUndecorated(true);
		setSize(623, 463);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setBackground(new Color(0, 67, 137));
		getContentPane().setLayout(null);
		
		JLabel LabelNome = new JLabel("Nome");
		LabelNome.setForeground(new Color(255, 213, 0));
		LabelNome.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelNome.setBounds(10, 120, 46, 14);
		getContentPane().add(LabelNome);
		
		JLabel lblQuantita = new JLabel("Quantit\u00E0");
		lblQuantita.setForeground(new Color(255, 213, 0));
		lblQuantita.setFont(new Font("Impact", Font.PLAIN, 16));
		lblQuantita.setBounds(10, 194, 68, 14);
		getContentPane().add(lblQuantita);
		
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
		ButtonAggiugni.setBounds(379, 344, 141, 30);
		getContentPane().add(ButtonAggiugni);
		
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
		ButtonAnnulla.setBounds(104, 344, 141, 30);
		getContentPane().add(ButtonAnnulla);
		
		JComboBox comboBoxNome = new JComboBox();
		comboBoxNome.setFocusable(false);
		comboBoxNome.setBounds(220, 104, 267, 30);
		getContentPane().add(comboBoxNome);
		
		JComboBox comboBoxQuantita = new JComboBox();
		comboBoxQuantita.setFocusable(false);
		comboBoxQuantita.setBounds(220, 178, 267, 30);
		getContentPane().add(comboBoxQuantita);
	}
}
