package main;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField.AbstractFormatter;

import java.awt.Button;
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
import javax.swing.text.DateFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PagamentoConCartaDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JTextField textFieldNumeroCarta;
	private JPasswordField passwordFieldPin;
	private boolean visible=false;
	private JTextField textFieldScadenza;
	
	public PagamentoConCartaDialog(Controller ctrl) {
		
		getContentPane().setBackground(new Color(0, 67, 137));
		setUndecorated(true);
		setSize(450, 300);
		getContentPane().setLayout(null);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		
		JButton ButtonVediPassword = new JButton("");
		ButtonVediPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(visible==false) {
					visible=true;
					ButtonVediPassword.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonUnviewPassword.png")));
					passwordFieldPin.setEchoChar((char) 0);
				}
				else if(visible==true) {
					visible=false;
					ButtonVediPassword.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonViewPassword.png")));
					passwordFieldPin.setEchoChar('●');
				}
			}
		});
		ButtonVediPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonVediPassword.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonViewPassword.png")));
		ButtonVediPassword.setBorder(null);
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
		passwordFieldPin.setBounds(146, 84, 234, 32);
		passwordFieldPin.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(passwordFieldPin);
		
		textFieldScadenza = new JTextField();
		textFieldScadenza.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textFieldScadenza.getText().equals("YYYY-MM-GG")) {
					textFieldScadenza.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textFieldScadenza.getText().equals("")) {
					textFieldScadenza.setText("YYYY-MM-GG");
				}
			}
		});
		textFieldScadenza.setText("YYYY-MM-GG");
		textFieldScadenza.setForeground(new Color(255, 213, 0));
		textFieldScadenza.setFont(new Font("Impact", Font.PLAIN, 15));
		textFieldScadenza.setColumns(10);
		textFieldScadenza.setCaretColor(new Color(255, 213, 0));
		textFieldScadenza.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldScadenza.setBackground(new Color(0, 67, 137));
		textFieldScadenza.setBounds(146, 140, 269, 32);
		getContentPane().add(textFieldScadenza);
		
		JButton ButtonPaga = new JButton("");
		ButtonPaga.setPressedIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonPagaYellow.png")));
		ButtonPaga.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonPaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNumeroCarta.getText().equals("") || passwordFieldPin.getText().equals("") || textFieldScadenza.getText().equals("YYYY-MM-GG") ) {
					JOptionPane.showMessageDialog(null, "DEVONO ESSERE INSERITI TUTTI I CAMPI", "", JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "PAGAMENTO AVVENUTO CON SUCCESSO", "", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}

			}
		});
		ButtonPaga.setOpaque(false);
		ButtonPaga.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonPaga2.png")));
		ButtonPaga.setBounds(262, 243, 141, 30);
		ButtonPaga.setBorder(null);
		ButtonPaga.setContentAreaFilled(false);
		getContentPane().add(ButtonPaga);
		
		JButton ButtonAnnulla = new JButton("");
		ButtonAnnulla.setPressedIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonAnnullaYellow.png")));
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
		ButtonAnnulla.setBounds(39, 243, 141, 30);
		getContentPane().add(ButtonAnnulla);
	}
}
