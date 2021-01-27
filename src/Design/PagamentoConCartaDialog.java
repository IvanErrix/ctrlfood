package Design;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import main.Controller;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;

public class PagamentoConCartaDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPasswordField passwordFieldPin;
	private boolean visible=false;
	private JTextField textFieldNumeroCartaFedelta;

	public PagamentoConCartaDialog(Controller ctrl) {

		getContentPane().setBackground(new Color(0, 67, 137));
		setUndecorated(true);
		setSize(490, 330);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		((JComponent) getContentPane()).setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));

		JButton ButtonVediPassword = new JButton("");
		ButtonVediPassword.setBounds(383, 84, 32, 32);
		ButtonVediPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(visible==false) {
					visible=true;
					ButtonVediPassword.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonUnviewPassword.png")));
					passwordFieldPin.setEchoChar((char) 0);
					passwordFieldPin.setFont(new Font("Impact", Font.PLAIN, 15));
				}
				else if(visible==true) {
					visible=false;
					ButtonVediPassword.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonViewPassword.png")));
					passwordFieldPin.setEchoChar('●');
					passwordFieldPin.setFont(new Font("Impact", Font.PLAIN, 15));
				}
			}
		});
		getContentPane().setLayout(null);
		ButtonVediPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonVediPassword.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonViewPassword.png")));
		ButtonVediPassword.setBorder(null);
		ButtonVediPassword.setContentAreaFilled(false);
		getContentPane().add(ButtonVediPassword);
		
		JLabel LabelFormatoData = new JLabel(" Data : AAAA-MM-GG");
		LabelFormatoData.setVisible(false);
		LabelFormatoData.setForeground(new Color(0, 67, 137));
		LabelFormatoData.setOpaque(true);
		LabelFormatoData.setFont(new Font("Impact", Font.PLAIN, 12));
		LabelFormatoData.setBackground(new Color(255, 213, 0));
		LabelFormatoData.setBounds(383, 96, 97, 39);
		getContentPane().add(LabelFormatoData);
		
		JLabel LabelInfo = new JLabel("");
		LabelInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LabelInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LabelFormatoData.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LabelFormatoData.setVisible(false);
			}
		});
		LabelInfo.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ICOinfoYellow.png")));
		LabelInfo.setBounds(392, 146, 20, 20);
		getContentPane().add(LabelInfo);
		

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
		LabelScadenza.setBounds(10, 152, 70, 20);
		LabelScadenza.setForeground(new Color(255, 213, 0));
		LabelScadenza.setFont(new Font("Impact", Font.PLAIN, 18));
		getContentPane().add(LabelScadenza);

		
		
		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter("####-####-####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		JFormattedTextField textFieldNumeroCarta = new JFormattedTextField(mf);
		textFieldNumeroCarta.setBounds(146, 28, 269, 32);
		textFieldNumeroCarta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldNumeroCarta.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldNumeroCarta.setOpaque(false);
		textFieldNumeroCarta.setForeground(new Color(255, 213, 0));
		textFieldNumeroCarta.setColumns(10);
		textFieldNumeroCarta.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldNumeroCarta);
		

		passwordFieldPin = new JPasswordField();
		passwordFieldPin.setBounds(146, 84, 234, 32);
		passwordFieldPin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(passwordFieldPin.getText().length()<5) {
					char c=e.getKeyChar();
					if(!(Character.isDigit(c) ||  (c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
				}
				else {
					char c=e.getKeyChar();
					if(!((c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
				}

			}
		});
		passwordFieldPin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		passwordFieldPin.setBackground(new Color(0, 67, 137));
		passwordFieldPin.setForeground(new Color(255, 213, 0));
		passwordFieldPin.setFont(new Font("Impact", Font.PLAIN, 15));
		passwordFieldPin.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(passwordFieldPin);

		
		MaskFormatter mf2 = null;
		try {
			mf2 = new MaskFormatter("####-##-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		JFormattedTextField textFieldScadenza = new JFormattedTextField(mf2);
		textFieldScadenza.setBounds(146, 140, 269, 32);
		textFieldScadenza.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldScadenza.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldScadenza.setOpaque(false);
		textFieldScadenza.setForeground(new Color(255, 213, 0));
		textFieldScadenza.setColumns(10);
		textFieldScadenza.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldScadenza);

		JButton ButtonPaga = new JButton("");
		ButtonPaga.setBounds(265, 281, 141, 30);
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
					JOptionPane.showMessageDialog(null, "COMPLETARE TUTTI I CAMPI", "", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if (passwordFieldPin.getText().length()<5 || textFieldNumeroCarta.getText().replace("-", "").length()==0) {
						JOptionPane.showMessageDialog(null, "IL PIN DEVE CONTENERE 5 NUMERI E IL NUMERO DELLA CARTA NE DEVE CONTENERE 16", "", JOptionPane.ERROR_MESSAGE);
					}
					else {
							JOptionPane.showMessageDialog(null, "PAGAMENTO AVVENUTO CON SUCCESSO", "", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} 
					}
				}
		});
		ButtonPaga.setOpaque(false);
		ButtonPaga.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonPaga2.png")));
		ButtonPaga.setBorder(null);
		ButtonPaga.setContentAreaFilled(false);
		getContentPane().add(ButtonPaga);

		JButton ButtonAnnulla = new JButton("");
		ButtonAnnulla.setBounds(43, 279, 141, 30);
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
		getContentPane().add(ButtonAnnulla);

		JLabel LabelNumeroCartaFedelta = new JLabel("N° Carta Fedeltà");
		LabelNumeroCartaFedelta.setBounds(12, 208, 114, 20);
		LabelNumeroCartaFedelta.setForeground(new Color(255, 213, 0));
		LabelNumeroCartaFedelta.setFont(new Font("Impact", Font.PLAIN, 18));
		getContentPane().add(LabelNumeroCartaFedelta);		
		
		textFieldNumeroCartaFedelta = new JTextField();
		textFieldNumeroCartaFedelta.setBounds(146, 194, 269, 32);
		textFieldNumeroCartaFedelta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textFieldNumeroCartaFedelta.getText().length()<4) {
					char c=e.getKeyChar();
					if(!(Character.isDigit(c) ||  (c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
				}
				else {
					char c=e.getKeyChar();
					if(!((c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
				}

			}
		});
		textFieldNumeroCartaFedelta.setForeground(new Color(255, 213, 0));
		textFieldNumeroCartaFedelta.setFont(new Font("Impact", Font.PLAIN, 15));
		textFieldNumeroCartaFedelta.setColumns(10);
		textFieldNumeroCartaFedelta.setCaretColor(new Color(255, 213, 0));
		textFieldNumeroCartaFedelta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldNumeroCartaFedelta.setBackground(new Color(0, 67, 137));
		getContentPane().add(textFieldNumeroCartaFedelta);
	}
}
