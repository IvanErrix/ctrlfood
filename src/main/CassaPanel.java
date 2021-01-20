package main;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CassaPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public CassaPanel(Controller ctrl) {
		
		setForeground(Color.GRAY);
		setFont(new Font("Impact", Font.PLAIN, 11));
		
		setOpaque(false);
		setBackground(new Color(0, 80, 157));
		setBounds(0, 0, 765, 600);
		setLayout(null);
		
		JLabel ButtonTotale = new JLabel("Totale");
		ButtonTotale.setFont(new Font("Impact", Font.PLAIN, 19));
		ButtonTotale.setForeground(new Color(255, 213, 0));
		ButtonTotale.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonTotale.setBounds(640, 107, 68, 23);
		add(ButtonTotale);
		
		JLabel ButtonTotaleNumero = new JLabel("0");
		ButtonTotaleNumero.setFont(new Font("Impact", Font.PLAIN, 19));
		ButtonTotaleNumero.setForeground(new Color(255, 213, 0));
		ButtonTotaleNumero.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonTotaleNumero.setBounds(640, 141, 68, 23);
		add(ButtonTotaleNumero);
		
		JButton ButtonPagaConCarta = new JButton("");
		ButtonPagaConCarta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonPagaConCarta.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaConCartaYellow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonPagaConCarta.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaConCarta.png")));
			}
		});
		ButtonPagaConCarta.setSelectedIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaConCarta.png")));
		ButtonPagaConCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriPagamentoConCartaDialog(ctrl);
			}
		});
		ButtonPagaConCarta.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaConCarta.png")));
		ButtonPagaConCarta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonPagaConCarta.setBounds(620, 195, 113, 36);
		ButtonPagaConCarta.setOpaque(false);
		ButtonPagaConCarta.setBorder(null);
		ButtonPagaConCarta.setContentAreaFilled(false);
		add(ButtonPagaConCarta);
		
		JScrollPane scrollPaneProdottiCarrello = new JScrollPane();
		scrollPaneProdottiCarrello.setBackground(new Color(0, 67, 137));
		scrollPaneProdottiCarrello.getViewport().setBackground(new Color(0, 67, 137));
		scrollPaneProdottiCarrello.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		scrollPaneProdottiCarrello.setOpaque(false);
		scrollPaneProdottiCarrello.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneProdottiCarrello.setBounds(10, 78, 578, 470);
		add(scrollPaneProdottiCarrello);
		
		JLabel ButtonListaProdotti = new JLabel("Lista dei prodotti nel carrello:");
		ButtonListaProdotti.setFont(new Font("Impact", Font.PLAIN, 19));
		ButtonListaProdotti.setForeground(new Color(255, 213, 0));
		ButtonListaProdotti.setBounds(10, 35, 239, 32);
		add(ButtonListaProdotti);
		
		JButton ButtonPagaInContanti = new JButton("");
		ButtonPagaInContanti.setSelectedIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaInContanti.png")));
		ButtonPagaInContanti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonPagaInContanti.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaInContantiYellow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonPagaInContanti.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaInContanti.png")));
			}
		});
		ButtonPagaInContanti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonPagaInContanti.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaInContanti.png")));
		ButtonPagaInContanti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "PAGAMENTO AVVENUTO CON SUCCESSO", "", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		ButtonPagaInContanti.setBorder(null);
		ButtonPagaInContanti.setOpaque(false);
		ButtonPagaInContanti.setContentAreaFilled(false);
		ButtonPagaInContanti.setBounds(620, 259, 113, 36);
		add(ButtonPagaInContanti);
	}
}
