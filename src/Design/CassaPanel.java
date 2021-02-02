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

	public CassaPanel(Controller ctrl) {
		
		setForeground(Color.GRAY);
		setFont(new Font("Impact", Font.PLAIN, 11));
		
		setOpaque(false);
		setBackground(new Color(0, 80, 157));
		setBounds(0, 0, 754, 553);
		setLayout(null);
		
		JLabel ButtonTotale = new JLabel("Totale");
		ButtonTotale.setFont(new Font("Impact", Font.PLAIN, 19));
		ButtonTotale.setForeground(new Color(0, 41, 82));
		ButtonTotale.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonTotale.setBounds(30, 477, 68, 23);
		add(ButtonTotale);
		
		JLabel ButtonTotaleNumero = new JLabel("0 \u20AC");
		ButtonTotaleNumero.setFont(new Font("Impact", Font.PLAIN, 19));
		ButtonTotaleNumero.setForeground(new Color(0, 41, 82));
		ButtonTotaleNumero.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonTotaleNumero.setBounds(108, 477, 68, 23);
		add(ButtonTotaleNumero);
		
		JButton ButtonPagaConCarta = new JButton("");
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
		ButtonPagaConCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriPagamentoConCartaDialog(ctrl);
			}
		});
		ButtonPagaConCarta.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaConCarta.png")));
		ButtonPagaConCarta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonPagaConCarta.setBounds(585, 477, 98, 30);
		ButtonPagaConCarta.setOpaque(false);
		ButtonPagaConCarta.setBorder(null);
		ButtonPagaConCarta.setContentAreaFilled(false);
		add(ButtonPagaConCarta);
		
		JScrollPane scrollPaneProdottiCarrello = new JScrollPane();
		scrollPaneProdottiCarrello.setBackground(new Color(191, 215, 255));
		scrollPaneProdottiCarrello.getViewport().setBackground(new Color(191, 215, 255));
		scrollPaneProdottiCarrello.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 41, 82), new Color(0, 41, 82)));
		scrollPaneProdottiCarrello.setOpaque(false);
		scrollPaneProdottiCarrello.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneProdottiCarrello.setBounds(40, 78, 643, 382);
		add(scrollPaneProdottiCarrello);
		
		JLabel ButtonListaProdotti = new JLabel("Lista dei prodotti nel carrello:");
		ButtonListaProdotti.setFont(new Font("Impact", Font.PLAIN, 19));
		ButtonListaProdotti.setForeground(new Color(0, 41, 82));
		ButtonListaProdotti.setBounds(40, 35, 239, 32);
		add(ButtonListaProdotti);
		
		JButton ButtonPagaInContanti = new JButton("");
		ButtonPagaInContanti.setSelectedIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaInContanti.png")));
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
		ButtonPagaInContanti.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/ButtonPagaInContanti.png")));
		ButtonPagaInContanti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "PAGAMENTO AVVENUTO CON SUCCESSO", "", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		ButtonPagaInContanti.setBorder(null);
		ButtonPagaInContanti.setOpaque(false);
		ButtonPagaInContanti.setContentAreaFilled(false);
		ButtonPagaInContanti.setBounds(462, 477, 98, 32);
		add(ButtonPagaInContanti);
		
		JLabel LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(CassaPanel.class.getResource("/scrimg/SfondoCassa.png")));
		LabelSfondo.setBounds(0, 0, 748, 552);
		add(LabelSfondo);
	}
}
