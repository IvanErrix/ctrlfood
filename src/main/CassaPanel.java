package main;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.Cursor;

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
		ButtonTotale.setBounds(628, 78, 68, 23);
		add(ButtonTotale);
		
		JLabel ButtonTotaleNumero = new JLabel("0");
		ButtonTotaleNumero.setFont(new Font("Impact", Font.PLAIN, 19));
		ButtonTotaleNumero.setForeground(new Color(255, 213, 0));
		ButtonTotaleNumero.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonTotaleNumero.setBounds(628, 127, 68, 23);
		add(ButtonTotaleNumero);
		
		JButton ButtonPaga = new JButton("");
		ButtonPaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriPagamentoConCartaDialog(ctrl);
			}
		});
		ButtonPaga.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPaga.png")));
		ButtonPaga.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonPaga.setBounds(619, 194, 105, 25);
		ButtonPaga.setOpaque(false);
		ButtonPaga.setBorder(null);
		ButtonPaga.setContentAreaFilled(false);
		add(ButtonPaga);
		
		JScrollPane scrollPaneProdottiCarrello = new JScrollPane();
		scrollPaneProdottiCarrello.setOpaque(false);
		scrollPaneProdottiCarrello.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneProdottiCarrello.setBounds(10, 78, 578, 470);
		add(scrollPaneProdottiCarrello);
		
		JLabel ButtonListaProdotti = new JLabel("Lista dei prodotti nel carrello:");
		ButtonListaProdotti.setFont(new Font("Impact", Font.PLAIN, 19));
		ButtonListaProdotti.setForeground(new Color(255, 213, 0));
		ButtonListaProdotti.setBounds(10, 35, 239, 32);
		add(ButtonListaProdotti);
	}
}
