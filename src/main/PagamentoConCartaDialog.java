package main;

import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PagamentoConCartaDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JTextField textFieldNumeroCarta;
	private JPasswordField passwordFieldPin;
	
	public PagamentoConCartaDialog(Controller ctrl) {
		
		getContentPane().setBackground(new Color(0, 67, 137));
		setUndecorated(true);
		setSize(450, 300);
		getContentPane().setLayout(null);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		
		JButton ButtonVediPassword = new JButton("");
		ButtonVediPassword.setSelectedIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonViewPassord.png")));
		ButtonVediPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonVediPassword.setBorder(null);
		ButtonVediPassword.setOpaque(false);
		ButtonVediPassword.setContentAreaFilled(false);
		ButtonVediPassword.setBounds(383, 84, 32, 32);
		getContentPane().add(ButtonVediPassword);
		
		JLabel LabelNumeroCarta = new JLabel("Numero Carta");
		LabelNumeroCarta.setBounds(10, 40, 115, 20);
		LabelNumeroCarta.setForeground(new Color(255, 213, 0));
		LabelNumeroCarta.setFont(new Font("Impact", Font.PLAIN, 18));
		getContentPane().add(LabelNumeroCarta);
		
		JLabel LabelPin = new JLabel("Pin");
		LabelPin.setBounds(10, 96, 70, 20);
		LabelPin.setForeground(new Color(255, 213, 0));
		LabelPin.setFont(new Font("Impact", Font.PLAIN, 18));
		getContentPane().add(LabelPin);
		
		JLabel LabelScadenza = new JLabel("Scadenza");
		LabelScadenza.setForeground(new Color(255, 213, 0));
		LabelScadenza.setFont(new Font("Impact", Font.PLAIN, 18));
		LabelScadenza.setBounds(10, 152, 70, 20);
		getContentPane().add(LabelScadenza);
		
		textFieldNumeroCarta = new JTextField();
		textFieldNumeroCarta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldNumeroCarta.setBackground(new Color(0, 67, 137));
		textFieldNumeroCarta.setForeground(new Color(255, 213, 0));
		textFieldNumeroCarta.setFont(new Font("Impact", Font.PLAIN, 15));
		textFieldNumeroCarta.setBounds(146, 28, 269, 32);
		textFieldNumeroCarta.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldNumeroCarta);
		textFieldNumeroCarta.setColumns(10);
		
		passwordFieldPin = new JPasswordField();
		passwordFieldPin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		passwordFieldPin.setBackground(new Color(0, 67, 137));
		passwordFieldPin.setForeground(new Color(255, 213, 0));
		passwordFieldPin.setFont(new Font("Impact", Font.PLAIN, 15));
		passwordFieldPin.setBounds(146, 84, 269, 32);
		passwordFieldPin.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(passwordFieldPin);
		
		JButton ButtonPaga = new JButton("");
		ButtonPaga.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonPaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "PAGAMENTO AVVENUTO CON SUCCESSO", "", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		ButtonPaga.setOpaque(false);
		ButtonPaga.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonPaga.png")));
		ButtonPaga.setBounds(166, 243, 105, 25);
		ButtonPaga.setBorder(null);
		ButtonPaga.setContentAreaFilled(false);
		getContentPane().add(ButtonPaga);
	}
}
