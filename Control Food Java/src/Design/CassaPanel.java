package Design;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import ExternalClasses.VerticalScrollBarUI;
import Main.Controller;
import Objects.Prodotto;

public class CassaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Prodotto> prodotti;
	private JLabel LabelIntestazione;
	private JLabel LabelTotale;
	private JLabel LabelTotaleNumero;
	private JButton ButtonPagaConCarta;
	private JButton ButtonPagaInContanti;
	private JLabel LabelSfondo;
	private JPanel PanelCaricamento;
	private int grandezza = -200;
	private JScrollPane scrollPane;
	private JLabel LabelNomiProdotti;
	private JLabel LabelQuantita;
	private JLabel LabelPrezzo;
	private JLabel LabelPunti;
	private JLabel LabelPuntiNumero;

	public CassaPanel(Controller ctrl) {
		
		setForeground(Color.GRAY);
		setFont(new Font("Impact", Font.PLAIN, 11));
		
		setOpaque(false);
		setBackground(new Color(0, 80, 157));
		setBounds(77, 0, 836, 569);
		setLayout(null);
		LabelIntestazione = new JLabel("Lista dei prodotti nel carrello:");
		LabelIntestazione.setBounds(40, 35, 271, 32);
		LabelIntestazione.setFont(new Font("Cambria", Font.BOLD, 20));
		LabelIntestazione.setForeground(new Color(0, 41, 82));
		add(LabelIntestazione);
		
		/*LABEL TOTALE*/
		LabelTotale = new JLabel("Totale");
		LabelTotale.setBounds(631, 505, 68, 23);
		LabelTotale.setFont(new Font("Cambria", Font.BOLD, 19));
		LabelTotale.setForeground(new Color(0, 41, 82));
		LabelTotale.setHorizontalAlignment(SwingConstants.CENTER);
		add(LabelTotale);
		
		/*LABEL TOTALE NUMERO*/
		LabelTotaleNumero = new JLabel("0.0�");
		LabelTotaleNumero.setBounds(709, 505, 68, 23);
		LabelTotaleNumero.setFont(new Font("Cambria", Font.BOLD, 19));
		LabelTotaleNumero.setForeground(new Color(0, 41, 82));
		LabelTotaleNumero.setHorizontalAlignment(SwingConstants.CENTER);
		add(LabelTotaleNumero);
		
		/*LABEL NOMI PRODOTTI*/
		LabelNomiProdotti = new JLabel("Nomi Prodotti");
		LabelNomiProdotti.setFont(new Font("Cambria", Font.BOLD, 17));
		LabelNomiProdotti.setForeground(new Color(0, 41, 82));
		LabelNomiProdotti.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0,41,82)));
		LabelNomiProdotti.setBounds(40, 78, 118, 21);
		add(LabelNomiProdotti);
		
		/*LABEL QUANTITA*/
		LabelQuantita = new JLabel("Quantit\u00E0");
		LabelQuantita.setFont(new Font("Cambria", Font.BOLD, 17));
		LabelQuantita.setForeground(new Color(0, 41, 82));
		LabelQuantita.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0,41,82)));
		LabelQuantita.setBounds(556, 78, 68, 21);
		add(LabelQuantita);
		
		/*LABEL PREZZO*/
		LabelPrezzo = new JLabel("Prezzo");
		LabelPrezzo.setFont(new Font("Cambria", Font.BOLD, 17));
		LabelPrezzo.setForeground(new Color(0, 41, 82));
		LabelPrezzo.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0,41,82)));
		LabelPrezzo.setBounds(679, 78, 53, 21);
		add(LabelPrezzo);
		
		/*LABEL PUNTI*/
		LabelPunti = new JLabel("Punti");
		LabelPunti.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPunti.setFont(new Font("Cambria", Font.BOLD, 19));
		LabelPunti.setForeground(new Color(0, 41, 82));
		LabelPunti.setSize(65, 14);
		LabelPunti.setLocation(40, 509);
		add(LabelPunti);
		
		LabelPuntiNumero = new JLabel();
		LabelPuntiNumero.setText("0.00");
		LabelPuntiNumero.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPuntiNumero.setFont(new Font("Cambria", Font.BOLD, 19));
		LabelPuntiNumero.setForeground(new Color(0, 41, 82));
		LabelPuntiNumero.setSize(65, 14);
		LabelPuntiNumero.setLocation(118, 509);
		add(LabelPuntiNumero);
	
		/*BUTTON PAGA CON CARTA*/
		ButtonPagaConCarta = new JButton("");
		ButtonPagaConCarta.setBounds(679, 35, 98, 30);
		ButtonPagaConCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriPagamentoConCartaDialog(ctrl);
			}
		});
		ButtonPagaConCarta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonPagaConCarta.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaConCartaAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonPagaConCarta.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaConCarta.png")));
			}
		});
		ButtonPagaConCarta.setSelectedIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaConCarta.png")));
		ButtonPagaConCarta.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaConCarta.png")));
		ButtonPagaConCarta.setDisabledIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaConCarta.png")));
		ButtonPagaConCarta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonPagaConCarta.setOpaque(false);
		ButtonPagaConCarta.setBorder(null);
		ButtonPagaConCarta.setContentAreaFilled(false);
		add(ButtonPagaConCarta);
		
		/*BUTTON PAGA IN CONTANTI*/
		ButtonPagaInContanti = new JButton("");
		ButtonPagaInContanti.setBounds(556, 35, 98, 32);
		ButtonPagaInContanti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriPagamentoInContantiDialog(ctrl);
			}
		});
		ButtonPagaInContanti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonPagaInContanti.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaInContantiAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonPagaInContanti.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaInContanti.png")));
			}
		});
		ButtonPagaInContanti.setSelectedIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaInContanti.png")));
		ButtonPagaInContanti.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaInContanti.png")));
		ButtonPagaInContanti.setDisabledIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaInContanti.png")));
		ButtonPagaInContanti.setBorder(null);
		ButtonPagaInContanti.setOpaque(false);
		ButtonPagaInContanti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonPagaInContanti.setContentAreaFilled(false);
		add(ButtonPagaInContanti);
		
		/*PANEL CARICAMENTO*/
		PanelCaricamento = new JPanel();
		PanelCaricamento.setAlignmentY(50.0f);
		PanelCaricamento.setBounds(40, 115, 737, 379);
		PanelCaricamento.setPreferredSize(new Dimension(737,grandezza));
		PanelCaricamento.setBackground(new Color(191,215,255));
		PanelCaricamento.setLayout(null);
		
		
		/*SCROLLPANE*/
		scrollPane = new JScrollPane(PanelCaricamento);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUI(new VerticalScrollBarUI());
		scrollPane.setBackground(new Color(191, 215, 255));
		scrollPane.setBounds(40, 115, 737, 379);
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0,41,82),  new Color(0,41,82)));
		add(scrollPane);
		
		/*LABEL SFONDO*/
		LabelSfondo = new JLabel("");
		LabelSfondo.setBounds(-2, -2, 836, 569);
		LabelSfondo.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/SfondoPanel.png")));
		add(LabelSfondo);
		
		TotaleSpesa(ctrl);
		ControlloTotale();
	}
	
	private void TotaleSpesa(Controller ctrl) {
		prodotti=ctrl.CaricaProdottiCarrello();
		Double totale = 0.0;
		int y=10;
		for(int i=0; i<prodotti.size(); i++) {
			JLabel nome = new JLabel();
			nome.setText(prodotti.get(i).getNome());
			nome.setHorizontalAlignment(SwingConstants.CENTER);
			nome.setFont(new Font("Cambria", Font.BOLD, 17));
			nome.setForeground(new Color(0, 41, 82));
			nome.setSize(200, 25);
			nome.setLocation(10, y);
			PanelCaricamento.add(nome);
			
			JLabel quantita = new JLabel();
			quantita.setText(Integer.toString(prodotti.get(i).getQuantita()));
			quantita.setHorizontalAlignment(SwingConstants.CENTER);
			quantita.setFont(new Font("Cambria", Font.BOLD, 17));
			quantita.setForeground(new Color(0, 41, 82));
			quantita.setSize(65, 14);
			quantita.setLocation(520, y);
			PanelCaricamento.add(quantita);
			
			JLabel prezzo = new JLabel();
			prezzo.setText(Double.toString(prodotti.get(i).getPrezzo())+ "�");
			prezzo.setHorizontalAlignment(SwingConstants.CENTER);
			prezzo.setFont(new Font("Cambria", Font.BOLD, 17));
			prezzo.setForeground(new Color(0, 41, 82));
			prezzo.setSize(65, 14);
			prezzo.setLocation(635, y);
			PanelCaricamento.add(prezzo);
			
			totale = totale + (prodotti.get(i).getPrezzo() * prodotti.get(i).getQuantita());
			y=y+30;
			
			grandezza=grandezza + 50; 
			PanelCaricamento.setPreferredSize(new Dimension(737,grandezza));
					
			PanelCaricamento.revalidate();
			PanelCaricamento.repaint();
		}
		LabelPuntiNumero.setText(ctrl.Arrotonda(totale*0.10, 2)+"");
		LabelTotaleNumero.setText(ctrl.Arrotonda(totale, 2)+"�");
	}
	
	private void ControlloTotale() {
		if(LabelTotaleNumero.getText().equals("0.0�")) {
			ButtonPagaConCarta.setEnabled(false);
			ButtonPagaInContanti.setEnabled(false);
		}
		else {
			ButtonPagaConCarta.setEnabled(true);
			ButtonPagaInContanti.setEnabled(true);
		}
	}
}
