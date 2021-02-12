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
import java.awt.event.MouseAdapter;

public class FrameAmministratore extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PanelPrincipale;
	private JLabel LabelDeposito;
	private JLabel LabelNegozio;
	private JLabel LabelClienti;
	private JLabel LabelLogout;
	private JLabel LabelSfondoButton;
	private JButton ButtonDeposito;
	private JButton ButtonNegozio;
	private JButton ButtonClienti;
	private JButton ButtonLogout;
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
		
		LabelDeposito = new JLabel("");
		LabelDeposito.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoHomeWhite_32.png")));
		LabelDeposito.setBounds(10, 151, 44, 44);
		PanelPrincipale.add(LabelDeposito);
		
		LabelNegozio = new JLabel("");
		LabelNegozio.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoShopWhite_32.png")));
		LabelNegozio.setBounds(10, 214, 44, 44);
		PanelPrincipale.add(LabelNegozio);
		
		LabelClienti = new JLabel("");
		LabelClienti.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoUserWhite_32.png")));
		LabelClienti.setBounds(10, 280, 44, 44);
		PanelPrincipale.add(LabelClienti);
		
		LabelLogout = new JLabel("");
		LabelLogout.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoLogout_32.png")));
		LabelLogout.setBounds(10, 498, 44, 44);
		PanelPrincipale.add(LabelLogout);
		
		JPanel PanelCaricamento = new JPanel();
		PanelCaricamento.setOpaque(false);
		PanelCaricamento.setBorder(null);
		PanelCaricamento.setBounds(194, 26, 948, 563);
		PanelPrincipale.add(PanelCaricamento);
		PanelCaricamento.setLayout(null);
		
		/*BUTTON DEPOSITO*/
		ButtonDeposito = new JButton("");
		ButtonDeposito.setFocusable(false);
		ButtonDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriDepositoPanel(ctrl, PanelCaricamento);
				CambiaIconaAiButtonFramePrincipale(new String("deposito"));
				aperta=false;
			}
		});
		ButtonDeposito.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonDeposito.setContentAreaFilled(false);
		ButtonDeposito.setBorderPainted(false);
		ButtonDeposito.setVisible(true);
		ButtonDeposito.setOpaque(false);
		ButtonDeposito.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/DepositoWhite.png")));
		ButtonDeposito.setBounds(51, 156, 107, 39);
		PanelPrincipale.add(ButtonDeposito);
		
		/*BUTTON NEGOZIO*/
		ButtonNegozio = new JButton("");
		ButtonNegozio.setFocusable(false);
		ButtonNegozio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriNegozioPanel(ctrl, PanelCaricamento);
				CambiaIconaAiButtonFramePrincipale(new String("negozio"));
				aperta=false;
			}
		});
		ButtonNegozio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonNegozio.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/NegozioWhite.png")));
		ButtonNegozio.setVisible(true);
		ButtonNegozio.setOpaque(false);
		ButtonNegozio.setContentAreaFilled(false);
		ButtonNegozio.setBorderPainted(false);
		ButtonNegozio.setBounds(51, 219, 97, 39);
		PanelPrincipale.add(ButtonNegozio);
		
		/*BUTTON CLIENTI*/
		ButtonClienti = new JButton("");
		ButtonClienti.setFocusable(false);
		ButtonClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriClientiPanel(ctrl, PanelCaricamento);
				CambiaIconaAiButtonFramePrincipale(new String("clienti"));
				aperta=false;
			}
		});
		ButtonClienti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonClienti.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/ClientiWhite.png")));
		ButtonClienti.setVisible(true);
		ButtonClienti.setOpaque(false);
		ButtonClienti.setContentAreaFilled(false);
		ButtonClienti.setBorderPainted(false);
		ButtonClienti.setBounds(51, 285, 82, 39);
		PanelPrincipale.add(ButtonClienti);
		
		/*BUTTON LOGOUT*/
		ButtonLogout = new JButton("");
		ButtonLogout.setFocusable(false);
		ButtonLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambiaIconaAiButtonFramePrincipale(new String("logout"));
				dispose();
				ctrl.ApriLoginFrame(ctrl);
			}
		});
		ButtonLogout.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/LogoutWhite.png")));
		ButtonLogout.setOpaque(false);
		ButtonLogout.setBorder(null);
		ButtonLogout.setContentAreaFilled(false);
		ButtonLogout.setBorderPainted(false);
		ButtonLogout.setBounds(51, 503, 86, 39);
		PanelPrincipale.add(ButtonLogout);
		

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
		PanelPrincipale.add(ButtonHomepage);
		
		LabelSfondoButton = new JLabel("");
		LabelSfondoButton.setVisible(false);
		LabelSfondoButton.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/SfondoButton.png")));
		LabelSfondoButton.setBounds(0, 140, 177, 43);
		PanelPrincipale.add(LabelSfondoButton);
		
		JLabel Sfondo = new JLabel("");
		Sfondo.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/SfondoFrame.png")));
		Sfondo.setBounds(-2, 0, 1162, 600);
		PanelPrincipale.add(Sfondo);
		
		ctrl.ApriAnimazionePanel(ctrl, PanelCaricamento);
	}
	
	public void CambiaIconaAiButtonFramePrincipale(String nome) {
		if(nome.equals("deposito")) {
			LabelDeposito.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IconHouse3D.png")));
			LabelNegozio.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoShopWhite_32.png")));
			LabelClienti.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoUserWhite_32.png")));
			LabelLogout.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoLogout_32.png")));
			LabelSfondoButton.setVisible(true);
			LabelSfondoButton.setBounds(-1, 147, 177, 43);
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
			LabelSfondoButton.setBounds(-1, 210, 177, 43);
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
			LabelSfondoButton.setBounds(-1, 277, 177, 43);
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
			LabelSfondoButton.setBounds(-1, 400, 177, 43);
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
