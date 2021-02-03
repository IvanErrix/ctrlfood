package Design;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Main.Controller;

import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Cursor;

public class LoginAmministratoreDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;

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
		
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Impact", Font.PLAIN, 15));
		textFieldUsername.setForeground(new Color(0,41,82));
		textFieldUsername.setOpaque(false);
		textFieldUsername.setBorder(null);
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(94, 136, 188, 29);
		contentPane.add(textFieldUsername);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Impact", Font.PLAIN, 15));
		passwordField.setForeground(new Color(0,41,82));
		passwordField.setOpaque(false);
		passwordField.setBorder(null);
		passwordField.setBounds(94, 193, 188, 29);
		contentPane.add(passwordField);
		
		JButton ButtonLogin = new JButton("");
		ButtonLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriFramePrincipale(ctrl);
				setVisible(false);
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
}
