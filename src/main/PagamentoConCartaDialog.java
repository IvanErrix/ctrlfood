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
import javax.swing.KeyStroke;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PagamentoConCartaDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private JTextField textFieldNumeroCarta;
	private JPasswordField passwordFieldPin;
	private boolean visible=false;
	private JTextField textFieldScadenza;
	private JTextField textFieldNumeroCartaFedelta;

	public PagamentoConCartaDialog(Controller ctrl) {

		getContentPane().setBackground(new Color(0, 67, 137));
		setUndecorated(true);
		setSize(490, 330);
		getContentPane().setLayout(null);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		((JComponent) getContentPane()).setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));

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

		JLabel LabelNumeroCarta = new JLabel("N° Carta");
		LabelNumeroCarta.setBounds(10, 40, 76, 20);
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
		textFieldNumeroCarta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(textFieldNumeroCarta.getText().length()>18) {
//					String[] Keys = {"48","KeyEvent.VK_1","KeyEvent.VK_2","KeyEvent.VK_3"};
//					for (String Key : Keys) {
//						textFieldNumeroCarta.getInputMap().put(KeyStroke.getKeyStroke(Key), "none");
//					}
					textFieldNumeroCarta.setEditable(false);
				}
				if (e.getKeyCode() == KeyEvent.VK_0 || e.getKeyCode() == KeyEvent.VK_1
						|| e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_3
						|| e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_5
						|| e.getKeyCode() == KeyEvent.VK_6 || e.getKeyCode() == KeyEvent.VK_7
						|| e.getKeyCode() == KeyEvent.VK_8 || e.getKeyCode() == KeyEvent.VK_9 
						|| e.getKeyCode() == KeyEvent.VK_NUMPAD0 || e.getKeyCode() == KeyEvent.VK_NUMPAD1
						|| e.getKeyCode() == KeyEvent.VK_NUMPAD2 || e.getKeyCode() == KeyEvent.VK_NUMPAD3
						|| e.getKeyCode() == KeyEvent.VK_NUMPAD4 || e.getKeyCode() == KeyEvent.VK_NUMPAD5
						|| e.getKeyCode() == KeyEvent.VK_NUMPAD6 || e.getKeyCode() == KeyEvent.VK_NUMPAD7
						|| e.getKeyCode() == KeyEvent.VK_NUMPAD8 || e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
					if(textFieldNumeroCarta.getText().length()==4 || textFieldNumeroCarta.getText().length()==9 || textFieldNumeroCarta.getText().length()==14) {
						textFieldNumeroCarta.setText(textFieldNumeroCarta.getText()+"-");
					}
				}
			}
		});
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
		ButtonPaga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonPaga.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonPagaYellow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonPaga.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonPaga2.png")));
			}
		});
		ButtonPaga.setPressedIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonPaga2.png")));
		ButtonPaga.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonPaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNumeroCarta.getText().equals("") || passwordFieldPin.getText().equals("") || textFieldScadenza.getText().equals("YYYY-MM-GG") ) {
					JOptionPane.showMessageDialog(null, "DEVONO ESSERE INSERITI TUTTI I CAMPI", "", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if (passwordFieldPin.getText().length()>5 || textFieldNumeroCarta.getText().replace("-", "").length()!=16) {
						JOptionPane.showMessageDialog(null, "IL PIN DEVE CONTENERE 5 NUMERI E IL NUMERO DELLA CARTA NE DEVE CONTENERE 16", "", JOptionPane.ERROR_MESSAGE);
					}
					else {
						try {
							String text = textFieldNumeroCarta.getText().replace("-", "");
							Long.parseLong(text);
							String text2 = textFieldNumeroCartaFedelta.getText();
							Long.parseLong(text2);
							JOptionPane.showMessageDialog(null, "PAGAMENTO AVVENUTO CON SUCCESSO", "", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "INSERIRE CORRETTAMENTE UN NUMERO PER LA CARTA DI CREDITO E PER LA CARTA FEDELTA", "", JOptionPane.ERROR_MESSAGE);
						}
					}
				}

			}
		});
		ButtonPaga.setOpaque(false);
		ButtonPaga.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonPaga2.png")));
		ButtonPaga.setBounds(265, 281, 141, 30);
		ButtonPaga.setBorder(null);
		ButtonPaga.setContentAreaFilled(false);
		getContentPane().add(ButtonPaga);

		JButton ButtonAnnulla = new JButton("");
		ButtonAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAnnulla.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonAnnullaYellow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAnnulla.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
			}
		});
		ButtonAnnulla.setPressedIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
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
		ButtonAnnulla.setBounds(43, 279, 141, 30);
		getContentPane().add(ButtonAnnulla);

		JLabel LabelNumeroCartaFedelta = new JLabel("N° Carta Fedeltà");
		LabelNumeroCartaFedelta.setForeground(new Color(255, 213, 0));
		LabelNumeroCartaFedelta.setFont(new Font("Impact", Font.PLAIN, 18));
		LabelNumeroCartaFedelta.setBounds(12, 208, 114, 20);
		getContentPane().add(LabelNumeroCartaFedelta);

		textFieldNumeroCartaFedelta = new JTextField();
		textFieldNumeroCartaFedelta.setForeground(new Color(255, 213, 0));
		textFieldNumeroCartaFedelta.setFont(new Font("Impact", Font.PLAIN, 15));
		textFieldNumeroCartaFedelta.setColumns(10);
		textFieldNumeroCartaFedelta.setCaretColor(new Color(255, 213, 0));
		textFieldNumeroCartaFedelta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldNumeroCartaFedelta.setBackground(new Color(0, 67, 137));
		textFieldNumeroCartaFedelta.setBounds(146, 194, 269, 32);
		getContentPane().add(textFieldNumeroCartaFedelta);
	}
}
