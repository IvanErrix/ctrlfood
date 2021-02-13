package Design;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ExternalClasses.ContentPane;
import Main.Controller;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public LoginFrame(Controller ctrl) {
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
				ButtonChiudi.setIcon(new ImageIcon(LoginFrame.class.getResource("/scrimg/ButtonChiudiAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonChiudi.setIcon(new ImageIcon(LoginFrame.class.getResource("/scrimg/ButtonChiudi.png")));
			}
		});
		ButtonChiudi.setPressedIcon(new ImageIcon(LoginFrame.class.getResource("/scrimg/ButtonChiudi.png")));
		ButtonChiudi.setFocusable(false);
		ButtonChiudi.setOpaque(false);
		ButtonChiudi.setBorder(null);
		ButtonChiudi.setContentAreaFilled(false);
		ButtonChiudi.setIcon(new ImageIcon(LoginFrame.class.getResource("/scrimg/ButtonChiudi.png")));
		ButtonChiudi.setBounds(295, 38, 18, 18);
		contentPane.add(ButtonChiudi);
		
		JButton ButtonAmministratore = new JButton("");
		ButtonAmministratore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ctrl.ApriLoginAmministratoreDialog(ctrl);
			}
		});
		ButtonAmministratore.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAmministratore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAmministratore.setIcon(new ImageIcon(LoginFrame.class.getResource("/scrimg/ButtonAmministratoreAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAmministratore.setIcon(new ImageIcon(LoginFrame.class.getResource("/scrimg/ButtonAmministratore.png")));
			}
		});
		ButtonAmministratore.setSelectedIcon(new ImageIcon(LoginFrame.class.getResource("/scrimg/ButtonAmministratore.png")));
		ButtonAmministratore.setFocusable(false);
		ButtonAmministratore.setOpaque(false);
		ButtonAmministratore.setBorder(null);
		ButtonAmministratore.setContentAreaFilled(false);
		ButtonAmministratore.setIcon(new ImageIcon(LoginFrame.class.getResource("/scrimg/ButtonAmministratore.png")));
		ButtonAmministratore.setBounds(74, 160, 210, 45);
		contentPane.add(ButtonAmministratore);
		
		JButton ButtonClienti = new JButton("");
		ButtonClienti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ctrl.CreaCarrello();
				ctrl.ApriFrameCliente(ctrl);
			}
		});
		ButtonClienti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonClienti.setIcon(new ImageIcon(LoginFrame.class.getResource("/scrimg/ButtonClienteLoginAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonClienti.setIcon(new ImageIcon(LoginFrame.class.getResource("/scrimg/ButtonClienteLogin.png")));
			}
		});
		ButtonClienti.setPressedIcon(new ImageIcon(LoginFrame.class.getResource("/scrimg/ButtonClienteLogin.png")));
		ButtonClienti.setIcon(new ImageIcon(LoginFrame.class.getResource("/scrimg/ButtonClienteLogin.png")));
		ButtonClienti.setOpaque(false);
		ButtonClienti.setBorder(null);
		ButtonClienti.setContentAreaFilled(false);
		ButtonClienti.setBounds(74, 231, 210, 45);
		contentPane.add(ButtonClienti);
		
		JLabel LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(LoginFrame.class.getResource("/scrimg/SfondoLogin.png")));
		LabelSfondo.setBounds(-9, -9, 377, 491);
		contentPane.add(LabelSfondo);

	}
}
