package Design;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import ExternalClasses.ContentPane;
import Main.Controller;

import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Cursor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginAmministratoreDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private boolean visible=false;

	public LoginAmministratoreDialog(Controller ctrl) {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setSize(355, 467);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setLayout(null);
		ContentPane contentPane = new ContentPane();
		setContentPane(contentPane);
		getContentPane().isOpaque();
		setBackground(new Color(0, 67, 137, 0));
		contentPane.setLayout(null);
		
		JButton ButtonChiudi = new JButton("");
		ButtonChiudi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		ButtonChiudi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonChiudi.setIcon(new ImageIcon(LoginDialog.class.getResource("/scrimg/ButtonChiudiAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonChiudi.setIcon(new ImageIcon(LoginDialog.class.getResource("/scrimg/ButtonChiudi.png")));
			}
		});
		ButtonChiudi.setPressedIcon(new ImageIcon(LoginDialog.class.getResource("/scrimg/ButtonChiudi.png")));
		ButtonChiudi.setFocusable(false);
		ButtonChiudi.setOpaque(false);
		ButtonChiudi.setBorder(null);
		ButtonChiudi.setContentAreaFilled(false);
		ButtonChiudi.setIcon(new ImageIcon(LoginDialog.class.getResource("/scrimg/ButtonChiudi.png")));
		ButtonChiudi.setBounds(295, 38, 18, 18);
		contentPane.add(ButtonChiudi);
		
		JButton ButtonIndietro = new JButton("");
		ButtonIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ctrl.ApriLoginDialog(ctrl);
			}
		});
		ButtonIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonIndietro.setIcon(new ImageIcon(LoginAmministratoreDialog.class.getResource("/scrimg/ButtonIndietroAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonIndietro.setIcon(new ImageIcon(LoginAmministratoreDialog.class.getResource("/scrimg/ButtonIndietro.png")));
			}
		});
		ButtonIndietro.setPressedIcon(new ImageIcon(LoginAmministratoreDialog.class.getResource("/scrimg/ButtonIndietro.png")));
		ButtonIndietro.setFocusable(false);
		ButtonIndietro.setOpaque(false);
		ButtonIndietro.setBorder(null);
		ButtonIndietro.setContentAreaFilled(false);
		ButtonIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonIndietro.setIcon(new ImageIcon(LoginAmministratoreDialog.class.getResource("/scrimg/ButtonIndietro.png")));
		ButtonIndietro.setBounds(27, 29, 34, 34);
		contentPane.add(ButtonIndietro);
		
		JButton ButtonVediPassword = new JButton("");
		ButtonVediPassword.setBounds(250, 190, 32, 32);
		ButtonVediPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(visible==false) {
					visible=true;
					ButtonVediPassword.setIcon(new ImageIcon(LoginAmministratoreDialog.class.getResource("/scrimg/ButtonUnviewPassword.png")));
					passwordField.setEchoChar((char) 0);
					passwordField.setFont(new Font("Impact", Font.PLAIN, 13));
				}
				else if(visible==true) {
					visible=false;
					ButtonVediPassword.setIcon(new ImageIcon(LoginAmministratoreDialog.class.getResource("/scrimg/ButtonViewPassword.png")));
					passwordField.setEchoChar('●');
					passwordField.setFont(new Font("Impact", Font.PLAIN, 13));
				}
			}
		});
		ButtonVediPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonVediPassword.setIcon(new ImageIcon(LoginAmministratoreDialog.class.getResource("/scrimg/ButtonViewPassword.png")));
		ButtonVediPassword.setBorder(null);
		ButtonVediPassword.setContentAreaFilled(false);
		contentPane.add(ButtonVediPassword);
		
		textFieldUsername = new JTextField();
		textFieldUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					EffettuaLogin(ctrl);
				}
			}
		});
		textFieldUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textFieldUsername.setText(textFieldUsername.getText().toUpperCase());
			}
		});
		textFieldUsername.setFont(new Font("Impact", Font.PLAIN, 15));
		textFieldUsername.setForeground(new Color(0,41,82));
		textFieldUsername.setOpaque(false);
		textFieldUsername.setSelectedTextColor(new Color (191,215,255));
		textFieldUsername.setSelectionColor(new Color (0,41,82));
		textFieldUsername.setBorder(null);
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(94, 140, 188, 29);
		contentPane.add(textFieldUsername);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					EffettuaLogin(ctrl);
				}
			}
		});
		passwordField.setFont(new Font("Impact", Font.PLAIN, 15));
		passwordField.setForeground(new Color(0,41,82));
		passwordField.setOpaque(false);
		passwordField.setSelectedTextColor(new Color (191,215,255));
		passwordField.setSelectionColor(new Color (0,41,82));
		passwordField.setBorder(null);
		passwordField.setBounds(94, 193, 153, 29);
		contentPane.add(passwordField);
		
		JButton ButtonLogin = new JButton("");
		ButtonLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EffettuaLogin(ctrl);
			}
		});
		ButtonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonLogin.setIcon(new ImageIcon(LoginAmministratoreDialog.class.getResource("/scrimg/ButtonLoginAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonLogin.setIcon(new ImageIcon(LoginAmministratoreDialog.class.getResource("/scrimg/ButtonLogin.png")));
			}
		});
		ButtonLogin.setPressedIcon(new ImageIcon(LoginAmministratoreDialog.class.getResource("/scrimg/ButtonLogin.png")));
		ButtonLogin.setIcon(new ImageIcon(LoginAmministratoreDialog.class.getResource("/scrimg/ButtonLogin.png")));
		ButtonLogin.setFocusable(false);
		ButtonLogin.setOpaque(false);
		ButtonLogin.setBorder(null);
		ButtonLogin.setContentAreaFilled(false);
		ButtonLogin.setBounds(114, 278, 118, 25);
		contentPane.add(ButtonLogin);
		
		JLabel LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(LoginAmministratoreDialog.class.getResource("/scrimg/SfondoLoginAmministratori.png")));
		LabelSfondo.setBounds(-9, 0, 364, 467);
		contentPane.add(LabelSfondo);
		
	}
	
	public void EffettuaLogin(Controller ctrl) {
		if (textFieldUsername.getText().equals("") && passwordField.getText().equals("")) {
			setAlwaysOnTop(false);
			JOptionPane.showMessageDialog(null, "COMPLETARE TUTTI I CAMPI", "", JOptionPane.WARNING_MESSAGE);
			setAlwaysOnTop(true);
		}
		else {
			try {
				if(ctrl.ControllaDatiLogin(textFieldUsername.getText(), passwordField.getText())==null) {
					setAlwaysOnTop(false);
					JOptionPane.showMessageDialog(null, "USERNAME O PASSWORD ERRATI", "", JOptionPane.WARNING_MESSAGE);
					setAlwaysOnTop(true);
				}
				else {
					ctrl.ApriFrameAmministratore(ctrl);
					dispose();
				}
			} catch (HeadlessException | SecurityException e1) {
				e1.printStackTrace();
			}
		}
	}
}
