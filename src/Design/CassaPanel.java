package Design;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.border.EtchedBorder;

import Main.Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CassaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel LabelIntestazione;
	private JLabel LabelTotale;
	private JLabel LabelTotaleNumero;
	private JButton ButtonPagaConCarta;
	private JButton ButtonPagaInContanti;
	private JScrollPane scrollPaneProdottiCarrello;
	private JLabel LabelSfondo;

	public CassaPanel(Controller ctrl) {
		
		setForeground(Color.GRAY);
		setFont(new Font("Impact", Font.PLAIN, 11));
		
		setOpaque(false);
		setBackground(new Color(0, 80, 157));
		setBounds(77, 0, 836, 569);
		setLayout(null);
		
		/*LABEL INTESTAZIONE*/
		LabelIntestazione = new JLabel("Lista dei prodotti nel carrello:");
		LabelIntestazione.setFont(new Font("Cambria", Font.BOLD, 20));
		LabelIntestazione.setForeground(new Color(0, 41, 82));
		LabelIntestazione.setBounds(40, 35, 271, 32);
		add(LabelIntestazione);
		
		/*LABEL TOTALE*/
		LabelTotale = new JLabel("Totale");
		LabelTotale.setFont(new Font("Cambria", Font.BOLD, 19));
		LabelTotale.setForeground(new Color(0, 41, 82));
		LabelTotale.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTotale.setBounds(631, 505, 68, 23);
		add(LabelTotale);
		
		/*LABEL TOTALE NUMERO*/
		LabelTotaleNumero = new JLabel("0 \u20AC");
		LabelTotaleNumero.setFont(new Font("Cambria", Font.BOLD, 19));
		LabelTotaleNumero.setForeground(new Color(0, 41, 82));
		LabelTotaleNumero.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTotaleNumero.setBounds(709, 505, 68, 23);
		add(LabelTotaleNumero);
		
		/*BUTTON PAGA CON CARTA*/
		ButtonPagaConCarta = new JButton("");
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
		ButtonPagaConCarta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonPagaConCarta.setBounds(679, 35, 98, 30);
		ButtonPagaConCarta.setOpaque(false);
		ButtonPagaConCarta.setBorder(null);
		ButtonPagaConCarta.setContentAreaFilled(false);
		add(ButtonPagaConCarta);
		
		/*BUTTON PAGA IN CONTANTI*/
		ButtonPagaInContanti = new JButton("");
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
		ButtonPagaInContanti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonPagaInContanti.setSelectedIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaInContanti.png")));
		ButtonPagaInContanti.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaInContanti.png")));
		ButtonPagaInContanti.setBorder(null);
		ButtonPagaInContanti.setOpaque(false);
		ButtonPagaInContanti.setContentAreaFilled(false);
		ButtonPagaInContanti.setBounds(556, 35, 98, 32);
		add(ButtonPagaInContanti);
		
		/*SCROLLPANE PRODOTTI CARRELLO*/
		scrollPaneProdottiCarrello = new JScrollPane();
		scrollPaneProdottiCarrello.setBackground(new Color(191, 215, 255));
		scrollPaneProdottiCarrello.getViewport().setBackground(new Color(191, 215, 255));
		scrollPaneProdottiCarrello.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 41, 82), new Color(0, 41, 82)));
		scrollPaneProdottiCarrello.setOpaque(false);
		scrollPaneProdottiCarrello.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneProdottiCarrello.setBounds(40, 78, 737, 416);
		add(scrollPaneProdottiCarrello);
		
		/*LABEL SFONDO*/
		LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/SfondoPanel.png")));
		LabelSfondo.setBounds(-2, -2, 836, 569);
		add(LabelSfondo);
	}
}
