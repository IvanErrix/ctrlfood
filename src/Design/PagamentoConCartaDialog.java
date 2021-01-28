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

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import main.Controller;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.Properties;
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
		setAlwaysOnTop(true);

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
		textFieldNumeroCarta.setBounds(146, 28, 269, 30);
		textFieldNumeroCarta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldNumeroCarta.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldNumeroCarta.setOpaque(false);
		textFieldNumeroCarta.setForeground(new Color(255, 213, 0));
		textFieldNumeroCarta.setColumns(10);
		textFieldNumeroCarta.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldNumeroCarta);
		

		passwordFieldPin = new JPasswordField();
		passwordFieldPin.setBounds(146, 84, 234, 30);
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

		
		Properties p = new Properties();
		UtilDateModel model = new UtilDateModel();
		p.put("text.today", "Oggi");
		p.put("text.month", "Mese");
		p.put("text.year", "Anno");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePickerScadenza = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePickerScadenza.getJFormattedTextField().setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		datePickerScadenza.getJFormattedTextField().setForeground(new Color(255, 213, 0));
		datePickerScadenza.getJFormattedTextField().setFont(new Font("Impact", Font.PLAIN, 14));
		datePickerScadenza.getJFormattedTextField().setBackground(new Color(0, 67, 137));
		datePickerScadenza.setLocation(146, 140);
		datePickerScadenza.setSize(267, 30);
		datePickerScadenza.setVisible(true);
		getContentPane().add(datePickerScadenza);

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
				if(textFieldNumeroCarta.getText().equals("") || passwordFieldPin.getText().equals("") ||datePickerScadenza.getJFormattedTextField().getValue().equals("YYYY-MM-GG") ) {
					setAlwaysOnTop(false);
					JOptionPane.showMessageDialog(null, "COMPLETARE TUTTI I CAMPI", "", JOptionPane.WARNING_MESSAGE);
					setAlwaysOnTop(true);
				}
				else {
					if (passwordFieldPin.getText().length()<5 || textFieldNumeroCarta.getText().replace("-", "").length()==0) {
						setAlwaysOnTop(false);
						JOptionPane.showMessageDialog(null, "IL PIN DEVE CONTENERE 5 NUMERI E IL NUMERO DELLA CARTA NE DEVE CONTENERE 16", "", JOptionPane.ERROR_MESSAGE);
						setAlwaysOnTop(true);
					}
					else {
						setAlwaysOnTop(false);
						JOptionPane.showMessageDialog(null, "PAGAMENTO AVVENUTO CON SUCCESSO", "", JOptionPane.INFORMATION_MESSAGE);
						setAlwaysOnTop(true);
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
		textFieldNumeroCartaFedelta.setBounds(146, 194, 269, 30);
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
