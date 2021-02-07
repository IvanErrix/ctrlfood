package Design;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Main.Controller;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;

public class FrameAmministratore extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PanelPrincipale;
	private Boolean aperta = true;

	public FrameAmministratore(Controller ctrl) {
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
		
		JButton ButtonDeposito = new JButton("");
		JButton ButtonNegozio = new JButton("");
		JButton ButtonClienti = new JButton("");
		
		JPanel panelAmministatore = new JPanel();
		panelAmministatore.setBounds(20, 126, 235, 326);
		PanelPrincipale.add(panelAmministatore);
		panelAmministatore.setOpaque(false);
		panelAmministatore.setBorder(null);
		panelAmministatore.setLayout(null);
		
		JPanel panelClienti = new JPanel();
		panelClienti.setVisible(false);
		panelClienti.setBounds(20, 126, 235, 200);
		PanelPrincipale.add(panelClienti);
		panelClienti.setOpaque(false);
		panelClienti.setBorder(null);
		panelClienti.setLayout(null);
		
		JLabel LabelDeposito = new JLabel("");
		LabelDeposito.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoHomeWhite_32.png")));
		LabelDeposito.setBounds(10, 48, 53, 55);
		panelAmministatore.add(LabelDeposito);
		
		JLabel LabelNegozio = new JLabel("");
		LabelNegozio.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoShopWhite_32.png")));
		LabelNegozio.setBounds(10, 121, 53, 55);
		panelAmministatore.add(LabelNegozio);
		
		JLabel LabelClienti = new JLabel("");
		LabelClienti.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoUserWhite_32.png")));
		LabelClienti.setBounds(10, 187, 53, 55);
		panelAmministatore.add(LabelClienti);
		
		JPanel PanelCaricamento = new JPanel();
		PanelCaricamento.setOpaque(false);
		PanelCaricamento.setBorder(null);
		PanelCaricamento.setBounds(388, 36, 754, 553);
		PanelPrincipale.add(PanelCaricamento);
		PanelCaricamento.setLayout(null);
		
		JButton ButtonIndietro = new JButton("");
		ButtonIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ctrl.ApriLoginDialog(ctrl);
			}
		});
		ButtonIndietro.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ButtonIndietroAzzurro.png")));
		ButtonIndietro.setOpaque(false);
		ButtonIndietro.setBorder(null);
		ButtonIndietro.setContentAreaFilled(false);
		ButtonIndietro.setBounds(246, 36, 34, 34);
		PanelPrincipale.add(ButtonIndietro);
		
		/*BUTTON DEPOSITO*/
		ButtonDeposito.setFocusable(false);
		ButtonDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriDepositoPanel(ctrl, PanelCaricamento);
				ctrl.CambiaIconaAiButtonFramePrincipale(new String("deposito"), LabelDeposito, LabelNegozio, LabelClienti,
						ButtonDeposito, ButtonNegozio, ButtonClienti);
				aperta=false;
			}
		});
		ButtonDeposito.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonDeposito.setContentAreaFilled(false);
		ButtonDeposito.setBorderPainted(false);
		ButtonDeposito.setVisible(true);
		ButtonDeposito.setOpaque(false);
		ButtonDeposito.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/DepositoWhite.png")));
		ButtonDeposito.setBounds(53, 58, 143, 45);
		panelAmministatore.add(ButtonDeposito);
		
		/*BUTTON NEGOZIO*/
		ButtonNegozio.setFocusable(false);
		ButtonNegozio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriNegozioPanel(ctrl, PanelCaricamento);
				ctrl.CambiaIconaAiButtonFramePrincipale(new String("negozio"), LabelDeposito, LabelNegozio, LabelClienti,
						ButtonDeposito, ButtonNegozio, ButtonClienti);
				aperta=false;
			}
		});
		ButtonNegozio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonNegozio.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/NegozioWhite.png")));
		ButtonNegozio.setVisible(true);
		ButtonNegozio.setOpaque(false);
		ButtonNegozio.setContentAreaFilled(false);
		ButtonNegozio.setBorderPainted(false);
		ButtonNegozio.setBounds(53, 131, 129, 45);
		panelAmministatore.add(ButtonNegozio);
		
		/*BUTTON CLIENTI*/
		ButtonClienti.setFocusable(false);
		ButtonClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriClientiPanel(ctrl, PanelCaricamento);
				ctrl.CambiaIconaAiButtonFramePrincipale(new String("clienti"), LabelDeposito, LabelNegozio, LabelClienti,
						ButtonDeposito, ButtonNegozio, ButtonClienti);
				aperta=false;
			}
		});
		ButtonClienti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonClienti.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ClientiWhite.png")));
		ButtonClienti.setVisible(true);
		ButtonClienti.setOpaque(false);
		ButtonClienti.setContentAreaFilled(false);
		ButtonClienti.setBorderPainted(false);
		ButtonClienti.setBounds(53, 197, 115, 45);
		panelAmministatore.add(ButtonClienti);
		

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
					ctrl.CambiaIconaAiButtonFramePrincipale(new String("homepage"), LabelDeposito, LabelNegozio, LabelClienti, 
							ButtonDeposito, ButtonNegozio, ButtonClienti);
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
