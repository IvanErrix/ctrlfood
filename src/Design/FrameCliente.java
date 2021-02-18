package Design;

import java.awt.Color;
import java.awt.Cursor;
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

import ExternalClasses.ContentPane;
import Main.Controller;

public class FrameCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private ContentPane contentPane;
	private JPanel PanelCaricamento;
	private JLabel LabelCarrello;
	private JLabel LabelCassa;
	private JLabel LabelEsci;
	private JButton ButtonChiudi;
	private JButton ButtonRiduci;
	private JButton ButtonHomepage;
	private JButton ButtonEsci;
	private JButton ButtonCarrello;
	private JButton ButtonCassa;
	private JLabel LabelSfondoButton;
	private JLabel LabelSfondo;
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
		
		/*CONTENTPANE*/
		contentPane = new ContentPane();
		setContentPane(contentPane);
		getContentPane().isOpaque();
		setBackground(new Color(0, 67, 137, 0));
		contentPane.setLayout(null);
		
		/*PANEL CARICAMENTO*/
		PanelCaricamento = new JPanel();
		PanelCaricamento.setOpaque(false);
		PanelCaricamento.setBorder(null);
		PanelCaricamento.setBounds(194, 26, 948, 563);
		PanelCaricamento.setLayout(null);
		getContentPane().add(PanelCaricamento);
		
		/*LABEL CARRELLO*/
		LabelCarrello = new JLabel("");
		LabelCarrello.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/IcoShoppingCartWhite_32.png")));
		LabelCarrello.setBounds(10, 151, 44, 44);
		getContentPane().add(LabelCarrello);
		
		/*LABEL CASSA*/
		LabelCassa = new JLabel("");
		LabelCassa.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/CheckoutWhite_32.png")));
		LabelCassa.setBounds(10, 214, 44, 44);
		getContentPane().add(LabelCassa);
		
		/*LABEL ESCI*/
		LabelEsci = new JLabel("");
		LabelEsci.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/IcoExitWhite_32.png")));
		LabelEsci.setBounds(10, 463, 32, 32);
		getContentPane().add(LabelEsci);
	
		/*BUTTON INDIETRO*/
		ButtonEsci = new JButton("");
		ButtonEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ctrl.EliminaCarrelliNonPagati();
				CambiaIconaAiButtonFrameClienti(new String("esci"));
				ctrl.ApriLoginFrame(ctrl);
			}
		});
		ButtonEsci.setFocusable(false);
		ButtonEsci.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonEsci.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/EsciWhite.png")));
		ButtonEsci.setOpaque(false);
		ButtonEsci.setBorder(null);
		ButtonEsci.setContentAreaFilled(false);
		ButtonEsci.setBorderPainted(false);
		ButtonEsci.setBounds(52, 456, 54, 39);
		getContentPane().add(ButtonEsci);
		
		/*BUTTON CARRELLO*/
		ButtonCarrello = new JButton("");
		ButtonCarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriCarrelloPanel(ctrl, PanelCaricamento);
				CambiaIconaAiButtonFrameClienti(new String("carrello"));
				aperta=false;

			}
			
		});
		ButtonCarrello.setFocusable(false);
		ButtonCarrello.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonCarrello.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/CarrelloWhite.png")));
		ButtonCarrello.setOpaque(false);
		ButtonCarrello.setContentAreaFilled(false);
		ButtonCarrello.setBorderPainted(false);
		ButtonCarrello.setBounds(51, 156, 98, 39);
		getContentPane().add(ButtonCarrello);
		
		/*BUTTONCASSA*/ 
		ButtonCassa = new JButton("");
		ButtonCassa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriCassaPanel(ctrl, PanelCaricamento);
				CambiaIconaAiButtonFrameClienti(new String("cassa"));
				aperta=false;

			}
		});
		ButtonCassa.setFocusable(false);
		ButtonCassa.setBounds(51, 219, 71, 39);
		ButtonCassa.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/CassaWhite.png")));
		ButtonCassa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonCassa.setContentAreaFilled(false);
		ButtonCassa.setBorderPainted(false);
		ButtonCassa.setOpaque(false);
		ButtonCassa.setFocusable(false);
		getContentPane().add(ButtonCassa);
		
		/*BUTTON CHIUDI*/
		ButtonChiudi = new JButton("");
		ButtonChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.EliminaCarrelliNonPagati();
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
		
		/*BUTTON CHIUDI*/
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
		
		/*BUTTON HOMEPAGE*/
		ButtonHomepage = new JButton("");
		ButtonHomepage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (aperta==false) {
					ctrl.ApriAnimazionePanel(ctrl, PanelCaricamento);
					CambiaIconaAiButtonFrameClienti(new String("homepage"));
					aperta=true;
				}
			}
		});
		ButtonHomepage.setBorder(null);
		ButtonHomepage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonHomepage.setOpaque(false);
		ButtonHomepage.setBounds(10, 5, 160, 55);
		ButtonHomepage.setContentAreaFilled(false);
		ButtonHomepage.setFocusable(false);
		getContentPane().add(ButtonHomepage);
		
		/*LABEL SFONDO BUTTON*/
		LabelSfondoButton = new JLabel("");
		LabelSfondoButton.setVisible(false);
		LabelSfondoButton.setIcon(new ImageIcon(FrameAmministratore.class.getResource("/scrimg/SfondoButton.png")));
		LabelSfondoButton.setBounds(-1, 140, 182, 43);
		getContentPane().add(LabelSfondoButton);
		
		/*LABEL SFONDO*/
		LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/SfondoFrame.png")));
		LabelSfondo.setBounds(-2, 0, 1162, 600);
		getContentPane().add(LabelSfondo);
		
		ctrl.ApriAnimazionePanel(ctrl, PanelCaricamento);
	}
	
	public void CambiaIconaAiButtonFrameClienti(String nome) {
		 if (nome.equals("carrello")) {
			LabelCarrello.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/IconShoppingCart3D.png")));
			LabelCassa.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/CheckoutWhite_32.png")));
			LabelEsci.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/IcoExitWhite_32.png")));
			LabelSfondoButton.setVisible(true);
			LabelSfondoButton.setBounds(-1, 147, 182, 43);
			ButtonCarrello.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/ButtonCarrello.png")));
			ButtonCassa.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/CassaWhite.png")));
			ButtonEsci.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/EsciWhite.png")));
		}
		else if(nome.equals("cassa")) {
			LabelCarrello.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/IcoShoppingCartWhite_32.png")));
			LabelCassa.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/IconCheckout3D.png")));
			LabelEsci.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/IcoExitWhite_32.png")));
			LabelSfondoButton.setVisible(true);
			LabelSfondoButton.setBounds(-1, 210, 182, 43);
			ButtonCarrello.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/CarrelloWhite.png")));
			ButtonCassa.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/ButtonCassa.png")));
			ButtonEsci.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/EsciWhite.png")));
		}
		else if(nome.equals("homepage")) {
			LabelCarrello.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/IcoShoppingCartWhite_32.png")));
			LabelCassa.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/CheckoutWhite_32.png")));
			LabelEsci.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/IcoExitWhite_32.png")));
			LabelSfondoButton.setVisible(false);
			ButtonCarrello.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/CarrelloWhite.png")));
			ButtonCassa.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/CassaWhite.png")));
			ButtonEsci.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/EsciWhite.png")));
		}
		else if(nome.equals("esci")) {
			LabelCarrello.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/IcoShoppingCartWhite_32.png")));
			LabelCassa.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/CheckoutWhite_32.png")));
			LabelEsci.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/IconEsci3D.png")));
			LabelSfondoButton.setVisible(true);
			LabelSfondoButton.setBounds(-1, 400, 182, 43);
			ButtonCarrello.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/CarrelloWhite.png")));
			ButtonCassa.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/CassaWhite.png")));
			ButtonEsci.setIcon(new ImageIcon(FrameCliente.class.getResource("/scrimg/ButtonEsci.png")));
		}
	}
}
