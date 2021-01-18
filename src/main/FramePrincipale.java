package main;

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
import java.awt.Frame;

public class FramePrincipale extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PanelPrincipale;

	public FramePrincipale(Controller ctrl) {
		
		setUndecorated(true);
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
		
		JButton ButtonDeposito = new JButton("");
		ButtonDeposito.setFocusable(false);
		JButton ButtonNegozio = new JButton("");
		ButtonNegozio.setFocusable(false);
		JButton ButtonClienti = new JButton("");
		ButtonClienti.setFocusable(false);
		JButton ButtonCarrello = new JButton("");
		ButtonCarrello.setFocusable(false);
		JButton ButtonCassa = new JButton("");
		
		JLabel LabelDeposito = new JLabel("");
		LabelDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoHomeWhite_32.png")));
		LabelDeposito.setBounds(20, 140, 53, 55);
		PanelPrincipale.add(LabelDeposito);
		
		JLabel LabelNegozio = new JLabel("");
		LabelNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShopWhite_32.png")));
		LabelNegozio.setBounds(20, 205, 53, 55);
		PanelPrincipale.add(LabelNegozio);
		
		JLabel LabelClienti = new JLabel("");
		LabelClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoUserWhite_32.png")));
		LabelClienti.setBounds(20, 280, 53, 55);
		PanelPrincipale.add(LabelClienti);
		
		JLabel LabelCarrello = new JLabel("");
		LabelCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShoppingCartWhite_32.png")));
		LabelCarrello.setBounds(20, 355, 53, 55);
		PanelPrincipale.add(LabelCarrello);
		
		JLabel LabelCassa = new JLabel("");
		LabelCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CheckoutWhite_32.png")));
		LabelCassa.setBounds(20, 434, 53, 55);
		PanelPrincipale.add(LabelCassa);
		
		JPanel PanelCaricamento = new JPanel();
		PanelCaricamento.setOpaque(false);
		PanelCaricamento.setBorder(null);
		PanelCaricamento.setBounds(386, 28, 765, 571);
		PanelPrincipale.add(PanelCaricamento);
		PanelCaricamento.setLayout(null);
		
		/*BUTTON DEPOSITO*/
		ButtonDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriDepositoPanel(ctrl, PanelCaricamento);
				LabelDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IconHouse3D.png")));
				LabelNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShopWhite_32.png")));
				LabelClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoUserWhite_32.png")));
				LabelCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShoppingCartWhite_32.png")));
				LabelCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CheckoutWhite_32.png")));
				ButtonDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ButtonDeposito.png")));
				ButtonNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/NegozioWhite.png")));
				ButtonClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ClientiWhite.png")));
				ButtonCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CarrelloWhite.png")));
				ButtonCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CassaWhite.png")));
			}
		});
		ButtonDeposito.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonDeposito.setContentAreaFilled(false);
		ButtonDeposito.setBorderPainted(false);
		ButtonDeposito.setVisible(true);
		ButtonDeposito.setOpaque(false);
		ButtonDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/DepositoWhite.png")));
		ButtonDeposito.setBounds(74, 150, 131, 36);
		PanelPrincipale.add(ButtonDeposito);
		
		/*BUTTON NEGOZIO*/
		ButtonNegozio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriNegozioPanel(ctrl, PanelCaricamento);
				LabelDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoHomeWhite_32.png")));
				LabelNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IconShop3D.png")));
				LabelClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoUserWhite_32.png")));
				LabelCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShoppingCartWhite_32.png")));
				LabelCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CheckoutWhite_32.png")));
				ButtonDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/DepositoWhite.png")));
				ButtonNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ButtonNegozio.png")));
				ButtonClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ClientiWhite.png")));
				ButtonCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CarrelloWhite.png")));
				ButtonCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CassaWhite.png")));
			}
		});
		ButtonNegozio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/NegozioWhite.png")));
		ButtonNegozio.setVisible(true);
		ButtonNegozio.setOpaque(false);
		ButtonNegozio.setContentAreaFilled(false);
		ButtonNegozio.setBorderPainted(false);
		ButtonNegozio.setBounds(74, 215, 118, 36);
		PanelPrincipale.add(ButtonNegozio);
		
		/*BUTTON CLIENTI*/
		ButtonClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriClientiPanel(ctrl, PanelCaricamento);
				LabelDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoHomeWhite_32.png")));
				LabelNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShopWhite_32.png")));
				LabelClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IconUser3D.png")));
				LabelCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShoppingCartWhite_32.png")));
				LabelCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CheckoutWhite_32.png")));
				ButtonDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/DepositoWhite.png")));
				ButtonNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/NegozioWhite.png")));
				ButtonClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ButtonClienti.png")));
				ButtonCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CarrelloWhite.png")));
				ButtonCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CassaWhite.png")));
			}
		});
		ButtonClienti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ClientiWhite.png")));
		ButtonClienti.setVisible(true);
		ButtonClienti.setOpaque(false);
		ButtonClienti.setContentAreaFilled(false);
		ButtonClienti.setBorderPainted(false);
		ButtonClienti.setBounds(76, 290, 103, 36);
		PanelPrincipale.add(ButtonClienti);
		
		/*BUTTON CARRELLO*/
		ButtonCarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriCarrelloPanel(ctrl, PanelCaricamento);
				LabelDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoHomeWhite_32.png")));
				LabelNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShopWhite_32.png")));
				LabelClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoUserWhite_32.png")));
				LabelCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IconShoppingCart3D.png")));
				LabelCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CheckoutWhite_32.png")));
				ButtonDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/DepositoWhite.png")));
				ButtonNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/NegozioWhite.png")));
				ButtonClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ClientiWhite.png")));
				ButtonCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ButtonCarrello.png")));
				ButtonCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CassaWhite.png")));
				
			}
			
		});
		ButtonCarrello.setVisible(true);
		ButtonCarrello.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CarrelloWhite.png")));
		ButtonCarrello.setOpaque(false);
		ButtonCarrello.setContentAreaFilled(false);
		ButtonCarrello.setBorderPainted(false);
		ButtonCarrello.setBounds(70, 365, 131, 36);
		PanelPrincipale.add(ButtonCarrello);
		
		/*BUTTONCASSA*/ 
		ButtonCassa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriCassaPanel(ctrl, PanelCaricamento);
				LabelDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoHomeWhite_32.png")));
				LabelNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShopWhite_32.png")));
				LabelClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoUserWhite_32.png")));
				LabelCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IcoShoppingCartWhite_32.png")));
				LabelCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/IconCheckout3D.png")));
				ButtonDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/DepositoWhite.png")));
				ButtonNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/NegozioWhite.png")));
				ButtonClienti.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ClientiWhite.png")));
				ButtonCarrello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CarrelloWhite.png")));
				ButtonCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ButtonCassa2.png")));
				
			}
		});
		ButtonCassa.setBounds(71, 434, 106, 66);
		ButtonCassa.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/CassaWhite.png")));
		ButtonCassa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonCassa.setContentAreaFilled(false);
		ButtonCassa.setBorderPainted(false);
		ButtonCassa.setOpaque(false);
		ButtonCassa.setFocusable(false);
		PanelPrincipale.add(ButtonCassa);
		
		JButton ButtonChiudi = new JButton("");
		ButtonChiudi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonChiudi.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ButtonChiudi.png")));
		ButtonChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ButtonChiudi.setFocusable(false);
		ButtonChiudi.setOpaque(false);
		ButtonChiudi.setBorder(null);
		//ButtonChiudi.setContentAreaFilled(false);
		ButtonChiudi.setBounds(1130, 5, 18, 18);
		PanelPrincipale.add(ButtonChiudi);
		
		JButton ButtonRiduci = new JButton("");
		ButtonRiduci.setFocusable(false);
		ButtonRiduci.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonRiduci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		ButtonRiduci.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/ButtonRiduci.png")));
		ButtonRiduci.setBounds(1109, 5, 15, 18);
		ButtonRiduci.setOpaque(false);
		ButtonRiduci.setBorder(null);
		ButtonRiduci.setContentAreaFilled(false);
		PanelPrincipale.add(ButtonRiduci);
		
		JLabel Sfondo = new JLabel("");
		Sfondo.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Homepage.png")));
		Sfondo.setBounds(0, 0, 1162, 600);
		PanelPrincipale.add(Sfondo);
		
		
	}
}
