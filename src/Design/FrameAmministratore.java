package Design;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ExternalClasses.ContentPane;
import Main.Controller;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class FrameAmministratore extends JFrame {

	private static final long serialVersionUID = 1L;
	private ContentPane contentPane;
	private JPanel PanelCaricamento;
	private JLabel LabelDeposito;
	private JLabel LabelNegozio;
	private JLabel LabelClienti;
	private JLabel LabelLogout;
	private JLabel LabelSfondoButton;
	private JButton ButtonHomepage;
	private JButton ButtonDeposito;
	private JButton ButtonNegozio;
	private JButton ButtonClienti;
	private JButton ButtonLogout;
	private JButton ButtonChiudi;
	private JButton ButtonRiduci;
	private JLabel LabelSfondo;
	private Boolean aperta = true;

	public FrameAmministratore(Controller ctrl) {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameAmministratore.class.getResource("/scrimg/logo.png")));
		setFont(new Font("Impact", Font.BOLD, 14));
		setTitle("CtrlFood");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1152, 600);
		getContentPane().setLayout(null);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);	
		
		/*CONTENTPANE*/
		contentPane = new ContentPane();
		setContentPane(contentPane);
		getContentPane().isOpaque();
		setBackground(new Color(0, 67, 137, 0));
		contentPane.setLayout(null);
		
		/*LABEL DEPOSITO*/
		LabelDeposito = new JLabel("");
		LabelDeposito.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoHomeWhite_32.png")));
		LabelDeposito.setBounds(10, 151, 44, 44);
		getContentPane().add(LabelDeposito);
		
		/*LABEL NEGOZIO*/
		LabelNegozio = new JLabel("");
		LabelNegozio.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoShopWhite_32.png")));
		LabelNegozio.setBounds(10, 214, 44, 44);
		getContentPane().add(LabelNegozio);
		
		/*LABEL CLIENTI*/
		LabelClienti = new JLabel("");
		LabelClienti.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoUserWhite_32.png")));
		LabelClienti.setBounds(10, 280, 44, 44);
		getContentPane().add(LabelClienti);
		
		/*LABEL LOGOUT*/
		LabelLogout = new JLabel("");
		LabelLogout.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoLogout_32.png")));
		LabelLogout.setBounds(10, 498, 44, 44);
		getContentPane().add(LabelLogout);
		
		/*PANEL CARICAMENTO*/
		PanelCaricamento = new JPanel();
		PanelCaricamento.setOpaque(false);
		PanelCaricamento.setBorder(null);
		PanelCaricamento.setBounds(194, 26, 948, 563);
		PanelCaricamento.setLayout(null);
		getContentPane().add(PanelCaricamento);
		
		/*BUTTON HOMEPAGE*/
		ButtonHomepage = new JButton("");
		ButtonHomepage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (aperta==false) {
					ctrl.ApriAnimazionePanel(ctrl, PanelCaricamento);
					CambiaIconaAiButtonFramePrincipale(new String("homepage"));
					aperta=true;
				}
			}
		});
		ButtonHomepage.setBorder(null);
		ButtonHomepage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonHomepage.setOpaque(false);
		ButtonHomepage.setBounds(10, 11, 159, 53);
		ButtonHomepage.setContentAreaFilled(false);
		ButtonHomepage.setFocusable(false);
		getContentPane().add(ButtonHomepage);
		
		/*BUTTON DEPOSITO*/
		ButtonDeposito = new JButton("");
		ButtonDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriDepositoPanel(ctrl, PanelCaricamento);
				CambiaIconaAiButtonFramePrincipale(new String("deposito"));
				aperta=false;
			}
		});
		ButtonDeposito.setFocusable(false);
		ButtonDeposito.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonDeposito.setContentAreaFilled(false);
		ButtonDeposito.setBorderPainted(false);
		ButtonDeposito.setVisible(true);
		ButtonDeposito.setOpaque(false);
		ButtonDeposito.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/DepositoWhite.png")));
		ButtonDeposito.setBounds(51, 156, 107, 39);
		getContentPane().add(ButtonDeposito);
		
		/*BUTTON NEGOZIO*/
		ButtonNegozio = new JButton("");
		ButtonNegozio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriNegozioPanel(ctrl, PanelCaricamento);
				CambiaIconaAiButtonFramePrincipale(new String("negozio"));
				aperta=false;
			}
		});
		ButtonNegozio.setFocusable(false);
		ButtonNegozio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonNegozio.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/NegozioWhite.png")));
		ButtonNegozio.setVisible(true);
		ButtonNegozio.setOpaque(false);
		ButtonNegozio.setContentAreaFilled(false);
		ButtonNegozio.setBorderPainted(false);
		ButtonNegozio.setBounds(51, 219, 97, 39);
		getContentPane().add(ButtonNegozio);
		
		/*BUTTON CLIENTI*/
		ButtonClienti = new JButton("");
		ButtonClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriClientiPanel(ctrl, PanelCaricamento);
				CambiaIconaAiButtonFramePrincipale(new String("clienti"));
				aperta=false;
			}
		});
		ButtonClienti.setFocusable(false);
		ButtonClienti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonClienti.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ClientiWhite.png")));
		ButtonClienti.setVisible(true);
		ButtonClienti.setOpaque(false);
		ButtonClienti.setContentAreaFilled(false);
		ButtonClienti.setBorderPainted(false);
		ButtonClienti.setBounds(51, 285, 82, 39);
		getContentPane().add(ButtonClienti);
		
		/*BUTTON LOGOUT*/
		ButtonLogout = new JButton("");
		ButtonLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambiaIconaAiButtonFramePrincipale(new String("logout"));
				dispose();
				ctrl.ApriFrameIniziale(ctrl);
			}
		});
		ButtonLogout.setFocusable(false);
		ButtonLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonLogout.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/LogoutWhite.png")));
		ButtonLogout.setOpaque(false);
		ButtonLogout.setBorder(null);
		ButtonLogout.setContentAreaFilled(false);
		ButtonLogout.setBorderPainted(false);
		ButtonLogout.setBounds(51, 503, 86, 39);
		getContentPane().add(ButtonLogout);
		
		/*BUTTON CHIUDI*/
		ButtonChiudi = new JButton("");
		ButtonChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
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
		ButtonChiudi.setFocusable(false);
		ButtonChiudi.setOpaque(false);
		ButtonChiudi.setBorder(null);
		ButtonChiudi.setContentAreaFilled(false);
		ButtonChiudi.setBounds(1109, 8, 18, 18);
		getContentPane().add(ButtonChiudi);
		
		/*BUTTON RIDUCI*/
		ButtonRiduci = new JButton("");
		ButtonRiduci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
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
		ButtonRiduci.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ButtonRiduci.png")));
		ButtonRiduci.setBounds(1088, 8, 15, 18);
		ButtonRiduci.setOpaque(false);
		ButtonRiduci.setBorder(null);
		ButtonRiduci.setContentAreaFilled(false);
		getContentPane().add(ButtonRiduci);
		
		/*LABEL SFONDO BUTTON*/
		LabelSfondoButton = new JLabel("");
		LabelSfondoButton.setVisible(false);
		LabelSfondoButton.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/SfondoButton.png")));
		LabelSfondoButton.setBounds(2, 140, 182, 43);
		getContentPane().add(LabelSfondoButton);
		
		/*LABEL SFONDO*/
		LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/SfondoFrame.png")));
		LabelSfondo.setBounds(-2, 0, 1162, 600);
		getContentPane().add(LabelSfondo);
		
		ctrl.ApriAnimazionePanel(ctrl, PanelCaricamento);
	}
	
	public void CambiaIconaAiButtonFramePrincipale(String nome) {
		if(nome.equals("deposito")) {
			LabelDeposito.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IconHouse3D.png")));
			LabelNegozio.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoShopWhite_32.png")));
			LabelClienti.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoUserWhite_32.png")));
			LabelLogout.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoLogout_32.png")));
			LabelSfondoButton.setVisible(true);
			LabelSfondoButton.setBounds(-1, 147, 182, 43);
			ButtonDeposito.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ButtonDeposito.png")));
			ButtonNegozio.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/NegozioWhite.png")));
			ButtonClienti.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ClientiWhite.png")));
			ButtonLogout.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/LogoutWhite.png")));

		}
		else if(nome.equals("negozio")) {
			LabelDeposito.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoHomeWhite_32.png")));
			LabelNegozio.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IconShop3D.png")));
			LabelClienti.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoUserWhite_32.png")));
			LabelLogout.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoLogout_32.png")));
			LabelSfondoButton.setVisible(true);
			LabelSfondoButton.setBounds(-1, 210, 182, 43);
			ButtonDeposito.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/DepositoWhite.png")));
			ButtonNegozio.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ButtonNegozio.png")));
			ButtonClienti.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ClientiWhite.png")));
			ButtonLogout.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/LogoutWhite.png")));

		}
		else if(nome.equals("clienti")) {
			LabelDeposito.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoHomeWhite_32.png")));
			LabelNegozio.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoShopWhite_32.png")));
			LabelClienti.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IconUser3D.png")));
			LabelLogout.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoLogout_32.png")));
			LabelSfondoButton.setVisible(true);
			LabelSfondoButton.setBounds(-1, 277, 182, 43);
			ButtonDeposito.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/DepositoWhite.png")));
			ButtonNegozio.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/NegozioWhite.png")));
			ButtonClienti.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ButtonClienti.png")));
			ButtonLogout.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/LogoutWhite.png")));

		}
		else if(nome.equals("logout")) {
			LabelDeposito.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoHomeWhite_32.png")));
			LabelNegozio.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoShopWhite_32.png")));
			LabelClienti.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoUserWhite_32.png")));
			LabelLogout.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IconLogout3D.png")));
			LabelSfondoButton.setVisible(true);
			LabelSfondoButton.setBounds(-1, 400, 182, 43);
			ButtonDeposito.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/DepositoWhite.png")));
			ButtonNegozio.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/NegozioWhite.png")));
			ButtonClienti.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ClientiWhite.png")));
			ButtonLogout.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ButtonLogout.png")));
			
		}
		else if(nome.equals("homepage")) {
			LabelDeposito.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoHomeWhite_32.png")));
			LabelNegozio.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoShopWhite_32.png")));
			LabelClienti.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoUserWhite_32.png")));
			LabelLogout.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoLogout_32.png")));
			LabelSfondoButton.setVisible(false);
			ButtonDeposito.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/DepositoWhite.png")));
			ButtonNegozio.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/NegozioWhite.png")));
			ButtonClienti.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ClientiWhite.png")));
			ButtonLogout.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/LogoutWhite.png")));

		}
	}
}
