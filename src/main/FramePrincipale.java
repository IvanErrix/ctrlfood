package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FramePrincipale extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PanelPrincipale;

	public FramePrincipale(Controller ctrl) {
		setFont(new Font("Impact", Font.BOLD, 14));
		setTitle("CtrlFood");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152, 600);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		PanelPrincipale = new JPanel();
		PanelPrincipale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelPrincipale);
		PanelPrincipale.setLayout(null);
		
		JButton ButtonDeposito = new JButton("");
		ButtonDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriDepositoPanel(ctrl);
			}
		});
		ButtonDeposito.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonDeposito.setContentAreaFilled(false);
		ButtonDeposito.setBorderPainted(false);
		ButtonDeposito.setVisible(true);
		ButtonDeposito.setOpaque(false);
		ButtonDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Group 1.png")));
		ButtonDeposito.setBounds(74, 150, 151, 52);
		PanelPrincipale.add(ButtonDeposito);
		
		JButton ButtonNegozio = new JButton("");
		ButtonNegozio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Group 2.png")));
		ButtonNegozio.setVisible(true);
		ButtonNegozio.setOpaque(false);
		ButtonNegozio.setContentAreaFilled(false);
		ButtonNegozio.setBorderPainted(false);
		ButtonNegozio.setBounds(74, 215, 137, 52);
		PanelPrincipale.add(ButtonNegozio);
		
		JButton ButtonCliente = new JButton("");
		ButtonCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonCliente.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Group 3.png")));
		ButtonCliente.setVisible(false);
		ButtonCliente.setOpaque(false);
		ButtonCliente.setContentAreaFilled(false);
		ButtonCliente.setBorderPainted(false);
		ButtonCliente.setBounds(74, 290, 128, 52);
		PanelPrincipale.add(ButtonCliente);
		
		JButton ButtonCarello = new JButton("");
		ButtonCarello.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonCarello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Group 4.png")));
		ButtonCarello.setVisible(false);
		ButtonCarello.setOpaque(false);
		ButtonCarello.setContentAreaFilled(false);
		ButtonCarello.setBorderPainted(false);
		ButtonCarello.setBounds(74, 365, 141, 52);
		PanelPrincipale.add(ButtonCarello);
		
		JLabel Sfondo = new JLabel("");
		Sfondo.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Homepage.png")));
		Sfondo.setBounds(0, 0, 1156, 600);
		PanelPrincipale.add(Sfondo);
	}
}
