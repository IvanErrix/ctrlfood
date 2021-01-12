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
		setSize(1152, 600);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		PanelPrincipale = new JPanel();
		PanelPrincipale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelPrincipale);
		PanelPrincipale.setLayout(null);
		
		JLabel LabelDepositoYellow = new JLabel("");
		LabelDepositoYellow.setVisible(false);
		LabelDepositoYellow.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoHouseYellow_32.png")));
		LabelDepositoYellow.setBounds(20, 150, 32, 32);
		PanelPrincipale.add(LabelDepositoYellow);
		
		JLabel LabelDepositoWhite = new JLabel("");
		LabelDepositoWhite.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoHomeWhite_32.png")));
		LabelDepositoWhite.setBounds(20, 150, 32, 32);
		PanelPrincipale.add(LabelDepositoWhite);
		
		JLabel LabelNegozioYellow = new JLabel("");
		LabelNegozioYellow.setVisible(false);
		LabelNegozioYellow.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShopYellow_32.png")));
		LabelNegozioYellow.setBounds(20, 215, 32, 32);
		PanelPrincipale.add(LabelNegozioYellow);
		
		JLabel LabelNegozioWhite = new JLabel("");
		LabelNegozioWhite.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShopWhite_32.png")));
		LabelNegozioWhite.setBounds(20, 215, 32, 32);
		PanelPrincipale.add(LabelNegozioWhite);
		
		JLabel LabelClientiYellow = new JLabel("");
		LabelClientiYellow.setVisible(false);
		LabelClientiYellow.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoUserYellow_32.png")));
		LabelClientiYellow.setBounds(20, 290, 32, 32);
		PanelPrincipale.add(LabelClientiYellow);
		
		JLabel LabelClientiWhite = new JLabel("");
		LabelClientiWhite.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoUserWhite_32.png")));
		LabelClientiWhite.setBounds(20, 290, 32, 32);
		PanelPrincipale.add(LabelClientiWhite);
		
		JLabel LabelCarrelloYellow = new JLabel("");
		LabelCarrelloYellow.setVisible(false);
		LabelCarrelloYellow.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShoppingCartYellow_32.png")));
		LabelCarrelloYellow.setBounds(20, 365, 32, 32);
		PanelPrincipale.add(LabelCarrelloYellow);
		
		JLabel LabelCarrelloWhite = new JLabel("");
		LabelCarrelloWhite.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShoppingCartWhite_32.png")));
		LabelCarrelloWhite.setBounds(20, 365, 32, 32);
		PanelPrincipale.add(LabelCarrelloWhite);
		
		JPanel PanelCaricamento = new JPanel();
		PanelCaricamento.setOpaque(false);
		PanelCaricamento.setBorder(null);
		PanelCaricamento.setBounds(386, 0, 765, 571);
		PanelPrincipale.add(PanelCaricamento);
		PanelCaricamento.setLayout(null);
		
		JButton ButtonDeposito = new JButton("");
		ButtonDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriDepositoPanel(ctrl, PanelCaricamento);
				
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
		ButtonNegozio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriNegozioPanel(ctrl, PanelCaricamento);
			}
		});
		ButtonNegozio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Group 2.png")));
		ButtonNegozio.setVisible(true);
		ButtonNegozio.setOpaque(false);
		ButtonNegozio.setContentAreaFilled(false);
		ButtonNegozio.setBorderPainted(false);
		ButtonNegozio.setBounds(74, 215, 137, 52);
		PanelPrincipale.add(ButtonNegozio);
		
		JButton ButtonCliente = new JButton("");
		ButtonCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriClientiPanel(ctrl, PanelCaricamento);
			}
		});
		ButtonCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonCliente.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Group 3.png")));
		ButtonCliente.setVisible(true);
		ButtonCliente.setOpaque(false);
		ButtonCliente.setContentAreaFilled(false);
		ButtonCliente.setBorderPainted(false);
		ButtonCliente.setBounds(74, 290, 128, 52);
		PanelPrincipale.add(ButtonCliente);
		
		JButton ButtonCarrello = new JButton("");
		ButtonCarrello.setVisible(true);
		ButtonCarrello.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Group 4.png")));
		ButtonCarrello.setOpaque(false);
		ButtonCarrello.setContentAreaFilled(false);
		ButtonCarrello.setBorderPainted(false);
		ButtonCarrello.setBounds(74, 365, 141, 52);
		PanelPrincipale.add(ButtonCarrello);
		
		JLabel Sfondo = new JLabel("");
		Sfondo.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Homepage.png")));
		Sfondo.setBounds(0, 0, 1156, 600);
		PanelPrincipale.add(Sfondo);

	}
}
