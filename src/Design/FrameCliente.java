package Design;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.Controller;

public class FrameCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PanelPrincipale;
	private Boolean aperta = true;
	
	public FrameCliente(Controller ctrl) {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameAmministratore.class.getResource("/scrimg/logo2.png")));
		setFont(new Font("Impact", Font.BOLD, 14));
		setTitle("CtrlFood");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1152, 600);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);	
		
		PanelPrincipale = new JPanel();
		PanelPrincipale.setBorder(null);
		PanelPrincipale.setLayout(null);
		setContentPane(PanelPrincipale);
		
		JButton ButtonCarrello = new JButton("");
		JButton ButtonCassa = new JButton("");
		
		JPanel panelClienti = new JPanel();
		panelClienti.setBounds(20, 126, 235, 200);
		PanelPrincipale.add(panelClienti);
		panelClienti.setOpaque(false);
		panelClienti.setBorder(null);
		panelClienti.setLayout(null);
		
		JLabel LabelCarrello = new JLabel("");
		LabelCarrello.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoShoppingCartWhite_32.png")));
		LabelCarrello.setBounds(10, 48, 53, 55);
		panelClienti.add(LabelCarrello);
		
		JLabel LabelCassa = new JLabel("");
		LabelCassa.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/CheckoutWhite_32.png")));
		LabelCassa.setBounds(10, 117, 53, 55);
		panelClienti.add(LabelCassa);
		
		JPanel PanelCaricamento = new JPanel();
		PanelCaricamento.setOpaque(false);
		PanelCaricamento.setBorder(null);
		PanelCaricamento.setBounds(388, 36, 754, 553);
		PanelPrincipale.add(PanelCaricamento);
		PanelCaricamento.setLayout(null);
		
		/*BUTTON CARRELLO*/
		ButtonCarrello.setFocusable(false);
		ButtonCarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriCarrelloPanel(ctrl, PanelCaricamento);
				ctrl.CambiaIconaAiButtonFrameClienti(new String("carrello"),LabelCarrello, LabelCassa,  ButtonCarrello, ButtonCassa);
				aperta=false;

			}
			
		});
		ButtonCarrello.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonCarrello.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/CarrelloWhite.png")));
		ButtonCarrello.setOpaque(false);
		ButtonCarrello.setContentAreaFilled(false);
		ButtonCarrello.setBorderPainted(false);
		ButtonCarrello.setBounds(73, 58, 133, 45);
		panelClienti.add(ButtonCarrello);
		
		/*BUTTONCASSA*/ 
		ButtonCassa.setFocusable(false);
		ButtonCassa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriCassaPanel(ctrl, PanelCaricamento);
				ctrl.CambiaIconaAiButtonFrameClienti(new String("cassa"), LabelCarrello, LabelCassa, ButtonCarrello, ButtonCassa);
				aperta=false;

			}
		});
		ButtonCassa.setBounds(73, 127, 109, 45);
		ButtonCassa.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/CassaWhite.png")));
		ButtonCassa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonCassa.setContentAreaFilled(false);
		ButtonCassa.setBorderPainted(false);
		ButtonCassa.setOpaque(false);
		ButtonCassa.setFocusable(false);
		panelClienti.add(ButtonCassa);
		
		JButton ButtonChiudi = new JButton("");
		ButtonChiudi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonChiudi.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ButtonChiudiAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonChiudi.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ButtonChiudi.png")));
			}
		});
		
		ButtonChiudi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonChiudi.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ButtonChiudi.png")));
		ButtonChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		ButtonChiudi.setFocusable(false);
		ButtonChiudi.setOpaque(false);
		ButtonChiudi.setBorder(null);
		ButtonChiudi.setContentAreaFilled(false);
		ButtonChiudi.setBounds(1130, 5, 18, 18);
		PanelPrincipale.add(ButtonChiudi);
		
		JButton ButtonRiduci = new JButton("");
		ButtonRiduci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonRiduci.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ButtonRiduciAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonRiduci.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ButtonRiduci.png")));
			}
		});
		ButtonRiduci.setFocusable(false);
		ButtonRiduci.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonRiduci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		ButtonRiduci.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ButtonRiduci.png")));
		ButtonRiduci.setBounds(1109, 5, 15, 18);
		ButtonRiduci.setOpaque(false);
		ButtonRiduci.setBorder(null);
		ButtonRiduci.setContentAreaFilled(false);
		PanelPrincipale.add(ButtonRiduci);
		
		JButton ButtonHomepage = new JButton("");
		ButtonHomepage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (aperta==false) {
					ctrl.ApriAnimazionePanel(ctrl, PanelCaricamento);
					ctrl.CambiaIconaAiButtonFrameClienti(new String("homepage"),LabelCarrello, LabelCassa, ButtonCarrello,ButtonCassa);
					aperta=true;
				}
			}
		});
		ButtonHomepage.setBorder(null);
		ButtonHomepage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonHomepage.setOpaque(false);
		ButtonHomepage.setBounds(36, 20, 195, 58);
		ButtonHomepage.setContentAreaFilled(false);
		ButtonHomepage.setFocusable(false);
		PanelPrincipale.add(ButtonHomepage);
		
		JLabel Sfondo = new JLabel("");
		Sfondo.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/custom \u2013 1.png")));
		Sfondo.setBounds(0, 0, 1162, 600);
		PanelPrincipale.add(Sfondo);
		
		ctrl.ApriAnimazionePanel(ctrl, PanelCaricamento);
	}

}
